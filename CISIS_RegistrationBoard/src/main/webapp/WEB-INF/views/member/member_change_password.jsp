<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form action="changePassword" method="post">
    <spring:nestedPath path="changePassword">
        <h2><fmt:message key="label.change.password"/></h2>
        <div>
                <table>                
                    <tr>
                        <td><form:hidden path="memberId"/>
                            <label class="alignCenter" for="existingPassword">
                                <strong><fmt:message key="label.existing.password" /></strong></label>
                                <form:input path="existingPassword" size="20" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="alignCenter" for="newPassword">
                                <strong><fmt:message key="label.new.password" /></strong></label>
                                <form:input path="newPassword" size="20" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="alignCenter" for="confirmPassword">
                                <strong><fmt:message key="label.confirm.password" /></strong></label>
                                <form:input path="confirmPassword" size="20" />
                        </td>
                    </tr>
                    <tr/>
                    <tr align="center">
                        <td colspan="2">
                            <input type="submit" value=<fmt:message key="label.submit"/>
                        </td>
                    </tr>
                </table>
            </html:form>
        </div>

    </spring:nestedPath>