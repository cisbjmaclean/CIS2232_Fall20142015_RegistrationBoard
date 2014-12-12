/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import business.MemberBO;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Trevor
 */
@WebService(serviceName = "GetMemberName")
public class GetMemberName {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getname")
    public String getName(@WebParam(name = "memberID") String memberID) {
        return MemberBO.getMemberName(memberID);
    }
}
