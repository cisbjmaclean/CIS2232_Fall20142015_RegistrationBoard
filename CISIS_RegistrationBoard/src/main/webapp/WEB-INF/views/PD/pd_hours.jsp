<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

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

<form action="PdHours" method="post">
    <spring:nestedPath path="menu">

        <table>
            <tr>
                <td ><fmt:message key="label.professional.development"/>
                </td>
            </tr>              
            <html:hidden property="memberId" /><html:hidden property="firstName"/><html:hidden property="lastName"/><html:hidden property="pdCode" /><html:hidden property="pdDescription" /><html:hidden property="date" /><html:hidden property="description" />
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
