<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="welcome.title"/></title>
</head>

<form action="pdHours" method="post">
    <spring:nestedPath path="event">

        <table>
            <tr>
                <td ><fmt:message key="label.professional.development"/>
                </td>
            </tr>              
            <form:hidden path="memberId" /><form:hidden path="firstName"/><form:hidden path="lastName"/>
            <form:hidden path="pdCode" /><form:hidden path="pdDescription" /><form:hidden path="date" />
            <form:hidden path="description" />
            <tr>
                <td><label class="alignCenter"  for="hour">
                        <strong><fmt:message key="label.professional.development.hour" /></strong></label><br />
                        <form:input path="hour" />
                </td>
            </tr>

            <tr align="center">
                <td colspan="2">
                    <input type="submit" value=<fmt:message key="label.submit"/>
                </td>
            </tr>
    </form>
</table>
</spring:nestedPath>
</form>
</body>