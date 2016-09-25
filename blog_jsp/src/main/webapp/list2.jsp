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
%>
        <h1>
<% if (newBlogPost == blogPost) { %>
            <u>
<%
        }
        out.print(blogPost.getSubject());
        if (newBlogPost == blogPost) {
%>
            </u>
<%
        }
%>
        </h1>
        <p>
<%
        if (newBlogPost == blogPost) {
%>
            <u>
<%
        }
        out.print(blogPost.getBody());
        if (newBlogPost == blogPost) {
%>
            </u>
<%
        }
%>
        </p>
<%
    }
%>

</body>
</html>
