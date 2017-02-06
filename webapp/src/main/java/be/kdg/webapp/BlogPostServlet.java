package be.kdg.webapp;

import be.kdg.webapp.model.Blog;
import be.kdg.webapp.model.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Wouter on 6/02/2017.
 */
@WebServlet("/newBlogPost")
public class BlogPostServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Blog blog = (Blog)this.getServletContext().getAttribute("blog");

        final String jaar = req.getParameter("jaar");
        final String gebruikersnaam = req.getParameter("name");
        final String omschrijving = req.getParameter("omschrijving");
        final String specialisatie = req.getParameter("specialiteit");
        final String url = req.getParameter("url");

        final Post blogPost = new Post(blog.getCounter()+1, jaar, gebruikersnaam, omschrijving, specialisatie, url);
        blog.addBlogPost(blogPost);

        resp.sendRedirect("./list");

    }
}
