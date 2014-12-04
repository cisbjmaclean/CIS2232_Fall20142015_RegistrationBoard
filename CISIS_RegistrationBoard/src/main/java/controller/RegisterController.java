package controller;

import beans.Member;
import business.MemberBO;
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