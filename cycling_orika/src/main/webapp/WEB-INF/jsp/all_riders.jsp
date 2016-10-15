<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>All Riders</title>
    </head>
    <body>
        <c:forEach items="${riders}" var="rider">
            <h1><a href="<c:url value="/rider/${rider.id}" />">${rider.name}</a></h1>
            <!-- rider.dateOfBirth -->
            <!-- rider.teamName -->
            <!-- rider.stageVictories -->
            <hr>
        </c:forEach>
    </body>
</html>
