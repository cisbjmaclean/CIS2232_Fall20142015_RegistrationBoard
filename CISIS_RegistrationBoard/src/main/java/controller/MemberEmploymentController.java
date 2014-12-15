package controller;

import beans.Member;
import beans.MemberEmployer;
import beans.MemberRegistration;
import business.MemberBO;
import business.MemberEducationBO;
import business.MemberEmploymentBO;
import business.MemberRegistrationBO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the Welcome
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("memberEmployment")
public class MemberEmploymentController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(HttpServletRequest request, @ModelAttribute("memberEmployer") MemberEmployer memberEmployer) throws Exception {
        //pass validation if they enter "TEST" and "TEST"
        String informationMessage = "";
        String errorMessage = "";

        //check the parameters.
        String actionSpecified = request.getParameter("action");
        System.out.println("Action specified=" + actionSpecified);
       //  String memberId = request.getParameter("memberId");
        //  System.out.println("member to delete=" + memberId);

        // Member theMember = MemberBO.getMember(request.getParameter("memberId"));
        Member aMember = new Member();
        String message = "";
        ModelAndView mv = new ModelAndView("welcome");
        if (actionSpecified != null && actionSpecified.equalsIgnoreCase("delete")) {
            try {
                String educationId = request.getParameter("educationId");
                aMember = MemberBO.getMember(request.getParameter("memberId"));
                MemberEducationBO.deleteMemberEducation(aMember.getMemberId(), Integer.parseInt(educationId));
            } catch (Exception ex) {
                Logger.getLogger(MemberEmploymentController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("There was an error deleting the member.");
            }
            message = "member was deleted";
            mv = new ModelAndView("education");
            MemberRegistration currentMember = (MemberRegistration) request.getSession().getAttribute("currentMember");
            MemberEducationBO.setupEducation(request, currentMember.getMember().getMemberId());
            mv.addObject("informationMessage", message);
            mv.addObject("members", MemberBO.getAllActiveMembers());

        } else if (actionSpecified != null && actionSpecified.equalsIgnoreCase("Add Employer")) {

            MemberRegistration currentMember = (MemberRegistration) request.getSession().getAttribute("currentMember");
            // String loggedInUserId = (String) request.getSession().getAttribute("loggedInUserId");
            memberEmployer.setMemberId(currentMember.getMember().getMemberId());

            mv = new ModelAndView("addEmployment");
            mv.addObject("memberEmployer", new MemberEmployer());

        } else {
            
            try {
                MemberRegistration currentMember = (MemberRegistration) request.getSession().getAttribute("currentMember");
                String loggedInUserId = (String) request.getSession().getAttribute("loggedInUserId");
                memberEmployer.setMemberId(currentMember.getMember().getMemberId());
                memberEmployer.setUserId(loggedInUserId);
                MemberEmploymentBO.insertMemberEmployer(memberEmployer);
                informationMessage = "Education added";
            } catch (Exception ex) {
                errorMessage = "Error adding education";
                System.out.println("Error inserting education");
            }

            mv = new ModelAndView("employment");
            mv.addObject("memberEmployer", new MemberEmployer());
        }
        return mv;
    }

}
