<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Team ${team.name}</title>
    </head>
    <body>
        <h1>${team.name}</h1>
        <h2>UCI code: ${team.uciCode}</h2>
        <h2>Founded: ${team.founded}</h2>
        <hr>
        <c:forEach items="${team.riders}" var="rider">
            <h2><a href="<c:url value="/rider/${rider.id}" />">${rider.name}</a></h2>
            <h3>Date of birth: ${rider.dateOfBirth}</h3>
            <hr>
        </c:forEach>
    </body>
</html>
