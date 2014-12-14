package business;

import beans.MemberRegistration;
import database.MemberRegistrationDAO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Mail;

/**
 * This class will handle the processing associated with a business object.
 *
 * @author BJ
 * @since 20140611
 */
public class MemberRegistrationBO {

    public static void updateMemberRegistration(MemberRegistration member) throws Exception {
        //Any validation?

        MemberRegistrationDAO.updateMember(member);
    }

    public static void addMember(MemberRegistration member) {

        try {
            MemberRegistrationDAO.addMemberRegistration(member);
            String emailDetails = " You have been added to the Registration PEI Application.  \r\n User name=" + member.getMember().getNewUserId() + "\r\n Password=rboard"
                    + "\r\n \r\n Access details and change password at:  http://bjmac.hccis.info:8080/RegistrationPEI";
            Mail mail = new Mail(member.getMember().getEmailAddress(), "registrationpei@gmail.com", "Registration PEI new user", emailDetails);
            mail.sendMail();

        } catch (Exception ex) {
            Logger.getLogger(MemberRegistrationBO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return;
    }

    public static ArrayList<MemberRegistration> getAllActiveMembers() {

        return MemberRegistrationDAO.getAllActiveMembers();

    }

    public static MemberRegistration getMember(String memberId) {
        return MemberRegistrationDAO.getMemberRestration(memberId);
    }

    public static MemberRegistration getMemberByUserid(String userId) {
        return MemberRegistrationDAO.getMemberRestrationByUserid(userId);
    }

}