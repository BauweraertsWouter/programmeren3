package be.kdg.webapp;

import be.kdg.webapp.model.Blog;
import be.kdg.webapp.model.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Wouter on 6/02/2017.
 */
@WebServlet("/list")
public class BlogListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Blog blog = (Blog)req.getServletContext().getAttribute("blog");
        final List<Post> posts = blog.getBlogPosts();

        req.setAttribute("posts", posts);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/bloglist.jsp");
        dispatcher.forward(req, resp);
    }
}
