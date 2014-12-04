package controller;

import beans.Event;
import beans.MemberRegistration;
import beans.ProfessionalDevelopment;
import business.ProfessionalDevelopmentBO;
import database.ProfessionalDevelopmentDAO;
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
@RequestMapping("pdHours")
public class PDHoursController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("event") Event event, HttpServletRequest request) throws Exception {

        //Create a new Event object.
        //Set all the variables.
        Event theEvent = (Event) request.getAttribute("event");

        MemberRegistration currentMember = (MemberRegistration) request.getSession().getAttribute("currentMember");
        theEvent.setMemberId(currentMember.getMember().getMemberId());
        //Check to make sure that hours has been set
        if (theEvent.getHour() > 0) {
            //Send information back to request
            request.setAttribute("event", theEvent);
            //Send them to the confirm page.
            ModelAndView mv = new ModelAndView("pdConfirm");
            return mv;
        } else {
            //Send information back to the request
            request.setAttribute("event", theEvent);
            //Return them to the page that asks them for the hours.
            ModelAndView mv = new ModelAndView("pdHours");
            return mv;
        }
    }
}
