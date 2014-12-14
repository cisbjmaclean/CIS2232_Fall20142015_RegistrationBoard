package services;

import beans.MemberEducation;
import business.MemberEducationBO;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Trevor
 */
@WebService(serviceName = "MemberEd")
public class MemberEd {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getMemberEd")
    public ArrayList<MemberEducation> getMemberEd(@WebParam(name = "memberID") int memberID) {
        return MemberEducationBO.getMemberEducation(memberID);
    }
}