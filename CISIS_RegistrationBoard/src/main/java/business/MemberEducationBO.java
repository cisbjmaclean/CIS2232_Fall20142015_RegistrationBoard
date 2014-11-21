package business;

import beans.MemberEducation;
import database.MemberEducationDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;


/**
 * This class will handle the processing associated with a business object.
 *
 * @author BJ
 * @since 20140611
 */
public class MemberEducationBO {

    public static void insertMemberEducation(MemberEducation memberEducation) throws Exception {
        //Any validation?

        MemberEducationDAO.insertMemberEducation(memberEducation);
    }

    public static ArrayList<MemberEducation> getMemberEducation(int memberId) {
        return MemberEducationDAO.getMemberEducation(memberId);
    }

    /**
     * Delete the specified member education (set to inactive)
     *
     * @param memberId
     * @param memberEducationSequence
     */
    public static void deleteMemberEducation(int memberId, int memberEducationSequence) throws Exception {

        MemberEducationDAO.deleteMemberEducation(memberId, memberEducationSequence);

    }

    public static void setupEducation(HttpServletRequest request, int memberId) {
    //public static void setupEducation(HttpServletRequest request, ActionMessages messages, int memberId) {

        
        /* Want to check that the member has information for internship and 
         core education.  Check this and add messages for the user if applicable.
         */

        if (!MemberEducationBO.checkEducation(memberId, MemberEducation.INTERNSHIP_PROGRAM_CODE)) {
//            messages.add("warn", (new ActionMessage("label.no.internship")));
            

        }

        if (!MemberEducationBO.checkCoreEducation(memberId)) {
//            messages.add("warn", (new ActionMessage("label.no.core.education")));
        }

        request.getSession().setAttribute("Education", MemberEducationBO.getMemberEducation(memberId));

    }

    /**
     * This method will check to see if a member has a certain type of program.
     *
     * @param memberId
     * @param programToCheck
     * @return
     */
    public static boolean checkEducation(int memberId, int programToCheck) {
        ArrayList<MemberEducation> memberEducationList = MemberEducationDAO.getMemberEducation(memberId);
        boolean foundProgram = false;

        //If we find an active program of that type in their education list we want
        //to return true;
        for (MemberEducation me : memberEducationList) {
            if ((me.getProgramCode() == programToCheck) && me.isActiveIndicator()) {
                foundProgram = true;
            }
        }
        return foundProgram;
    }

    /**
     * This method will check to see if a member has a core education set.
     *
     * @param memberId
     * @param programToCheck
     * @return
     */
    public static boolean checkCoreEducation(int memberId) {
        ArrayList<MemberEducation> memberEducationList = MemberEducationDAO.getMemberEducation(memberId);
        boolean foundProgram = false;

        //If we find an active program of that type in their 
        for (MemberEducation me : memberEducationList) {
            if ((me.isCoreIndicator()) && me.isActiveIndicator()) {
                foundProgram = true;
            }
        }
        return foundProgram;
    }



}
