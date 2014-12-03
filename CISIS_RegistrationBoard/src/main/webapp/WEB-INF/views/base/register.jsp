<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

    <html:base/>
</head>
<spring:nestedPath path="member">
    <form action="register" method="post">
        <body>
            <h2>Please provide your new user details</h2>
            <table>
                <tr>
                    <td>First Name:</td>
                    <td><form:input path="firstName" value=""/>
                    </td>
                </tr>          
                <tr>
                    <td>Middle Name:</td>
                    <td><form:input path="middleName" value=""/>
                    </td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><form:input path="lastName" value=""/>
                    </td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="emailAddress" value=""/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit"/>
                    </td>
                </tr>
            </table>
        </body>
    </form>
</spring:nestedPath>
</html:html>