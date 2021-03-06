package controller;

import beans.ChangePassword;
import beans.CodeValue;
import beans.Event;
import beans.MemberEducation;
import beans.MemberEmployer;
import beans.MemberEmployment;
import beans.MemberRegistration;
import beans.Notification;
import business.MemberBO;
import business.MemberEducationBO;
import business.MemberEmploymentBO;
import business.NotificationBO;
import business.ProfessionalDevelopmentBO;
import forms.Menu;
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
@RequestMapping("menu")
public class MenuController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("menu") Menu menu, HttpServletRequest request) {

        MemberRegistration currentMember = (MemberRegistration) request.getSession().getAttribute("currentMember");

        System.out.println("Menu post invoked");
        ModelAndView mv;
        if (menu.getAction().equalsIgnoreCase("Logout")) {
            mv = new ModelAndView("welcome");
        } else if (menu.getAction().equalsIgnoreCase("Education")) {
            System.out.println("Call to Education JSP");
            mv = new ModelAndView("education");
            MemberEducationBO.setupEducation(request, currentMember.getMember().getMemberId());
            mv.addObject("menu", new Menu());
            mv.addObject("informationMessage", "Education");
        } else if (menu.getAction().equalsIgnoreCase("Add Education")) {
            System.out.println("Call to Add Education JSP");
            mv = new ModelAndView("educationAdd");
            MemberEducation me = new MemberEducation();
            me.setMemberId(currentMember.getMember().getMemberId());
            System.out.println("Heading to add education for member=" + currentMember.getMember().getMemberId());
            mv.addObject("memberEducation", me);
            mv.addObject("informationMessage", "Education");
        } else if (menu.getAction().equalsIgnoreCase("Employment")) {
            System.out.println("Call to Employment JSP");
            mv = new ModelAndView("employment");
            MemberEmploymentBO.setupEmployers(request, currentMember.getMember().getMemberId());
            mv.addObject("menu", new Menu());
            mv.addObject("informationMessage", "Employment");
        } else if (menu.getAction().equalsIgnoreCase("Add Employer")) {
            mv = new ModelAndView("addEmployment");
            mv.addObject("memberEmployer", new MemberEmployer());
        } else if (menu.getAction().equalsIgnoreCase("Edit Employer")) {
            mv = new ModelAndView("editEmployment");
            mv.addObject("memberEmployment", new MemberEmployment());
        } else if (menu.getAction().equalsIgnoreCase("Professional Development")) {
            System.out.println("Call to Professinal Development JSP");
            mv = new ModelAndView("pd");
            ProfessionalDevelopmentBO.getEvents(request, currentMember.getMember().getMemberId());
            mv.addObject("menu", new Menu());
            mv.addObject("informationMessage", "Professional Development");
        } else if (menu.getAction().equalsIgnoreCase("Add Event")) {
            mv = new ModelAndView("addEvent");
            // ProfessionalDevelopmentDAO.loadCodes(request);
            System.out.println("user wants to add event");
            mv.addObject("event", new Event());
        } else if (menu.getAction().equalsIgnoreCase("Make Payment")) {
            System.out.println("Payment functionaity to be completed");
            mv = new ModelAndView("main");
            mv.addObject("informationMessage", "Payment functionaity to be completed");
        } //Report
        else if (menu.getAction().equalsIgnoreCase("Reports")) {
            System.out.println("User wants to view the reports");
            mv = new ModelAndView("reports");
            mv.addObject("members", MemberBO.getAllInactiveMembers());
            mv.addObject("memberConfirm", MemberBO.getAllConfirmMembers()); // for get waiting list
        } else if (menu.getAction().equalsIgnoreCase("My Information")) {
            currentMember = (MemberRegistration) request.getSession().getAttribute("loggedInMember");
            request.getSession().setAttribute("currentMember", currentMember);
            System.out.println("User wants to view their information");
            mv = new ModelAndView("memberBio");
            mv.addObject("message", "User selected My information");
            mv.addObject("memberRegistration", currentMember);
        } else if (menu.getAction().equalsIgnoreCase("Add Notification")) {
            System.out.println("User wants to view add a notification");
            mv = new ModelAndView("notificationAdd");
            mv.addObject("notification", new Notification());
        } else if (menu.getAction().equalsIgnoreCase("View Codes")) {
            System.out.println("User wants to view the codes");
            mv = new ModelAndView("viewCodes");
            mv.addObject("message", "User selected view codes");
            mv.addObject("codeValue", new CodeValue());
        } else if (menu.getAction().equalsIgnoreCase("Members")) {
            System.out.println("User wants to view the members");
            mv = new ModelAndView("viewMembers");
            mv.addObject("members", MemberBO.getAllActiveMembers());
        } else if (menu.getAction().equalsIgnoreCase("Change Password")) {
            System.out.println("User wants to change password");
            mv = new ModelAndView("changePassword");
            ChangePassword cp = new ChangePassword();
            cp.setMemberId((String) request.getSession().getAttribute("loggedInUserId"));
            mv.addObject("changePassword", cp);
        } else if (menu.getAction().equalsIgnoreCase("Notifications")) {
            System.out.println("User wants to view the notifications");
            mv = new ModelAndView("notification");
            mv.addObject("notifications", NotificationBO.getNotifications());
            mv.addObject("menu", new Menu());
        } else {
            mv = new ModelAndView("welcome");
        }

        return mv;
    }
}