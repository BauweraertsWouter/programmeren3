<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Blog Posts</title>
</head>
<body>

<c:set var="newBlogPost" value='${requestScope["newBlogPost"]}' />

<%-- forEach loopt de elementen af in volgorde. De elementen in de
     juiste volgorde tonen wordt als een oefening gelaten (dit maakt
     de JSP ook minder leesbaar). --%>
<c:forEach items="${blog.getBlogPosts()}" var="blogPost">
    <h1>
    <c:choose>
        <c:when test="${newBlogPost == blogPost}">
            <u><c:out value="${blogPost.subject}" /></u>
        </c:when>
        <c:otherwise>
            <c:out value="${blogPost.subject}" />
        </c:otherwise>
    </c:choose>
    </h1>
    <p>
    <c:choose>
        <c:when test="${newBlogPost == blogPost}">
            <%-- getBody() or body, both work --%>
            <u><c:out value="${blogPost.body}" /></u>
        </c:when>
        <c:otherwise>
            <%-- getBody() or body, both work --%>
            <c:out value="${blogPost.getBody()}" />
        </c:otherwise>
    </c:choose>
    </p>
</c:forEach>

</body>
</html>
