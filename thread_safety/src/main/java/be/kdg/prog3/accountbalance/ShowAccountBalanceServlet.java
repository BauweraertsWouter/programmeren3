package be.kdg.prog3.accountbalance;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AccountBalance")
public class ShowAccountBalanceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long accountBalance = (Long)this.getServletContext().getAttribute("accountBalance");
        if (accountBalance == null) {
            accountBalance = 0L;
            this.getServletContext().setAttribute("accountBalance", accountBalance);
        }
        resp.getWriter().printf("<html><head><title>Account Balance</title></head><body><h1>Account balance: &euro;%d</h1><h1>Number of &euro;100 deposits so far: %d</h1></body></html>", accountBalance, DepositCount.count);
    }
}
