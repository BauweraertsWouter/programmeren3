package be.kdg.prog3.dispatch.web;

import be.kdg.prog3.dispatch.model.Blog;
import be.kdg.prog3.dispatch.model.BlogPost;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/list")
public class ListBlogPostServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.write("<!DOCTYPE html>\n");
        pw.write("<html lang=\"en\">\n");
        pw.write("<head>\n");
        pw.write("    <meta charset=\"UTF-8\">\n");
        pw.write("    <title>Blog Posts</title>\n");
        pw.write("</head>\n");
        pw.write("<body>\n");
        pw.write("\n");

        final Blog blog = (Blog)this.getServletContext().getAttribute("blog");
        BlogPost newBlogPost = (BlogPost)req.getAttribute("newBlogPost");
        BlogPost blogPost;
        for (int i = blog.getBlogPosts().size() - 1; i >= 0; i--) {
            blogPost = blog.getBlogPosts().get(i);
            pw.write("<h1>");
            if (newBlogPost == blogPost) {
                pw.write("<u>");
            }
            pw.write(blogPost.getSubject());
            if (newBlogPost == blogPost) {
                pw.write("</u>");
            }
            pw.write("</h1>\n");
            pw.write("<p>");
            if (newBlogPost == blogPost) {
                pw.write("<u>");
            }
            pw.write(blogPost.getBody());
            if (newBlogPost == blogPost) {
                pw.write("</u>");
            }
            pw.write("</p>\n");
        }

        pw.write("\n");
        pw.write("</body>\n");
        pw.write("</html>");
    }
}
