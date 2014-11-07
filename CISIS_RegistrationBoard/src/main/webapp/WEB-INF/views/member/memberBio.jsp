<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form action="memberBioUpdate" method="post">
    <spring:nestedPath path="memberSquash">

        <table>                

            <tr><td><h3>Membership Includes:</h3></td></tr>
            <tr><td>✓ Inclusion in the Squash PEI email news distribution list</td></tr>
            <tr><td>✓ Reduced registration fees to Squash PEI sanctioned tournaments and clinics</td></tr>
            <tr><td>✓ Provincial rankings for female/male players, maintained by Squash PEI </td></tr>
            <tr><td>✓ Discounts with local and regional businesses which have partnered with Squash PEI</td></tr>
            <tr><td>✓ Liability and injury insurance that covers accidents during practice, competition and travel to events (this alone is worth your membership fee!)</td></tr>
            <tr><td><hr/></td></tr>
            <tr><td><h3>Registration Procedure</h3></td></tr>
            <tr><td>✓ Complete the form, attach payment; and submit to Kady Bruce or Ken Sampson. Cheques can be made payable to “Squash PEI. (if mailing; please send to Ken Sampson, Box 131, North Rustico, PE, C0A 1X0”.</td></tr>
            <tr><td>✓ Age, club affiliation and member information are for use by Sport PEI for Injury and Liability Insurance purposes. Contact information is required for Squash PEI communications.</td></tr>
            <tr><td>✓ Signature of Player required(Parent/Guardian if player is Under 18)</td></tr>
            <tr><td>✓ Membership: $ 30 All Divisions (Maximum of $100.00 per immediate family)</td></tr>
            <tr><td><hr/></td></tr>
            <tr>
                <td>
                    <h3><fmt:message key="label.information" /></h3>
                </td>
            </tr>

            <tr>
                <td><form:hidden path="member.memberId"/>
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
                    <label class="alignCenter"  for="lastName">
                        <strong><fmt:message key="label.last.name" /></strong></label>
                        <form:input path="member.lastName" size="20" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="addressLine1">
                        <strong><fmt:message key="label.address.line.1" /></strong></label>
                        <form:input path="member.addressLine1" size="50" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="addressLine2">
                        <strong><fmt:message key="label.address.line.2" /></strong></label>
                        <form:input path="member.addressLine2" size="50" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="municipality">
                        <strong><fmt:message key="label.municipality" /></strong></label>
                        <form:input path="member.municipality" size="50" />
                </td>
            </tr>

            <tr>
                <td>
                    <label class="alignCenter"  for="provinceCode">
                        <strong><fmt:message key="label.province" /></strong></label>
                        <form:select path="member.provinceCode">
                            <form:options items="${sessionScope.provinces}" itemLabel="description" itemValue="codeValueSequence"/>
                        </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="postalCode">
                        <strong><fmt:message key="label.postal.code" /></strong></label>
                        <form:input path="member.postalCode" size="6" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="homePhone">
                        <strong><fmt:message key="label.home.phone" /></strong></label>
                        <form:input path="member.homePhone" size="10" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="workPhone">
                        <strong><fmt:message key="label.work.phone" /></strong></label>
                        <form:input path="member.workPhone" size="10" />
                    <label class="alignCenter"  for="workPhoneExtension">
                        <strong><fmt:message key="label.work.phone.extension" /></strong></label>
                        <form:input path="member.workPhoneExtension" size="3" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="fax">
                        <strong><fmt:message key="label.fax" /></strong></label>
                        <form:input path="member.fax" size="10" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="emailAddress">
                        <strong><fmt:message key="label.email.address" /></strong></label>
                        <form:input path="member.emailAddress" size="25" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="dateOfBirth">
                        <strong><fmt:message key="label.date.of.birth" /></strong></label>
                        <form:input path="member.dateOfBirth" size="10" />
                </td>
            </tr>

            <tr>
                <td>
                    <label class="alignCenter"  for="genderCode">
                        <strong><fmt:message key="label.gender" /></strong></label>

                    <form:select path="member.genderCode">
                        <form:options items="${sessionScope.genders}" itemLabel="description" itemValue="codeValueSequence"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="divisionCode">
                        <strong><fmt:message key="label.division" /></strong></label>

                    <form:select path="divisionCode">
                        <form:options items="${sessionScope.divisions}" itemLabel="description" itemValue="codeValueSequence"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="levelCode">
                        <strong><fmt:message key="label.level" /></strong></label>

                    <form:select path="levelCode">
                        <form:options items="${sessionScope.levels}" itemLabel="description" itemValue="codeValueSequence"/>
                    </form:select>
                </td>
            </tr>

            <tr>
                <td>
                    <label class="alignCenter"  for="clubCode">
                        <strong><fmt:message key="label.club" /></strong></label>

                    <form:select path="clubCode">
                        <form:options items="${sessionScope.clubs}" itemLabel="description" itemValue="codeValueSequence"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="registrationDate">
                        <strong><fmt:message key="label.registration.date" /></strong></label>
                        <form:input path="registrationDate" size="10" />
                </td>
            </tr>

            <tr>
                <td>
                    <form:checkbox path="allowInformationOnWebsite" value="true" />
                    <fmt:message key="label.allow.info" />
                </td>
            </tr>

            <tr>
                <td>
                    <form:checkbox path="allowPhotoUse" value="true" />
                    <fmt:message key="label.allow.photos" />
                </td>
            </tr>
            <tr><td><hr/></td></tr>
            <tr><td><h2>Thanks for Supporting Squash PEI - Good Luck This Year!!</h2></td></tr>

            <tr/>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value=<fmt:message key="label.save"/>
                </td>
            </tr>
        </table>
    </spring:nestedPath>
</form>
