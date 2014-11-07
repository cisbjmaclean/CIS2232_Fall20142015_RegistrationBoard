<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View codes</title>
        
        <html:base/>
    </head>
    <spring:nestedPath path="codeValue">
        <form action="viewCodes" method="post">
            <body>

                <h2>Please provide your code type to view (1-16)</h2>
                <table>
                    <tr>
                        <td>Code type:</td>
                        <td><form:input path="codeTypeId" value=""/>
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