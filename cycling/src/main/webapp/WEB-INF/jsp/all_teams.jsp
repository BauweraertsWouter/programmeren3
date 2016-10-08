<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>All Riders</title>
    </head>
    <body>
        <c:forEach items="${teams}" var="team">
            <h1><a href="">${team.name}</a></h1>
            <h2>UCI code: ${team.uciCode}</h2>
            <h2>Founded: ${team.founded}</h2>
            <hr>
        </c:forEach>
    </body>
</html>
