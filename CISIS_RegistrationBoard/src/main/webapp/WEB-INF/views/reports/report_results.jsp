<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>

    <body>

        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>

        <table><tr><td ><h2><bean:message key="label.professional.development"/></h2></td></tr>
            <tr>
                <td>
                    <logic:messagesPresent message="true">
                        <html:messages id="msg2" message="true" property="message1"><div class="infoMessageCheck" style="color: green"><bean:write name="msg2"/></div><br/></html:messages>				  		
                        <html:messages id="msg2" message="true" property="warn"><div class="warnExclaim"  style="color: yellow"><bean:write name="msg2"/></div><br/></html:messages>
                        <html:messages id="msg2" message="true" property="error"><div class="errorX"  style="color: red"><bean:write name="msg2"/></div><br/></html:messages>				  		
                    </logic:messagesPresent>
                    <%-- the html:errors is populated if the validator is used. --%>    
                    <div style="color:red">
                        <html:errors />
                    </div>
                </td>
            </tr>
        </table>    
        <!--------
        label.report.event.type=Event Type
        label.report.event.date=Date
        label.report.event.description=Description
        label.report.event.value=Value
        ---->
        <table>
            <tr>
                <th><h3><bean:message key="label.report.event.type" /></h3></th>
                <th><h3><bean:message key="label.report.event.date" /></h3></th>
                <th><h3><bean:message key="label.report.event.description" /></h3></th>
                <th><h3><bean:message key="label.report.event.value" /></h3></th>
            </tr>
            <c:forEach var="report" items="${requestScope.report}">
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
                
                <td colspan="4"><h3><bean:message key="label.report.event.total" /></strong>&nbsp;&nbsp;<bean:write name="reportForm" property="total"/></u></h3></td>
                
            </tr>
            <tr><td colspan="4"><hr/></td></tr>
            <html:form action="/Menu">
            <tr>
                <td colspan="4">
                    <input type="submit" name="action" value="<bean:message key='label.professional.development.add'/>"/>
                </td>
            </tr>
            </html:form>

        </table>    
    </body>
</html:html>
