<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show user</title>
</head>
<body>
    <form action="<c:url value="/showSuperUser" />" method="post">
        <label for="name">Name</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="phone">Phone</label><br>
        <input type="text" id="phone" name="phone"><br>
        <label for="dateOfBirth">Date of birth (YYYY-MM-DD)</label><br>
        <input type="text" id="dateOfBirth" name="dateOfBirth"><br>
        <button type="submit">Show</button>
    </form>
</body>
</html>
