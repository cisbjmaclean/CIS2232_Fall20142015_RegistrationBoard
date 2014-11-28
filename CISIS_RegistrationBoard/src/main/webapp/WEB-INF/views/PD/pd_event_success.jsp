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
    <form action="" method="post">
        <spring:nestedPath path="menu">
            <table> 
                <tr>
                    <td><div class="success"><fmt:message key="label.professional.development.success" /></td>
                </tr>    
            </table>
        </spring:nestedPath>
    </form>
</body>
