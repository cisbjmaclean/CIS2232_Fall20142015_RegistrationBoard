package business;

import beans.ChangePassword;
import beans.Member;
import beans.MemberSquash;
import database.MemberDAO;
import database.MemberSquashDAO;
import exceptions.PasswordException;
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
public class MemberSquashBO {

    
    public static void updateMemberSquash(MemberSquash member) throws Exception{
        //Any validation?
        
        MemberSquashDAO.updateMember(member);
    }
    
    public static void addMember(MemberSquash member){
        
        try {
            MemberSquashDAO.addMemberSquash(member);
            String emailDetails = " You have been added to the Squash PEI Application.  \r\n User name="+member.getMember().getNewUserId()+"\r\n Password=rboard"
                    + "\r\n \r\n Access details and change password at:  http://bjmac.hccis.info:8080/SquashPEI";
            Mail mail = new Mail(member.getMember().getEmailAddress(), "squashpei@gmail.com", "Squash PEI new user", emailDetails);
            mail.sendMail();

        } catch (Exception ex) {
            Logger.getLogger(MemberSquashBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return;
    }
    
    public static ArrayList<MemberSquash> getAllActiveMembers(){
        
        return MemberSquashDAO.getAllActiveMembers();
        
        
    }

        public static MemberSquash getMember(String memberId){
            return MemberSquashDAO.getMemberSquash(memberId);
        }
    
        public static MemberSquash getMemberByUserid(String userId){
            return MemberSquashDAO.getMemberSquashByUserid(userId);
        }

}
