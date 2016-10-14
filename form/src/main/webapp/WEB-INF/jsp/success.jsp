<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <title><s:message code="form.success" /></title>
    </head>
    <body>
        <h1><s:message code="form.registration.complete" /></h1>
        <s:message code="form.first.name" />: ${userData.firstName}<br>
        <s:message code="form.last.name" />: ${userData.lastName}<br>
        <s:message code="form.email" />: ${userData.email}
    </body>
</html>
