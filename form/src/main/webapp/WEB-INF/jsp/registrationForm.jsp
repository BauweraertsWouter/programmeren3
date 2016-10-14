<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
    <head>
        <title><s:message code="form.register" /></title>
        <link rel="stylesheet" type="text/css" href="<s:url value="/static/css/style.css" />">
    </head>
    <body>
        <sf:form method="post" modelAttribute="userData">

            <sf:errors path="*" element="div" cssClass="error" />

            <sf:label path="firstName"><s:message code="form.first.name" /></sf:label><br>
            <sf:input path="firstName" /> <sf:errors path="firstName" cssClass="error" /> <br>
            <sf:label path="lastName"><s:message code="form.last.name" /></sf:label><br>
            <sf:input path="lastName" /> <sf:errors path="lastName" cssClass="error" /> <br>
            <sf:label path="email"><s:message code="form.email" /></sf:label><br>
            <sf:input path="email" /> <sf:errors path="email" cssClass="error" /> <br>
            <sf:label path="password"><s:message code="form.password" /></sf:label><br>
            <sf:password path="password" /> <sf:errors path="password" cssClass="error" /> <br>
            <sf:label path="passwordConfirmation"><s:message code="form.confirm.password" /></sf:label><br>
            <sf:password path="passwordConfirmation" /> <sf:errors path="passwordConfirmation" cssClass="error" /> <br>
            <input type="submit" value="<s:message code="form.register" />" />
        </sf:form>
    </body>
</html>
