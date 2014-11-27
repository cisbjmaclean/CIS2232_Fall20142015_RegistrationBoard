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
            <tr>
                <td>
                    <label class="alignCenter" for="name">
                        <strong>Name:&nbsp;&nbsp;</strong></label>
                    <!-- the user’s name; displayed in the following format: Mr. Bruce J. MacLean -->
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="lastUpdated">
                        <strong>Last updated:&nbsp;&nbsp;</strong></label>
                    <!-- the date that the user last edited their biographical information -->
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="pdHours">
                        <strong>PD hours:&nbsp;&nbsp;</strong></label>
                    <!-- the number of PD hours in the current year for the user -->Ï
                </td>
            </tr>
        </table>

    </spring:nestedPath>
</form>