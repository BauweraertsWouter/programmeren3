<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>Success</title>
    </head>
    <body>
        <h1>Registration complete!</h1>
        First name: ${userData.firstName}<br>
        Last name: ${userData.lastName}<br>
        Email: ${userData.email}
    </body>
</html>
