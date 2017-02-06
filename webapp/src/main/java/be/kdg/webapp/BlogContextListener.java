package be.kdg.webapp;

import be.kdg.webapp.model.Blog;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by Wouter on 6/02/2017.
 */
@WebListener
public class BlogContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("blog", new Blog());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
