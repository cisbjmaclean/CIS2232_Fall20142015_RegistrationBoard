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
        function deleteNotification(test, description) {
            var r = confirm("<fmt:message key="label.confirm.delete.notification"/> (" + description + ")?");
            if (r == true) {
                //var s = document.getElementById('action_id');
                //s.value = test;
//                document.getElementById('TheForm').action = "notification?delete=" + test";
//                document.getElementById('TheForm').submit();

                document.forms[0].action = "notification?delete=" + test;
                document.forms[0].submit();
            }

        }
    </script> 
</head>

<form action="menu"  id="TheForm" method="post">
    <spring:nestedPath path="menu">
        <table>                     
            <h2><fmt:message key="label.pd"/></h2>
            ${informationMessage}
            ${errorMessage}
            <hr/>

            <tr>
                <td>
                    <hr/>
                </td>
            </tr>



            <tr>
                <td>        <input type="submit" id="TheButton" name="action" value="Add Notification">
                </td>
            </tr>
        </table>
    </spring:nestedPath>
</form>