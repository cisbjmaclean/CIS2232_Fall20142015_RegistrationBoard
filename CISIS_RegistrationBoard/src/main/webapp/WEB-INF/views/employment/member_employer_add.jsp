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
        
       <script type="text/javascript">
function showDesignation(test) {
    if (test == 7) {
            document.getElementById('the_designation').style.display='none';
        //alert(test);
    } else {
        document.getElementById('the_designation').style.display='block';
    }
//    alert('test2');
}
</script> 
        
        
    </head>

    <body>
        <h2><bean:message key="label.add.employer"/></h2>
        <div>
            <html:form action="MemberEmployerAdd">

                <table>                
            <tr ><td>
                    <logic:messagesPresent message="true">
                        <html:messages id="msg2" message="true" property="message1"><div class="infoMessageCheck"><bean:write name="msg2"/></div><br/></html:messages>				  		
                        <html:messages id="msg2" message="true" property="warn"><div class="warnExclaim"><bean:write name="msg2"/></div><br/></html:messages>
                        <html:messages id="msg2" message="true" property="error"><div class="errorX"><bean:write name="msg2"/></div><br/></html:messages>				  		
                    </logic:messagesPresent>
                    <%-- the html:errors is populated if the validator is used. --%>    
                    <div style="color:red">
                        <html:errors />
                    </div>
                </td></tr>
                    
            <tr>
                        <td colspan="2">
                            <html:checkbox property="primaryIndicator" >
                                <bean:message key="label.primary.indicator"/>
                            </html:checkbox>
                        </td>
                    </tr>
                    
                    <tr>
                        <td>
                            <label class="alignCenter" for="name">
                                <strong><bean:message key="label.name" /></strong></label>
                                <html:text property="name" size="40" />
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="alignCenter"  for="addressLine1">
                                <strong><bean:message key="label.address.line.1" /></strong></label>
                                <html:text property="addressLine1" size="50" />
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="alignCenter"  for="addressLine2">
                                <strong><bean:message key="label.address.line.2" /></strong></label>
                                <html:text property="addressLine2" size="50" />
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="alignCenter"  for="municipality">
                                <strong><bean:message key="label.municipality" /></strong></label>
                                <html:text property="municipality" size="50" />
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="alignCenter"  for="provinceCode">
                                <strong><bean:message key="label.province" /></strong></label>
                                <html:select property="provinceCode">  
                                    <html:optionsCollection  name="provinces" value="codeValueSequence" label="description" />  
                                </html:select>                         
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="alignCenter"  for="postalCode">
                                <strong><bean:message key="label.postal.code" /></strong></label>
                                <html:text property="postalCode" size="6" />
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="alignCenter"  for="positionCode">
                                <strong><bean:message key="label.position" /></strong></label>
                                <html:select property="positionCode">  
                                    <html:optionsCollection  name="positions" value="codeValueSequence" label="description" />  
                                </html:select>                         
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="alignCenter"  for="practiceAreaCode">
                                <strong><bean:message key="label.practice.area" /></strong></label>
                                <html:select property="practiceAreaCode">  
                                    <html:optionsCollection  name="practice_areas" value="codeValueSequence" label="description" />  
                                </html:select>                         
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="alignCenter"  for="employmentStatusCode">
                                <strong><bean:message key="label.employment.status" /></strong></label>
                                <html:select property="employmentStatusCode">  
                                    <html:optionsCollection  name="employment_statuses" value="codeValueSequence" label="description" />  
                                </html:select>                         
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="alignCenter"  for="employmentCategoryCode">
                                <strong><bean:message key="label.employment.category" /></strong></label>
                                <html:select property="employmentCategoryCode">  
                                    <html:optionsCollection  name="employment_categories" value="codeValueSequence" label="description" />  
                                </html:select>                         
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <label class="alignCenter"  for="fundingSourceCode">
                                <strong><bean:message key="label.funding.source" /></strong></label>
                                <html:select property="fundingSourceCode">  
                                    <html:optionsCollection  name="funding_sources" value="codeValueSequence" label="description" />  
                                </html:select>                         
                        </td>
                    </tr>
                    
                    <tr/>
                    <tr align="center">
                        <td colspan="2">
                            <input type="submit" value=<bean:message key="label.add.employer"/>
                        </td>
                    </tr>
                </table>
            </html:form>
        </div>


    </body>

</html:html>
