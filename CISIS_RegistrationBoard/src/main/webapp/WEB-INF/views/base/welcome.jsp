<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<spring:nestedPath path="menu">
    <form action="welcome" method="post">
        <h2><fmt:message key="welcome.heading" /></h2>
            <table>
                     
                <tr>
                    <td>        <input type="submit" name="action" value="Enter">
                    </td>
                </tr>
                
            </table>
    </form>
    </spring:nestedPath>
