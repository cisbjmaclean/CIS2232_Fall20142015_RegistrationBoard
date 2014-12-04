package controller;

import beans.Member;
import beans.MemberRegistration;
import business.AccessBO;
import business.MemberBO;
import business.MemberRegistrationBO;
import database.CodeValueDAO;
import forms.Login;
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
@RequestMapping("login")
public class LoginController {

    private Login login;
    Menu menu;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(HttpServletRequest request, @ModelAttribute("login") Login login) {
        System.out.println("The form was submitted and the username was ***" + login.getUsername() + "***");

        ModelAndView mv;
        boolean validCredentials = false;

        if (login.getAction().equalsIgnoreCase("register")) {
            System.out.println("User wants to add themselfs");
            mv = new ModelAndView("register");
            Member member = new Member();
            mv.addObject("member", member);
        } else {
            try {
                validCredentials = AccessBO.validate(login);
            } catch (Exception ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (validCredentials) {

                CodeValueDAO.loadCodes(request);
                mv = new ModelAndView("summary");
                System.out.println("getting member for " + login.getUsername());
                request.getSession().setAttribute("loggedInUserId", login.getUsername());
                MemberRegistration theMember = MemberRegistrationBO.getMemberByUserid(login.getUsername());
                theMember.getMember().setPassword(login.getPassword());
                request.getSession().setAttribute("loggedInMember", theMember);
                request.getSession().setAttribute("currentMember", theMember);
                mv.addObject("memberRegistration", theMember);
                mv.addObject("summaryScreen", MemberBO.getUserSummary(theMember.getMember().getMemberId()));
            } else {
                mv = new ModelAndView("login");
            }
        }
        return mv;
    }
}