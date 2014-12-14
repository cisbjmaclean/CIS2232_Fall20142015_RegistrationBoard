<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:nestedPath path="menu">
    <form action="" method="post">
        <table>
            <tr>
                <td>Here are the code values for that code type.
                </td>
            </tr>
            <tr>
                <td>
                    ${message}

                </td>
            </tr>
            <c:forEach var="thisCode" items="${theCollection}"
                       varStatus="loopCounter">
                <tr>
                    <td><c:out value="${loopCounter.count}" /></td>
                    <td><c:out value="${thisCode.description}" /></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</spring:nestedPath>