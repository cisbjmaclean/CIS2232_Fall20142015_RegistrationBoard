package controller;

import beans.Member;
import beans.MemberEducation;
import beans.MemberEmployer;
import beans.MemberEmployment;
import beans.MemberRegistration;
import beans.MemberSquash;
import business.MemberBO;
import business.MemberEducationBO;
import business.MemberEmploymentBO;
import business.MemberSquashBO;
import forms.Menu;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
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

        } 
         else {
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
//        String notificationToDelete = request.getParameter("delete");
//        if (!(notificationToDelete == null || notificationToDelete.isEmpty())) {
//            try {
//                NotificationBO.deleteNotification(Integer.parseInt(notificationToDelete));
//                informationMessage = "Notification deleted";
//            } catch (Exception ex) {
//                System.out.println("Error deleting notification");
//                errorMessage= "Error deleting notification";
//            }
//        } else {

        //check the parameters.
        String actionSpecified = request.getParameter("action");
        System.out.println("Action specified=" + actionSpecified);
        String memberId = request.getParameter("memberId");
        System.out.println("member to delete=" + memberId);

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

        } else if (actionSpecified != null && actionSpecified.equalsIgnoreCase("add")) {

            try {
                String loggedInUserId = (String) request.getSession().getAttribute("loggedInUserId");
                memberEmployer.setUserId(loggedInUserId);
                MemberEmploymentBO.insertMemberEmployer(memberEmployer);
                informationMessage = "Education added";
            } catch (Exception ex) {
                errorMessage = "Error adding education";
                System.out.println("Error inserting education");
            }

            mv = new ModelAndView("employment");
            MemberRegistration currentMember = (MemberRegistration) request.getSession().getAttribute("currentMember");
            MemberEmploymentBO.setupEmployers(request, currentMember.getMember().getMemberId());
            mv.addObject("menu", new Menu());
            mv.addObject("informationMessage", "Employer added");
        } else {
            MemberRegistration currentMember = (MemberRegistration) request.getSession().getAttribute("currentMember");
            //MemberEmployment memberEmployment; 
            //memberEmployment = MemberEmploymentBO.getMemberEmployment(currentMember.getMember().getMemberId());
            
            //MemberEmployment me = new MemberEmployment();
            //BeanUtils.copyProperties(me, currentMember.getMember().getMemberId());
            //me.setMemberId(currentMember.getMember().getMemberId());
            //MemberEmploymentBO.updateEmployment(MemberEmploymentBO.getMemberEmployment(currentMember.getMember().getMemberId()));
            mv = new ModelAndView("welcome");
            mv.addObject("menu", new Menu());
            //mv.addObject("informationMessage", "Employer added");
        }
        return mv;
    }

}