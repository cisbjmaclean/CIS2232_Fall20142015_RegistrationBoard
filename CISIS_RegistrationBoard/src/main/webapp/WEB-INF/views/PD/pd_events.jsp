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

    <form action="menu" method="post">
        <spring:nestedPath path="menu">
            <table>
                <tr>
                    <th>
                <h3><fmt:message key="label.report.event.type" /></h3>
                </th>
                <th>
                <h3><fmt:message key="label.report.event.date" /></h3>
                </th>
                <th>
                <h3><fmt:message key="label.report.event.description" /></h3>
                </th>
                <th>
                <h3><fmt:message key="label.report.event.value" /></h3>
                </th>
                </tr>
                <c:forEach var="report" items="${requestScope.reports}">
                    <tr><td colspan="4"><hr/></td></tr>
                    <tr>
                        <td><c:out value="${report.pdDescription}" /></td>
                        <td><c:out value="${report.date}" /></td>
                        <td><c:out value="${report.description}" /></td>
                        <td><c:out value="${report.value}" /></td>
                    </tr>    
                </c:forEach>

                <tr><td colspan="4"><hr/></td></tr>
                <tr>

                    <td colspan="4"><h3><fmt:message key="label.report.event.total" /></strong>&nbsp;&nbsp;
                            <c:out value="${requestScope.report.total}"/></u></h3></td>


                </tr>
                <tr>
                    <td colspan="4">
                        <input type="submit" name="action" value="<fmt:message key='label.professional.development.add'/>"/>
                    </td>
                </tr> 

        </form>  
    </spring:nestedPath>
</table>  
</body>

