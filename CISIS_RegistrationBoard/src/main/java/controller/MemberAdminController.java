package controller;

import beans.Member;
import beans.MemberSquash;
import business.MemberBO;
import business.MemberSquashBO;
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
            mv.addObject("memberSquash", new MemberSquash());
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
}
