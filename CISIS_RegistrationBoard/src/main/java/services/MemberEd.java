/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
} /* @WebMethod(operationName = "getNotification")
    public ArrayList<Notification> getNotification() {
        return NotificationBO.getNotifications();

 public static ArrayList<MemberEducation> getMemberEducation(int memberId) {
        return MemberEducationDAO.getMemberEducation(memberId);
    }*/
