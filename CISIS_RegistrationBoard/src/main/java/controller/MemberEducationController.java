package controller;

import beans.Member;
import beans.MemberEducation;
import beans.MemberRegistration;
import beans.MemberSquash;
import business.MemberBO;
import business.MemberEducationBO;
import business.MemberSquashBO;
import forms.Menu;
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
@RequestMapping("memberEducation")
public class MemberEducationController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView onSubmit(HttpServletRequest request) {

        //check the parameters.
        String actionSpecified = request.getParameter("action");
        System.out.println("Action specified=" + actionSpecified);
        System.out.println("Member id=" + request.getParameter("memberId"));
        // Member theMember = MemberBO.getMember(request.getParameter("memberId"));
        Member aMember = new Member();
        String message = "";
        ModelAndView mv;
        if (actionSpecified != null && actionSpecified.equalsIgnoreCase("delete")) {
            try {
                aMember = MemberBO.getMember(request.getParameter("memberId"));
                MemberBO.deleteMember(aMember, (String) request.getSession().getAttribute("loggedInUserId"));
            } catch (Exception ex) {
                Logger.getLogger(MemberEducationController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("There was an error deleting the member.");
            }
            message = "member was deleted";
            mv = new ModelAndView("viewMembers");
            mv.addObject("informationMessage", message);
            mv.addObject("members", MemberBO.getAllActiveMembers());

        } else if (actionSpecified != null && actionSpecified.equalsIgnoreCase("add")) {
            message = "add a member";
            mv = new ModelAndView("memberBio");
            mv.addObject("informationMessage", message);
            mv.addObject("memberRegistration", new MemberRegistration());
        } else {
            //Get the memberBio
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
    public ModelAndView onSubmit(HttpServletRequest request, @ModelAttribute("memberEducation") MemberEducation memberEducation) {
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

        try {
            MemberEducationBO.insertMemberEducation(memberEducation);
            informationMessage = "Education added";
        } catch (Exception ex) {
            errorMessage = "Error adding education";
            System.out.println("Error inserting education");
        }
        ModelAndView mv;
        mv = new ModelAndView("education");
        MemberRegistration loggedInMember = (MemberRegistration) request.getSession().getAttribute("loggedInMember");
        MemberEducationBO.setupEducation(request, loggedInMember.getMember().getMemberId());
        mv.addObject("menu", new Menu());
        mv.addObject("informationMessage", "Education");
        return mv;
    }

}
