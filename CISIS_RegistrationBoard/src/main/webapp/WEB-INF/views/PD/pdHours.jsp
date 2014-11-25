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
                <html:form action="PdHours">
                <html:hidden property="memberId" /><html:hidden property="firstName"/><html:hidden property="lastName"/><html:hidden property="pdCode" /><html:hidden property="pdDescription" /><html:hidden property="date" /><html:hidden property="description" />
                <tr>
                    <td><label class="alignCenter"  for="hour">
                            <strong><bean:message key="label.professional.development.hour" /></strong></label><br />
                            <html:text property="hour"></html:text>
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
