<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%-- Layout Tiles 
  This layout render a header, left menu, body and footer.
  @param title String use in page title
  @param header Header tile (jsp url or definition name)
  @param menu Menu 
  @param body Body
  @param footer Footer
--%>

<HTML>
<head><link rel="stylesheet" type="text/css" href="http://bjmac.hccis.info:8080/styles/styles.css"></head>
<!--<head><link rel="stylesheet" type="text/css" href="http://localhost:8080/CISIS_Template_Application/resources/styles/styles.css"></head>-->
    <body> 
        <table>
            <tr>
                <td></td>
                <td align="center"><tiles:insertAttribute name="header"  /></td>
            </tr>
            <tr>
                <td width="10%" valign="top">
                    <tiles:insertAttribute name='menu'/>
                </td>
                <td width="90%" valign="top"  align="center">
                    <tiles:insertAttribute name='body' />
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="center"><tiles:insertAttribute name="footer" /></td>
            </tr>
        </table>
    </body>
</html>