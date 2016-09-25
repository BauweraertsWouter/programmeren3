<%@ page import="be.kdg.prog3.blog_jsp.model.Blog" %>
<%@ page import="be.kdg.prog3.blog_jsp.model.BlogPost" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog Posts</title>
</head>
<body>

<%
    final Blog blog = (Blog)application.getAttribute("blog");
    BlogPost newBlogPost = (BlogPost)request.getAttribute("newBlogPost");
    BlogPost blogPost;
    for (int i = blog.getBlogPosts().size() - 1; i >= 0; i--) {
        blogPost = blog.getBlogPosts().get(i);
        out.print("<h1>");
        if (newBlogPost == blogPost) {
            out.print("<u>");
        }
        out.print(blogPost.getSubject());
        if (newBlogPost == blogPost) {
            out.print("</u>");
        }
        out.println("</h1>");
        out.print("<p>");
        if (newBlogPost == blogPost) {
            out.print("<u>");
        }
        out.print(blogPost.getBody());
        if (newBlogPost == blogPost) {
            out.print("</u>");
        }
        out.println("</p>");
    }
%>

</body>
</html>
