package be.kdg.webapp.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Wouter on 6/02/2017.
 */
@WebFilter(servletNames = "BlogPostServlet")
public class SimpleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("SimpleFilter is ready for action");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        System.out.println("Houston, we habe a request. Filtering before calling servlet");
        HttpServletRequest request = (HttpServletRequest)req;
        String method  =request.getMethod();
        System.out.println("Called method: " + method);
        String omschrijving = req.getParameter("omschrijving");
        System.out.println("Omschrijving: " + omschrijving);
        chain.doFilter(req, resp);
        System.out.println("Elvis (SimpleFilter) has left the building");
    }

    @Override
    public void destroy() {
        System.out.println("SimpleFilter has left the building!");
    }
}
