<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form action="memberBioUpdate" method="post">
    <spring:nestedPath path="memberRegistration">

        <table>
            <tr>
                <td>
                    <h2><fmt:message key="label.information" /></h2>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="salutationCode">
                        <strong><fmt:message key="label.salutation" />:&nbsp;&nbsp;</strong></label>
                        <c:forEach var="theProgram" items="${sessionScope.salutations}" varStatus="loopCounter">
                            <form:radiobutton path="salutationCode" value="${theProgram.codeValueSequence}" label="${theProgram.description}"/>
                        </c:forEach>
                </td>
            </tr>
            <tr>
                <td>
                    <form:hidden path="member.memberId"/>
                    <label class="alignCenter" for="firstName">
                        <strong><fmt:message key="label.first.name" /></strong></label>
                        <form:input path="member.firstName" size="20" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="middleName">
                        <strong><fmt:message key="label.middle.name" /></strong></label>
                        <form:input path="member.middleName" size="20" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="lastName">
                        <strong><fmt:message key="label.last.name" /></strong></label>
                        <form:input path="member.lastName" size="20" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="previousSurnames">
                        <strong><fmt:message key="label.previous.surnames" /></strong></label>
                        <form:input path="previousSurnames" size="50" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <label class="alignCenter" for="permission1">
                        <strong><fmt:message key="label.email.permission" /></strong></label>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:checkbox path="emailToMembers" value="members" label="Members"/>
                    <form:checkbox path="emailToBusiness" value="business" label="Business"/>
                    <form:checkbox path="emailToGovernment" value="government" label="Government"/>
                    <form:checkbox path="emailToPEIDAExecutive" value="PEIDA Executive" label="PEIDA Executive"/>
                </td>
            </tr>
            <td>
                <label class="alignCenter" for="addressLine1">
                    <strong><fmt:message key="label.address.line.1" /></strong></label>
                    <form:input path="member.addressLine1" size="50" />
            </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="addressLine2">
                        <strong><fmt:message key="label.address.line.2" /></strong></label>
                        <form:input path="member.addressLine2" size="50" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="municipality">
                        <strong><fmt:message key="label.municipality" /></strong></label>
                        <form:input path="member.municipality" size="50" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="provinceCode">
                        <strong><fmt:message key="label.province" /></strong></label>
                        <form:select path="member.provinceCode">
                            <form:options items="${sessionScope.provinces}" itemLabel="description" itemValue="codeValueSequence"/>
                        </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="postalCode">
                        <strong><fmt:message key="label.postal.code" /></strong></label>
                        <form:input path="member.postalCode" size="6" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="homePhone">
                        <strong><fmt:message key="label.home.phone" /></strong></label>
                        <form:input path="member.homePhone" size="10" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="workPhone">
                        <strong><fmt:message key="label.work.phone" /></strong></label>
                        <form:input path="member.workPhone" size="10" />
                    <label class="alignCenter"  for="workPhoneExtension">
                        <strong><fmt:message key="label.work.phone.extension" /></strong></label>
                        <form:input path="member.workPhoneExtension" size="3" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="fax">
                        <strong><fmt:message key="label.fax" /></strong></label>
                        <form:input path="member.fax" size="10" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="emailAddress">
                        <strong><fmt:message key="label.email.address" /></strong></label>
                        <form:input path="member.emailAddress" size="25" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="website">
                        <strong><fmt:message key="label.website" /></strong></label>
                        <form:input path="website" size="25" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="dateOfBirth">
                        <strong><fmt:message key="label.date.of.birth" /></strong></label>
                        <form:input path="member.dateOfBirth" size="10" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="genderCode">
                        <strong><fmt:message key="label.gender" /></strong></label>

                    <form:select path="member.genderCode">
                        <form:options items="${sessionScope.genders}" itemLabel="description" itemValue="codeValueSequence"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="1">
                    <form:checkbox path="bilingual" value="bilingual" label="bilingual"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="bilingualOther">
                        <strong><fmt:message key="label.bilingual.other" /></strong></label>
                        <form:input path="bilingualOther" size="50" />
                </td>
            </tr>
            <tr>
                <td colspan="1">
                    <form:checkbox path="canadianCitizen" value="Canadian Citizen" label="Canadian Citizen"/>
                    <form:checkbox path="landedImmigrant" value="Landed Immigrant" label="Landed Immigrant"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="countryOfOriginCode">
                        <strong><fmt:message key="label.country.of.origin" /></strong></label>

                    <form:select path="countryOfOriginCode">
                        <form:options items="${sessionScope.countries}" itemLabel="description" itemValue="codeValueSequence"/>
                    </form:select>                     
                </td>
            </tr>
            <tr>
                <td colspan="1">
                    <form:checkbox path="immigrantAuthorized" value="Authorized under the Immigration Act to practice this professionn" label="Authorized under the Immigration Act to practice this profession"/>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter" for="immigrantAuthorizedExpiryDate">
                        <strong><fmt:message key="label.immigrant.authorized.expiry" /></strong></label>
                        <form:input path="immigrantAuthorizedExpiryDate" size="50" />
                </td>
            </tr>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value=<fmt:message key="label.save"/>
                </td>
            </tr>
        </table>

    </spring:nestedPath>
</form>