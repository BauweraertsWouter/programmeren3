package be.kdg.prog3.blog_jsp.web;

import be.kdg.prog3.blog_jsp.model.Blog;
import be.kdg.prog3.blog_jsp.model.BlogPost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/new")
public class NewBlogPostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String subject = req.getParameter("subject");
        final String body = req.getParameter("body");

        final BlogPost blogPost = new BlogPost(subject, body);

        final Blog blog = (Blog)this.getServletContext().getAttribute("blog");
        blog.addBlogPost(blogPost);

        req.setAttribute("newBlogPost", blogPost);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
}
