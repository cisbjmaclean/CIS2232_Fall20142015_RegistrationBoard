<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="welcome.title"/></title>
    <script type="text/javascript">
        function deleteEducation(test, educationDescription, memberIdIn) {
            var r = confirm("<fmt:message key="label.confirm.delete.education"/>" + educationDescription + "?");
            if (r == true) {
                document.forms[1].action = "/CISIS_RegistrationBoard/memberEducation?action=delete&memberId=" + memberIdIn + "&educationId=" + test;
                document.forms[1].submit();
            }

        }
    </script> 
</head>

<form action="menu" method="post">
    <spring:nestedPath path="menu">

        <table>
            <tr>
                <td>
                    <h2><fmt:message key="label.member.education"/></h2>
                </td>
            </tr>

            <c:forEach var="thisEducation" items="${sessionScope.Education}" varStatus="loopCounter">
                <tr>
                    <td>
                        <label class="alignCenter" for="programDescription">
                            <strong><fmt:message key="label.program" />:&nbsp;&nbsp;</strong></label>
                        <c:out value="${thisEducation.programDescription}" /><c:if test="${thisEducation.programDescription} == true">  &nbsp;(<fmt:message key="label.core" />)</c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="alignCenter" for="designation">
                                <strong><fmt:message key="label.designation" />:&nbsp;&nbsp;</strong></label>
                            <c:out value="${thisEducation.designation}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="alignCenter" for="year">
                            <strong><fmt:message key="label.year.obtained" />:&nbsp;&nbsp;</strong></label>
                            <c:out value="${thisEducation.year}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="alignCenter" for="provinceDescription">
                            <strong><fmt:message key="label.province" />:&nbsp;&nbsp;</strong></label>
                            <c:out value="${thisEducation.provinceDescription}" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label class="alignCenter" for="institution">
                            <strong><fmt:message key="label.institution.name" />:&nbsp;&nbsp;</strong></label>
                            <c:out value="${thisEducation.institution}" />
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="2">
                        <input type="button" onclick="deleteEducation(<c:out value="${thisEducation.memberEducationSequence}"/>, '<c:out value="${thisEducation.programDescription}" />', <c:out value="${thisEducation.memberId}"/>)" value='<fmt:message key="label.delete"/>'>
                    </td>
                </tr>
                <tr>
                    <td>
                        <hr/>
                    </td>
                </tr>
            </c:forEach>

            <tr/>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" name="action" value='<fmt:message key="label.add.education"/>'/>
                </td>
            </tr>
        </table>
    </spring:nestedPath>
</form>