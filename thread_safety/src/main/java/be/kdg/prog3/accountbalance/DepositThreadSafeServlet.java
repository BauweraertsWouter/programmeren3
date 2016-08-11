package be.kdg.prog3.accountbalance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DepositThreadSafe")
public class DepositThreadSafeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long initialAccountBalance;
        final Long finalAccountBalance;

        synchronized (this) {
            initialAccountBalance = (Long) this.getServletContext().getAttribute("accountBalance");
            if (initialAccountBalance == null) {
                initialAccountBalance = 0L;
            }

            try {
                // Extremely complicated calculation
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                return;
            }

            finalAccountBalance = initialAccountBalance + 100L;

            this.getServletContext().setAttribute("accountBalance", finalAccountBalance);
        }

        resp.getWriter().printf("<html><head><title>Thread Safe</title></head><body><h1>Account balance before deposit: &euro;%d</h1><h1>Account balance after a deposit of &euro;100: &euro;%d</h1><h1>Number of &euro;100 deposits so far: %d</h1></body></html>", initialAccountBalance, finalAccountBalance, ++DepositCount.count);
    }
}
