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
        function showDesignation(test) {
            if (test == 7) {
                document.getElementById('the_designation').style.display = 'none';
                //alert(test);
            } else {
                document.getElementById('the_designation').style.display = 'block';
            }
//    alert('test2');
        }
    </script>  
</head>

<form action="memberEmployment" method="post">
    <spring:nestedPath path="memberEmployer">

        <table>
            <tr>
                <td>
                    <h2><fmt:message key="label.add.employer"/></h2>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:checkbox path="primaryIndicator" value="Primary Employer" label="Primary Employer"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="name">
                        <strong><fmt:message key="label.name" /></strong></label>
                        <form:input path="name" size="40" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="addressLine1">
                        <strong><fmt:message key="label.address.line.1" /></strong></label>
                        <form:input path="addressLine1" size="50" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="addressLine2">
                        <strong><fmt:message key="label.address.line.2" /></strong></label>
                        <form:input path="addressLine2" size="50" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="municipality">
                        <strong><fmt:message key="label.municipality" /></strong></label>
                        <form:input path="municipality" size="50" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="provinceCode">
                        <strong><fmt:message key="label.province" /></strong></label>
                        <form:select path="provinceCode">
                            <form:options items="${sessionScope.provinces}" itemLabel="description" itemValue="codeValueSequence"/>
                        </form:select>               
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="postalCode">
                        <strong><fmt:message key="label.postal.code" /></strong></label>
                        <form:input path="postalCode" size="6" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="positionCode">
                        <strong><fmt:message key="label.position" /></strong></label>
                        <form:select path="positionCode">
                            <form:options items="${sessionScope.positions}" itemLabel="description" itemValue="codeValueSequence"/>
                        </form:select>

                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="practiceAreaCode">
                        <strong><fmt:message key="label.practice.area" /></strong></label>
                        <form:select path="practiceAreaCode">
                            <form:options items="${sessionScope.practice_areas}" itemLabel="description" itemValue="codeValueSequence"/>
                        </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="employmentStatusCode">
                        <strong><fmt:message key="label.employment.status" /></strong></label>
                        <form:select path="employmentStatusCode">
                            <form:options items="${sessionScope.employment_statuses}" itemLabel="description" itemValue="codeValueSequence"/>
                        </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="employmentCategoryCode">
                        <strong><fmt:message key="label.employment.category" /></strong></label>
                        <form:select path="employmentCategoryCode">
                            <form:options items="${sessionScope.employment_categories}" itemLabel="description" itemValue="codeValueSequence"/>
                        </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="fundingSourceCode">
                        <strong><fmt:message key="label.funding.source" /></strong></label>
                        <form:select path="fundingSourceCode">
                            <form:options items="${sessionScope.funding_sources}" itemLabel="description" itemValue="codeValueSequence"/>
                        </form:select>
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value=<fmt:message key="label.add.employer"/>
                </td>
            </tr>
        </table>
    </spring:nestedPath>
</form>