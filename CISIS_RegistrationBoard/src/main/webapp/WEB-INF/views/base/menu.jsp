<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form action="menu" method="post">
    <spring:nestedPath path="menu">
        <table>                     
            <tr>
                <td><input type="submit" name="action" value="My Information">
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Education">
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Employment">
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Professional Development">
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Make Payment">
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Change Password">
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Logout">
                </td>
            </tr>
            <tr>
                <td><fmt:message key="label.admin"/>
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Members">
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Reports">
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Notifications">
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="View Codes">
                </td>
            </tr>
            <tr>
                <td><a target="_blank" href="https://docs.google.com/document/d/1MsZZUJ0V_jKE6YxYw4VQLaLxcFHwPPVk9x3uDE6Qy8c/edit">View Design</a>
                </td>
            </tr>
        </table>
    </spring:nestedPath>
</form>