import Servise.ReimbursementService;
import controllers.AdminControllerServlet;
import controllers.UserControllerServlet;
import models.InitialRates;
import models.Rates;
//import org.apache.catalina.Server;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;



public class Main {
    public static void main(String[] args) {
        InitialRates initialRates = InitialRates.INITIAL;
        ReimbursementService reimbursementService = new ReimbursementService(initialRates);

        Rates rates = new Rates(initialRates);

        UserControllerServlet userControllerServlet = new UserControllerServlet();
        userControllerServlet.setReimbursementService(reimbursementService);

        AdminControllerServlet adminControllerServlet = new AdminControllerServlet(reimbursementService);

        try {
            Server jettyServer = new Server(8080);

            ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
            context.setContextPath("/");

            context.addServlet(UserControllerServlet.class, "/user/*");
            context.addServlet(AdminControllerServlet.class, "/admin/*");

            jettyServer.setHandler(context);

            jettyServer.start();
            jettyServer.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}