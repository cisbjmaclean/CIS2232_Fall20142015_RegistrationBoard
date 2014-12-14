package services;

import business.MemberBO;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author Trevor
 */
@WebService(serviceName = "ActiveMemberEmails")
public class ActiveMemberEmails {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "activeEmails")
    public String getActiveMembersEmails() {
        return MemberBO.getAllActiveMembersEmails();
    }
}