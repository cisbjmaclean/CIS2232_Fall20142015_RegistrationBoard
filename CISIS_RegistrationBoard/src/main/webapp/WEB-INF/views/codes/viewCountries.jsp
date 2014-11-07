<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:nestedPath path="menu">
    <form action="" method="post">
        <table>
            <tr>
                <td>
                    ${message}
                </td>
            </tr>
            <c:forEach var="country" items="${sessionScope.countries}"
                       varStatus="loopCounter">
                <tr>
                    <td><c:out value="${loopCounter.count}" /></td>
                    <td><c:out value="${country.description}" /></td>
                </tr>
            </c:forEach>




        </table>
    </form>
</spring:nestedPath>
