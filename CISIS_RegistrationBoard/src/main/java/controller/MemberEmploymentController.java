package controller;

import beans.Member;
import beans.MemberEmployer;
import beans.MemberRegistration;
import beans.MemberSquash;
import business.MemberBO;
import business.MemberEducationBO;
import business.MemberEmploymentBO;
import business.MemberSquashBO;
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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView onGet(HttpServletRequest request) {

        //check the parameters.
        String actionSpecified = request.getParameter("action");
        System.out.println("Action specified=" + actionSpecified);
        String memberId = request.getParameter("memberId");
        System.out.println("member to delete=" + memberId);

        // Member theMember = MemberBO.getMember(request.getParameter("memberId"));
        Member aMember = new Member();
//        MemberEmployer aEmployer = new MemberEmployer();
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
            mv = new ModelAndView("viewMembers");
            mv.addObject("informationMessage", message);
            mv.addObject("members", MemberBO.getAllActiveMembers());

        } else {
            //Get the memberBio
            //this is for the edit
            MemberSquash memberSquash = MemberSquashBO.getMember(request.getParameter("memberId"));
            mv = new ModelAndView("memberBio");
            mv.addObject("memberSquash", memberSquash);
            if (request.getParameter("memberId").equals((String) request.getSession().getAttribute("loggedInUserId"))) {
                request.getSession().setAttribute("loggedInMember", memberSquash);
            }
        }
        return mv;
    }

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

            try {
                String loggedInUserId = (String) request.getSession().getAttribute("loggedInUserId");
                memberEmployer.setUserId(loggedInUserId);
                MemberEmploymentBO.insertMemberEmployer(memberEmployer);
                informationMessage = "Education added";
            } catch (Exception ex) {
                errorMessage = "Error adding education";
                System.out.println("Error inserting education");
            }

            mv = new ModelAndView("addEmployment");
            mv.addObject("memberEmployer", new MemberEmployer());

        } else {
//            Member member = (Member) request.getAttribute("member");
//            member = MemberBO.getMember(request.getParameter("memberId"));
//            MemberEmployment memberEmployment = (MemberEmployment) request.getAttribute("memberEmployment");
//            //MemberEmployment memberEmployment; 
//            //memberEmployment = MemberEmploymentBO.getMemberEmployment(currentMember.getMember().getMemberId());
//            
//            MemberEmployment me = new MemberEmployment();
//            BeanUtils.copyProperties(me, member);
//            BeanUtils.copyProperties(me, memberEmployment);
//            me.setMemberId(member.getMemberId());
//            MemberRegistration currentMember = (MemberRegistration) request.getSession().getAttribute("currentMember");
//           
//            int memberId = currentMember.getMember().getMemberId();
//            MemberEmployment mEmp = new MemberEmployment();
//            mEmp.setStatusCode(getMemberEmployment(memberId).getStatusCode());
//            mEmp.setCurrencyCode(MemberEmploymentBO.getMemberEmployment(memberId).getCurrencyCode());
//            mEmp.setPracticeJurisdictions(MemberEmploymentBO.getMemberEmployment(memberId).getPracticeJurisdictions());
//            mEmp.setPrimaryIndicator(MemberEmploymentBO.getMemberEmployment(memberId).isPrimaryIndicator());
//            mEmp.setMemberId(MemberEmploymentBO.getMemberEmployment(memberId).getMemberId());
//            mEmp.setPracticeInPersonIndicator(MemberEmploymentBO.getMemberEmployment(memberId).isPracticeInPersonIndicator());
//            mEmp.setPracticeViaTelephoneIndicator(MemberEmploymentBO.getMemberEmployment(memberId).isPracticeViaTelephoneIndicator());
//            mEmp.setPracticeViaInternetIndicator(MemberEmploymentBO.getMemberEmployment(memberId).isPracticeViaInternetIndicator());
//            MemberEmploymentBO.updateEmployment(mEmp);
//            mv = new ModelAndView("welcome");
//            mv.addObject("menu", new Menu());
//            //mv.addObject("informationMessage", "Employer added");
        }
        return mv;
    }

}