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

<body>
    <h2><fmt:message key="label.professional.development"/></h2>

    <form action="pdHoursNeeded" method="post">
        <spring:nestedPath path="event">
            <table>             
                <tr>
                    <td><html:hidden property="memberId"/></td>
                <td><html:hidden property="firstName"/></td>
                <td><html:hidden property="lastName"/></td>
                </tr>       
                <tr>
                    <td><h3>
                            <label for="pdCode">
                                <strong><fmt:message key="label.professional.development.enter" />:&nbsp;&nbsp;</strong></label>
                        </h3></td>
                </tr>
                <tr>
                    <td>
                        <c:forEach var="theProgram" items="${sessionScope.pd_types}" varStatus="loopCounter">
                            <form:radiobutton path="pdCode" value="${theProgram.codeValueSequence}" label="${theProgram.description}"/><br/>
                        </c:forEach>
                    </td>
                </tr>
                <tr>
                    <td>
                        <hr/>
                    </td>
                </tr>
                <tr>
                    <td><h3>
                            <label for="date">
                                <strong><fmt:message key="label.professional.development.date" />:&nbsp;&nbsp;</strong></label>
                        </h3>
                    </td>
                </tr>
                <tr>
                    <td>
                        <!-- Input date picked -->
                        <form:input type="date" name="date" path="date" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <hr/>
                    </td>
                </tr>
                <tr>
                    <td><h3><label  for="description">
                                <strong><fmt:message key="label.professional.development.description" /></strong></label><br />
                                <form:textarea  style="max-height:300px; max-width:500px; width: 300px; height: 150px;" path="description" />
                        </h3>
                    </td>
                </tr>
                <tr align="center">
                    <td colspan="2">
                        <input type="submit" value="<fmt:message key='label.submit'/>"/>
                    </td>
                </tr>
            </table>
        </spring:nestedPath>
    </form>
</body>