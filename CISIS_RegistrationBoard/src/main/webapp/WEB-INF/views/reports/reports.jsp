<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!-- create for report -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="welcome.title"/></title>
    <html:base/>
</head>

<body>

<spring:nestedPath path="menu">
    <form action="" method="post">
        <table>
            <tr>
                <td colspan="2">
                    <h2>Inactive Members</h2>
                    <a href="memberAdmin?action=activeAll">Active all members</a>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    ${message}${informationMessage}
                </td>
            </tr>

            <c:forEach var="thisMember" items="${members}" varStatus="loopCounter">
                <tr>
                    <td>
                        <c:out value="${thisMember.lastName}" />, <c:out value="${thisMember.firstName}" />
                    </td>
                    <td>
                        <a href="memberAdmin?action=active&memberId=${thisMember.memberId}">Active</a>
                    </td>
                </tr>
            </c:forEach>
                
            <tr>
                <td>
                   <hr />
                </td>
            </tr>
            
            <!-- For all list of waiting final confirm-->
            <tr>                
                <td colspan="2">
                    <h2>Confirmed Members</h2>
                    <a href="memberAdmin?action=confirmAll">Confirm all member</a>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    ${message}${informationMessage}
                </td>
            </tr>

            <c:forEach var="thisConfirm" items="${memberConfirm}" varStatus="loopCounter">
                <tr>
                    <td>
                        <c:out value="${thisConfirm.lastName}" />, <c:out value="${thisConfirm.firstName}" />
                    </td>
                    <td>
                        <a href="memberAdmin?action=confirm&memberId=${thisConfirm.memberId}">confirm</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>
</spring:nestedPath>

</body>

</html:html>
