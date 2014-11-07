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
import org.springframework.web.servlet.view.RedirectView;
import static sun.security.jgss.GSSUtil.login;

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
    public String showMenu(HttpServletRequest request, 
           @RequestParam Map<String,String> allRequestParams, ModelMap model) {
        
        
//        System.out.println("user clicked a province-->"+allRequestParams.get("province"));       
//        System.out.println("parameter for test="+allRequestParams.get("test"));
//        System.out.println("parameter for test2="+allRequestParams.get("test2"));
//        menu.setAction("test");
//        request.getSession().setAttribute("test","This was set");
//        String backFromSession = (String) request.getSession().getAttribute("test");
//        System.out.println("Received back from session="+backFromSession);
        
        //test the web service
        
        
        this.menu = new Menu();
        model.addAttribute("menu", menu);
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("menu") Menu menu) {
        
        System.out.println("The form was submitted and the action was ***" + menu.getAction()+ "***");
        ModelAndView mv = new ModelAndView("login");
        Login temp = new Login();
        temp.setUsername("test"); //Setting a value to show it is populated on the form. 
        mv.addObject("login", temp);
        return mv;
    }
}

