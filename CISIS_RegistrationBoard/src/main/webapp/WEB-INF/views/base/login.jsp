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
    <spring:nestedPath path="login">
        <form action="login" method="post">
            <body>

                <h2>Please provide your login details</h2>
                <table>
                    <tr>
                        <td>Username:</td>
                        <td><form:input path="username" value="bjmaclean"/>
                        </td>

                    </tr>          
                    <tr>
                        <td>Password:</td>
                        <td><form:input path="password" value="bjmacleanpw" />
                        </td>

                    </tr>          


                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Login"/>
                        </td>
                    </tr>
                </table>
            </body>
        </form>
    </spring:nestedPath>

</html:html>