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
@RequestMapping("register")
public class RegisterController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(HttpServletRequest request, @ModelAttribute("member") Member member) {

        ModelAndView mv;
        MemberBO.addMember(member);

        mv = new ModelAndView("welcome");
        mv.addObject("menu", new Menu());
        return mv;
    }
}
