<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<spring:nestedPath path="menu">
    <form action="" method="post">
            <table>
                <tr>
                    <td>${message}
                    </td>
                </tr>                
                <tr>
                    <td>${informationMessage}
                    </td>
                </tr>                
            </table>
    </form>
    </spring:nestedPath>
