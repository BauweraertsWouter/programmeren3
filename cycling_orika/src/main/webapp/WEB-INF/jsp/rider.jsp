<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Rider ${rider.name}</title>
    </head>
    <body>
        <h1>${rider.name}</h1>
        <h2>Date of birth: ${rider.dateOfBirth}</h2>
        <h2>Team: <a href="<c:url value="/team/${rider.teamUciCode}" />">${rider.teamName}</a></h2>
        <h2>Stage wins: ${rider.stageWins}</h2>
    </body>
</html>
