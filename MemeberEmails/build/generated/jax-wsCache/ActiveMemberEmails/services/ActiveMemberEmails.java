
package services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ActiveMemberEmails", targetNamespace = "http://services/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ActiveMemberEmails {


    /**
     * 
     * @param memberID
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "activeEmails", targetNamespace = "http://services/", className = "services.Getname")
    @ResponseWrapper(localName = "activeEmailsResponse", targetNamespace = "http://services/", className = "services.GetnameResponse")
    @Action(input = "http://services/ActiveMemberEmails/activeEmailsRequest", output = "http://services/ActiveMemberEmails/activeEmailsResponse")
    public String activeEmails(
        @WebParam(name = "memberID", targetNamespace = "")
        String memberID);

}