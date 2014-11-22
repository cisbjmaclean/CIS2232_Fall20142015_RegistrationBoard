<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html:html lang="true">
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="welcome.title"/></title>
    <html:base/>

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

<body>
    <h2><fmt:message  key="label.member.education"/></h2>
    <div>
        <form action="memberEducation" method="post">
            <spring:nestedPath path="memberEducation">
                <table>                
                    <tr>
                        <td><form:hidden path="memberId"/>
                            <label class="alignCenter"  for="programCode">
                                <strong><fmt:message key="label.program" />:&nbsp;&nbsp;</strong></label>

                            <c:forEach var="theProgram" items="${sessionScope.programs}" varStatus="loopCounter">
                                <form:radiobutton path="programCode" value="${theProgram.codeValueSequence}" label="${theProgram.description}"/>
                            </c:forEach>
                        </td>
                    </tr>

                    <tr>
                        <td id="the_designation">
                            <label class="alignCenter"  for="designation">
                                <strong><fmt:message key="label.designation" /></strong></label>
                                <form:input path="designation" size="30" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="alignCenter"  for="year">
                                <strong><fmt:message key="label.year.obtained" /></strong></label>
                                <form:input path="year" size="4" />
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="alignCenter"  for="provinceCode">
                                <strong><fmt:message key="label.province" /></strong></label>


                            <form:select path="provinceCode">
                                <form:options items="${sessionScope.provinces}" itemLabel="description" itemValue="codeValueSequence"/>
                            </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="alignCenter"  for="institution">
                                <strong><fmt:message key="label.institution.name" /></strong></label>
                                <form:input path="institution" size="40" />
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <form:checkbox path="coreIndicator" value="core" label="core"/>

                        </td>
                    </tr>

                    <tr/>
                    <tr align="center">
                        <td colspan="2">
                            <input type="submit" value=<fmt:message key="label.submit"/>
                        </td>
                    </tr>
                </table>
            </spring:nestedPath>
        </form>
    </div>


</body>

</html:html>
