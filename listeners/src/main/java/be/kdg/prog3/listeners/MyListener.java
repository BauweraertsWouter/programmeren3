package be.kdg.prog3.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("name", "Jos");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
