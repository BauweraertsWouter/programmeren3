package be.kdg.prog3.session.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/submit")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String data = req.getParameter("data");
        if (data != null) {
            // Put the data in the session.
            final HttpSession session = req.getSession();
            session.setAttribute("data", data);
            final int time = Integer.parseInt(req.getParameter("time"));
            session.setMaxInactiveInterval(time);
        }

        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String data = (String)req.getSession().getAttribute("data");
        resp.setContentType("text/plain");
        resp.getWriter().print("Je data is \"" + (data == null ? "" : data) + "\".");
    }
}
