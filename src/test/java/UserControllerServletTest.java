import static org.mockito.Mockito.*;

import Servise.ReimbursementService;
import controllers.UserControllerServlet;
import models.Claim;
import models.Receipt;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserControllerServletTest {

    @Mock
    private ReimbursementService mockReimbursementService;

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Mock
    private RequestDispatcher mockRequestDispatcher;

    private UserControllerServlet userControllerServlet;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        userControllerServlet = new UserControllerServlet();
        userControllerServlet.setReimbursementService(mockReimbursementService);
    }

    @Test
    public void testSubmitClaim() throws ServletException, IOException {
        // Arrange
        setupMockRequestParametersForSubmitClaim();

        List<Receipt> mockReceipts = new ArrayList<>();
        mockReceipts.add(new Receipt("taxi", 15.0)); // Здесь 15.0 - реальная сумма для такси
        mockReceipts.add(new Receipt("hotel", 100.0)); // Здесь 100.0 - реальная сумма для отеля

        when(mockReimbursementService.calculateReimbursement(any(Claim.class))).thenReturn(100.0);

        when(mockRequest.getRequestDispatcher("/WEB-INF/views/reimbursement-result.jsp")).thenReturn(mockRequestDispatcher);

        // Act
        userControllerServlet.doPost(mockRequest, mockResponse);

        // Assert
        verify(mockReimbursementService).calculateReimbursement(any(Claim.class));
        verify(mockRequest).getRequestDispatcher("/WEB-INF/views/reimbursement-result.jsp");
        verify(mockRequest).setAttribute(eq("claim"), any(Claim.class));
        verify(mockRequest).setAttribute("reimbursementAmount", 100.0);
        verify(mockRequestDispatcher).forward(mockRequest, mockResponse);
    }

    // Другие тесты...

    private void setupMockRequestParametersForSubmitClaim() {
        when(mockRequest.getParameter("action")).thenReturn("submitClaim");
        when(mockRequest.getParameter("tripDate")).thenReturn("2023-06-01");
        when(mockRequest.getParameter("receipts")).thenReturn("taxi,hotel");
        when(mockRequest.getParameter("numberOfDays")).thenReturn("3");
        when(mockRequest.getParameter("distance")).thenReturn("150");
    }
}
