package be.kdg.prog3.bootservlet.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/ParameterServlet")
public class ParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().printf("<html><head><title>Parameter Servlet</title></head><body>");

        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String key : parameterMap.keySet()) {
            for (String value: parameterMap.get(key)) {
                resp.getWriter().printf("<h1>Key: %s, Value: %s</h1>", key, value);
            }
        }

        resp.getWriter().printf("</body></html>");
    }
}
