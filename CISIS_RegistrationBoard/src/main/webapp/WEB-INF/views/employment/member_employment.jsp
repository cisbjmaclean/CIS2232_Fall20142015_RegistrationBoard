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
                document.forms[1].action = "/CISIS_RegistrationBoard/memberEmployment?action=delete&memberId=" + memberIdIn + "&educationId=" + test;
                document.forms[1].submit();
            }

        }
    </script>
</head>

<form action="menu" method="post">
    <spring:nestedPath path="memberEmployment">

        <table>
            <tr>
                <td>
                    <h2><fmt:message key="label.member.employment"/></h2>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="hidden" id="action_id" property="action"/>
                    <label class="alignCenter" for="statusCode">
                        <strong><fmt:message key="label.employment.status" /></strong>:</label><br />
                        <c:forEach var="theProgram" items="${sessionScope.employment_statuses}" varStatus="loopCounter">
                            <form:radiobutton path="statusCode" value="${theProgram.codeValueSequence}" label="${theProgram.description}"/><br />
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="currencyCode">
                        <strong><fmt:message key="label.currency" />:&nbsp;&nbsp;</strong></label>
                    <fmt:message key="label.currency.description" /><br />
                    <c:forEach var="theProgram" items="${sessionScope.currencies}" varStatus="loopCounter">
                        <form:radiobutton path="currencyCode" value="${theProgram.codeValueSequence}" label="${theProgram.description}"/><br />
                    </c:forEach>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label class="alignCenter">
                        <strong><fmt:message key="label.practice.in.other.jurisdications" /></strong></label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:checkbox path="practiceViaTelephoneIndicator" value="Via Telephone" label="Via Telephone"/>
                    <form:checkbox path="practiceViaInternetIndicator" value="Via Internet" label="Via Internet"/>
                    <form:checkbox path="practiceInPersonIndicator" value="In Person" label="In Person"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="practiceJurisdictions">
                        <strong><fmt:message key="label.jurisdictions" /></strong></label>
                        <form:input path="practiceJurisdictions" />
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" name="action" value='<fmt:message key="label.save"/>'>
                </td>
            </tr>
            <tr>
                <td>
                    <hr/>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter">
                        <strong><fmt:message key="label.employers" /></strong></label>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" name="action" value='<fmt:message key="label.add.employer"/>'/>
                </td>
            </tr>
        </table>

    </spring:nestedPath>
</form>