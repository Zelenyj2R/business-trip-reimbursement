package controllers;

import Servise.ReimbursementService;
import models.InitialRates;
import models.Rates;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/admin")
public class AdminControllerServlet extends HttpServlet {
    private ReimbursementService reimbursementService;
    private InitialRates initialRates = InitialRates.INITIAL;

    public AdminControllerServlet(ReimbursementService reimbursementService) {
        this.reimbursementService = reimbursementService;
    }

    public ReimbursementService getReimbursementService() {
        return reimbursementService;
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("updateRates".equals(action)) {
            double dailyAllowanceRate = Double.parseDouble(req.getParameter("dailyAllowanceRate"));
            double mileageRate = Double.parseDouble(req.getParameter("mileageRate"));

            Rates rates = reimbursementService.getRates();
            rates.updateRates(dailyAllowanceRate, mileageRate);

            req.setAttribute("updatedRates", rates);
        }

        req.getRequestDispatcher("/WEB-INF/views/admin-view.jsp").forward(req, resp);
    }
}
