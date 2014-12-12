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

<h2><fmt:message key="label.professional.development"/></h2>
<div>
    <form action="pdConfirm" method="post">
        <spring:nestedPath path="event">
            <table>  
                <tr>
                    <td>
                        <label class="alignCenter"  for="pdCode">
                            <form:hidden path="pdCode" />
                            <strong><fmt:message key="label.professional.development.confirm" /></strong>
                        </label><br />
                        <form:hidden path="firstName"/><form:hidden path="lastName"/>
                        <strong><fmt:message key="label.professional.development.confirm.name" /></strong>

                        <c:out value="${event.firstName}" />&nbsp; <c:out value="${event.lastName}" />
                        <br />  
                        <form:hidden path="memberId" /><strong>
                            <fmt:message key="label.professional.development.confirm.memberId" /></strong>
                        <c:out value="${event.memberId}" /><br />
                        <form:hidden path="pdDescription" /><strong>
                            <fmt:message key="label.professional.development.confirm.pdDescription" /></strong>
                        <c:out  value="${event.pdDescription}" /><br />
                        <form:hidden path="date" /><strong>
                            <fmt:message key="label.professional.development.confirm.date" /></strong>
                        <c:out value="${event.date}" /><br />
                        <form:hidden path="description" /><strong>
                            <fmt:message key="label.professional.development.confirm.description" /></strong>
                        <c:out value="${event.description}" /><br />
                        <c:if test="${event.hour > 0}">
                              <form:hidden path="hour" /><strong>
                              <fmt:message key="label.professional.development.confirmHours" />
                        </strong><c:out  value="${event.hour}" /></c:if><br />
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="2">
                        <input type="submit" value=<fmt:message key="label.submit"/>
                </td>
            </tr>
        </table>
    </spring:nestedPath>
</form>
</body>
