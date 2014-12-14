package business;

import beans.MemberEmployer;
import beans.MemberEmployment;
import database.MemberEmployerDAO;
import database.MemberEmploymentDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 * This class will handle the processing associated with a business object.
 *
 * @author BJ
 * @since 20140611
 */
public class MemberEmploymentBO {

    public static MemberEmployment getMemberEmployment(int memberId) {
        return MemberEmploymentDAO.getMemberEmployment(memberId);
    }

    public static void updateEmployment(MemberEmployment memberEmployment) throws Exception {
        MemberEmploymentDAO.updateEmployment(memberEmployment);
        return;
    }

    /**
     * Delete the specified member education (set to inactive)
     *
     * @param memberId
     * @param memberEducationSequence
     */
    public static void deleteMemberEmployer(int memberId, int memberEmployerSequence) throws Exception {

        MemberEmployerDAO.deleteMemberEmployer(memberId, memberEmployerSequence);

    }

    public static MemberEmployment loadMemberEmployment(int memberId) {
        MemberEmployment memberEmployment = new MemberEmployment();
        return memberEmployment;
    }

    public static void insertMemberEmployer(MemberEmployer memberEmployer) throws Exception {
        //Any validation?

        MemberEmployerDAO.insertMemberEmployer(memberEmployer);
    }

    public static ArrayList<MemberEmployer> getMemberEmployers(int memberId) {
        return MemberEmployerDAO.getMemberEmployers(memberId);
    }

    public static void setupEmployers(HttpServletRequest request, int memberId) {
        /* Want to check that the member has information for internship and 
         core education.  Check this and add messages for the user if applicable.
         */
        request.setAttribute("memberEmployment", MemberEmploymentBO.getMemberEmployment(memberId));
        request.getSession().setAttribute("Employers", MemberEmploymentBO.getMemberEmployers(memberId));

    }

}