
package services;

import java.util.List;
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
@WebService(name = "MemberEd", targetNamespace = "http://services/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MemberEd {


    /**
     * 
     * @param memberID
     * @return
     *     returns java.util.List<services.MemberEducation>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getMemberEd", targetNamespace = "http://services/", className = "services.GetMemberEd")
    @ResponseWrapper(localName = "getMemberEdResponse", targetNamespace = "http://services/", className = "services.GetMemberEdResponse")
    @Action(input = "http://services/MemberEd/getMemberEdRequest", output = "http://services/MemberEd/getMemberEdResponse")
    public List<MemberEducation> getMemberEd(
        @WebParam(name = "memberID", targetNamespace = "")
        int memberID);

}
