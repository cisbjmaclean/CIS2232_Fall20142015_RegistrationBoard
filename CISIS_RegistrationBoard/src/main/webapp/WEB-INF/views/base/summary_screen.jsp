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

<form action="menu" method="post">
    <spring:nestedPath path="menu">

        <table>
            <tr>
                <td>
                    <h2><fmt:message key="label.summary"/></h2>
                </td>
            </tr>
            <c:forEach var="thisScreen" items="${summaryScreen}" varStatus="loopCounter">
                <tr>
                    <td>
                        <label class="alignCenter" for="name">
                            <strong>Name:&nbsp;&nbsp;</strong></label>
                            <c:out value="${thisScreen.firstName}" /> <c:out value="${thisScreen.middleName}" /> <c:out value="${thisScreen.lastName}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="alignCenter" for="lastUpdated">
                            <strong>Last updated:&nbsp;&nbsp;</strong></label>
                            <c:out value="${thisScreen.lastUpdated}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="alignCenter" for="pdHours">
                            <strong>PD points:&nbsp;&nbsp;</strong></label>
                            <c:out value="${thisScreen.total}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <a href="memberAdmin?action=userConfirm&memberId=${thisScreen.memberId}">Confirm</a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </spring:nestedPath>
</form>