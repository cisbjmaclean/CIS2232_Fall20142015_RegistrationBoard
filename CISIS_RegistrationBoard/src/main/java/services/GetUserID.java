/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Member;
import business.MemberBO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Trevor
 */
@WebService(serviceName = "GetUserID")
public class GetUserID {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getUserId")
    public Member getUserID(@WebParam(name = "userID") String userID) {
        return MemberBO.getMemberByUserid(userID);
    }
}
