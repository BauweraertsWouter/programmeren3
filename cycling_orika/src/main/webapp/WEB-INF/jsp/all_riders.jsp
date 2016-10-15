<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>All Riders</title>
    </head>
    <body>
        <table border="1">
            <tr>
                <th>Name</th>
                <th>Date of birth</th>
                <th>Team Code</th>
                <th>Team Name</th>
                <th>Stage Wins</th>
            </tr>
            <c:forEach items="${riders}" var="rider">
                <tr>
                    <td><a href="<c:url value="/rider/${rider.id}" />">${rider.name}</a></td>
                    <td>${rider.dateOfBirth}</td>
                    <td>${rider.teamUciCode}</td>
                    <td>${rider.teamName}</td>
                    <td>${rider.stageWins}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
