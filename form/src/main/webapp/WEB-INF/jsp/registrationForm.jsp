<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title>Register</title>
    </head>
    <body>
        <sf:form method="post" modelAttribute="userData">
            <sf:label path="firstName">First name</sf:label><br>
            <sf:input path="firstName" /> <sf:errors path="firstName" /> <br>
            <sf:label path="lastName">Last name</sf:label><br>
            <sf:input path="lastName" /> <sf:errors path="lastName" /> <br>
            <sf:label path="email">Email</sf:label><br>
            <sf:input path="email" /> <sf:errors path="email" /> <br>
            <sf:label path="password">Password</sf:label><br>
            <sf:password path="password" /> <sf:errors path="password" /> <br>
            <sf:label path="passwordConfirmation">Confirm password</sf:label><br>
            <sf:password path="passwordConfirmation" /> <sf:errors path="passwordConfirmation" /> <br>
            <input type="submit" value="Register" />
        </sf:form>
    </body>
</html>
