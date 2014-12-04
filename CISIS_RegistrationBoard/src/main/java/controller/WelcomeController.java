package controller;

import forms.Login;
import forms.Menu;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the Welcome
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("welcome")
public class WelcomeController {

    private Menu menu;

    @RequestMapping(method = RequestMethod.GET)
    public String showMenu(HttpServletRequest request, @RequestParam Map<String, String> allRequestParams, ModelMap model) {

        this.menu = new Menu();
        model.addAttribute("menu", menu);
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("menu") Menu menu) {

        System.out.println("The form was submitted and the action was ***" + menu.getAction() + "***");
        ModelAndView mv = new ModelAndView("login");
        Login temp = new Login();
        temp.setUsername("test"); //Setting a value to show it is populated on the form. 
        mv.addObject("login", temp);
        return mv;
    }
}