import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import controllers.AdminControllerServlet;
import Servise.ReimbursementService;
import models.InitialRates;
import models.Rates;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

public class AdminControllerServletTest {

    @Mock
    private ReimbursementService mockReimbursementService;

    @Mock
    private Rates mockRates;

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Mock
    private RequestDispatcher mockRequestDispatcher;

    private AdminControllerServlet adminControllerServlet;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);

        InitialRates initialRates = InitialRates.INITIAL;
        when(mockRates.getDailyAllowance()).thenReturn(initialRates.getDailyAllowance());
        when(mockRates.getMileageRate()).thenReturn(initialRates.getMileageRate());


        when(mockReimbursementService.getRates()).thenReturn(mockRates);

        when(mockRequest.getParameter("action")).thenReturn("updateRates");
        when(mockRequest.getParameter("dailyAllowanceRate")).thenReturn("15.0");
        when(mockRequest.getParameter("mileageRate")).thenReturn("0.3");
        when(mockRequest.getRequestDispatcher("/WEB-INF/views/admin-view.jsp")).thenReturn(mockRequestDispatcher);

        adminControllerServlet = new AdminControllerServlet(mockReimbursementService);
    }


    @Test
    public void testUpdateRates() throws ServletException, IOException {
        adminControllerServlet.doPost(mockRequest, mockResponse);


        assertEquals(mockRates, adminControllerServlet.getReimbursementService().getRates());
        verify(mockRates).updateRates(15.0, 0.3);
        verify(mockRequestDispatcher).forward(mockRequest, mockResponse);
    }


}
