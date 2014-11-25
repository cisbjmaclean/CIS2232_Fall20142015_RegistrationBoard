<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

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

        <table><tr><td ><bean:message key="label.professional.development"/></td></tr>
            <tr ><td>
                    <logic:messagesPresent message="true">
                        <html:messages id="msg2" message="true" property="message1"><div class="infoMessageCheck" style="color: green"><bean:write name="msg2"/></div><br/></html:messages>				  		
                        <html:messages id="msg2" message="true" property="warn"><div class="warnExclaim"  style="color: yellow"><bean:write name="msg2"/></div><br/></html:messages>
                        <html:messages id="msg2" message="true" property="error"><div class="errorX"  style="color: red"><bean:write name="msg2"/></div><br/></html:messages>				  		
                    </logic:messagesPresent>
                    <%-- the html:errors is populated if the validator is used. --%>    
                    <div style="color:red">
                        <html:errors />
                    </div>
                </td></tr>
                <html:form action="PdConfirm">
                <tr>
                    <td>
                        <label class="alignCenter"  for="pdCode">
                            <html:hidden property="pdCode" />
                            <strong><bean:message key="label.professional.development.confirm" /></strong></label><br />
                        <html:hidden property="firstName"/><strong><bean:message key="label.professional.development.confirm.name" /></strong><bean:write name="eventForm" property="firstName" />&nbsp<html:hidden property="lastName"/><bean:write name="eventForm" property="lastName" /><br />  
                        <html:hidden property="memberId" /><strong><bean:message key="label.professional.development.confirm.memberId" /></strong><bean:write name="eventForm" property="memberId" /><br />
                        <html:hidden property="pdDescription" /><strong><bean:message key="label.professional.development.confirm.pdDescription" /></strong><bean:write name="eventForm" property="pdDescription" /><br />
                        <html:hidden property="date" /><strong><bean:message key="label.professional.development.confirm.date" /></strong><bean:write name="eventForm" property="date" /><br />
                        <html:hidden property="description" /><strong><bean:message key="label.professional.development.confirm.description" /></strong><bean:write name="eventForm" property="description" /><br />
                        <logic:greaterThan name="eventForm" value="0" property="hour"><html:hidden property="hour" /><strong><bean:message key="label.professional.development.confirmHours" /></strong><bean:write name="eventForm" property="hour" /></logic:greaterThan><br />
                        </td>
                    </tr>
                    <tr align="center">
                        <td colspan="2">
                            <input type="submit" value=<bean:message key="label.submit"/>
                    </td>
                </tr>
            </table></html:form>

        </body>

</html:html>
