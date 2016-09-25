package be.kdg.prog3.blog_jstl.web;

import be.kdg.prog3.blog_jstl.model.Blog;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("blog", new Blog());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
