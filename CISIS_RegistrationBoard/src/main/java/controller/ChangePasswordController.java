package controller;

import beans.ChangePassword;
import beans.Member;
import business.MemberBO;
import exceptions.PasswordException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the Change Password
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("changePassword")
public class ChangePasswordController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("changePassword") ChangePassword changePassword, HttpServletRequest request) {
        System.out.println("Change password post invoked");
        try {
            MemberBO.changePassword((Member)request.getSession().getAttribute("loggedInMember"), changePassword);
        } catch (PasswordException ex) {
            System.out.println("There was a password exception");
            Logger.getLogger(ChangePasswordController.class.getName()).log(Level.SEVERE, null, ex);
        }
        ModelAndView mv;
        mv = new ModelAndView("main");
        mv.addObject("informationMessage","Password changed");
        return mv;
    }
}
