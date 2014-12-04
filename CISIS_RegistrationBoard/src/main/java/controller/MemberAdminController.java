package controller;

import beans.Member;
import beans.MemberRegistration;
import business.MemberBO;
import business.MemberRegistrationBO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the Welcome
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("memberAdmin")
public class MemberAdminController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView onSubmit(HttpServletRequest request) throws Exception {

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
                Logger.getLogger(MemberAdminController.class.getName()).log(Level.SEVERE, null, ex);
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
        } //report
        else if (actionSpecified != null && actionSpecified.equalsIgnoreCase("activeAll")) {
            try {
                MemberBO.confirmAllMembers();
            } catch (Exception ex) {
                Logger.getLogger(MemberAdminController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("There was an error deleting the member.");
            }

            message = "All members is confirmed";
            mv = new ModelAndView("reports");
            mv.addObject("informationMessage", message);
            mv.addObject("members", MemberBO.getAllInactiveMembers());
        } else if (actionSpecified != null && actionSpecified.equalsIgnoreCase("active")) {
            try {
                aMember = MemberBO.getMember(request.getParameter("memberId"));
                MemberBO.confirmMembers(aMember);
            } catch (Exception ex) {
                Logger.getLogger(MemberAdminController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("There was an error deleting the member.");
            }

            message = "confrim members";
            mv = new ModelAndView("reports");
            mv.addObject("informationMessage", message);
            mv.addObject("members", MemberBO.getAllInactiveMembers());
        } else if (actionSpecified != null && actionSpecified.equalsIgnoreCase("confirmAll")) {
            try {
                MemberBO.confirmAllConfirmMembers();
            } catch (Exception ex) {
                Logger.getLogger(MemberAdminController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("There was an error deleting the member.");
            }

            message = "All members is confirmed";
            mv = new ModelAndView("reports");
            mv.addObject("informationMessage", message);
            mv.addObject("members", MemberBO.getAllConfirmMembers());
        } else if (actionSpecified != null && actionSpecified.equalsIgnoreCase("confirm")) {
            try {
                aMember = MemberBO.getMember(request.getParameter("memberId"));
                MemberBO.confirmAmembers(aMember);
            } catch (Exception ex) {
                Logger.getLogger(MemberAdminController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("There was an error deleting the member.");
            }

            message = "confrim members";
            mv = new ModelAndView("reports");
            mv.addObject("informationMessage", message);
            mv.addObject("members", MemberBO.getAllConfirmMembers());
        } else {
            //Get the memberBio
            MemberRegistration memberRegistration = MemberRegistrationBO.getMember(request.getParameter("memberId"));
            mv = new ModelAndView("memberBio");
            mv.addObject("memberRegistration", memberRegistration);
            if (request.getParameter("memberId").equals((String) request.getSession().getAttribute("loggedInUserId"))) {
                request.getSession().setAttribute("loggedInMember", memberRegistration);
            }
        }
        return mv;
    }
}