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
                            <html:hidden property="pdCode" />
                            <strong><fmt:message key="label.professional.development.confirm" /></strong>
                        </label><br />
                        <html:hidden property="firstName"/>
                        <strong><fmt:message key="label.professional.development.confirm.name" /></strong>
                        <bean:write name="eventForm" property="firstName" />&nbsp<html:hidden property="lastName"/>
                        <bean:write name="eventForm" property="lastName" /><br />  
                        <html:hidden property="memberId" /><strong>
                            <fmt:message key="label.professional.development.confirm.memberId" /></strong>
                        <bean:write name="eventForm" property="memberId" /><br />
                        <html:hidden property="pdDescription" /><strong>
                            <fmt:message key="label.professional.development.confirm.pdDescription" /></strong>
                        <bean:write name="eventForm" property="pdDescription" /><br />
                        <html:hidden property="date" /><strong>
                            <fmt:message key="label.professional.development.confirm.date" /></strong>
                        <bean:write name="eventForm" property="date" /><br />
                        <html:hidden property="description" /><strong>
                            <fmt:message key="label.professional.development.confirm.description" /></strong>
                        <bean:write name="eventForm" property="description" /><br />
                        <logic:greaterThan name="eventForm" value="0" property="hour">
                            <html:hidden property="hour" /><strong>
                                <fmt:message key="label.professional.development.confirmHours" />
                            </strong><bean:write name="eventForm" property="hour" /></logic:greaterThan><br />
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
