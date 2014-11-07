<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<spring:nestedPath path="menu">
    <form action="" method="post">
        <table>
            <tr>
                <td colspan="2"><h2>Active Members</h2><a href="memberAdmin?action=add">add member</a></td>
            </tr>
            <tr>
                <td colspan="2">
                    ${message}${informationMessage}
                </td>
            </tr>
            <c:forEach var="thisMember" items="${members}"
                       varStatus="loopCounter">
                <tr>
                    <td><c:out value="${thisMember.lastName}" />, <c:out value="${thisMember.firstName}" /></td>
                    <td><a href="memberAdmin?action=edit&memberId=${thisMember.memberId}">edit</a>&nbsp;<a href="memberAdmin?action=delete&memberId=${thisMember.memberId}">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</spring:nestedPath>
