<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BlogPost 3 met JSTL</title>
    <link rel="stylesheet" type="text/css" href="css/blogpost.css"/>
</head>
<body>
<p><a href="blogpost.html">Maak een nieuwe post</a></p>

<p><a href="LogoutServlet">Log uit</a></p>
<table>
    <c:forEach var="post" items="${posts}">
        <c:choose>
            <c:when test="${post == lastpost}">
                <tr class="lastpost">
            </c:when>
            <c:otherwise>
                <tr>
            </c:otherwise>
        </c:choose>
        <td>${post.name} - ${post.jaar}</td>
        <td>${post.specialisatie}</td>
        <td>${post.omschrijving}<br/><a href="${post.url}">${post.url}</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>