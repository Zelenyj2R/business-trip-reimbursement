package controllers;

import Servise.ReimbursementService;
import models.Claim;
import models.Receipt;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/user")
public class UserControllerServlet extends HttpServlet {
    private ReimbursementService reimbursementService;

    public void setReimbursementService(ReimbursementService reimbursementService) {
        this.reimbursementService = reimbursementService;
    }



    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("createClaim".equals(action)) {
            String createClaimPage = createClaimPage();
            req.getRequestDispatcher(createClaimPage).forward(req, resp);
        }

    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("submitClaim".equals(action)) {
            String tripDate = req.getParameter("tripDate");
            List<Receipt> receipts = parseReceipts(req.getParameter("receipts"));
            int numberOfDays = Integer.parseInt(req.getParameter("numberOfDays"));
            double distance = Double.parseDouble(req.getParameter("distance"));

            String resultPage = submitClaim(req, tripDate, receipts, numberOfDays, distance);
            req.getRequestDispatcher(resultPage).forward(req, resp);
        }

    }

    private String createClaimPage() {
        return "/WEB-INF/views/user-view.jsp";
    }

    private String submitClaim(HttpServletRequest req, String tripDate, List<Receipt> receipts, int numberOfDays, double distance) {
        Claim claim = new Claim(LocalDate.parse(tripDate), receipts, numberOfDays, distance);
        double reimbursementAmount = reimbursementService.calculateReimbursement(claim);

        req.setAttribute("claim", claim);
        req.setAttribute("reimbursementAmount", reimbursementAmount);

        return "/WEB-INF/views/reimbursement-result.jsp";
    }

    private List<Receipt> parseReceipts(String receiptsParam) {
        List<Receipt> receipts = new ArrayList<>();

        if (receiptsParam != null && !receiptsParam.isEmpty()) {
            String[] receiptTypes = receiptsParam.split(",");

            for (String receiptType : receiptTypes) {
                receipts.add(new Receipt(receiptType.trim(), 200.0));
            }
        }

        return receipts;
    }
}
