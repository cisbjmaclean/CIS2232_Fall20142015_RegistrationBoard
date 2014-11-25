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
    function deleteEducation(test, educationDescription, memberIdIn) {
        var r = confirm("<fmt:message key="label.confirm.delete.education"/>" + educationDescription + "?");
        if (r == true) {
            document.forms[1].action = "/CISIS_RegistrationBoard/memberEmployment?action=delete&memberId=" + memberIdIn + "&educationId=" + test;
            document.forms[1].submit();
        }

    }
</script>
</head>

<body>
    <h2><fmt:message key="label.member.employment"/></h2>
    <div>
        <form action="menu" method="post">
            <spring:nestedPath path="menu">
                <table>
                    
                        

                </table>
            </spring:nestedPath>
        </form>
    </div>

</body>