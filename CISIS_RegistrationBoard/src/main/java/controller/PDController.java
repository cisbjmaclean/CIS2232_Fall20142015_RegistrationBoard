package controller;

import beans.Event;
import beans.ProfessionalDevelopment;
import database.ProfessionalDevelopmentDAO;
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
@RequestMapping("pd")
public class PDController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("event") Event event, HttpServletRequest request) {

        System.out.println("The conformation of pd add");

        Event events = (Event) request.getAttribute("event");

        //Check to see if this event requires hours to be entered.
        if (ProfessionalDevelopment.checkHours(event)) {
            request.setAttribute("event", event);
            //Loop through the array.
            for (int x = 0; x < ProfessionalDevelopmentDAO.pds.size(); ++x) {
                //If it has the marker that requires hours forward them to pdHours.
                if (ProfessionalDevelopmentDAO.pds.get(x).getPdCode() == events.getPdCode()) {
                    events.setPdDescription(ProfessionalDevelopmentDAO.pds.get(x).getPdTitle());
                }
            }
            ModelAndView mv = new ModelAndView("pdHours");
            return mv;

            //If hours is not required forward them to pdConfirm to confirm their selection.    
        } else {
            request.setAttribute("event", events);
            for (int x = 0; x < ProfessionalDevelopmentDAO.pds.size(); ++x) {
                if (ProfessionalDevelopmentDAO.pds.get(x).getPdCode() == events.getPdCode()) {
                    events.setPdDescription(ProfessionalDevelopmentDAO.pds.get(x).getPdTitle());
                }
            }
            ModelAndView mv = new ModelAndView("pdConfirm");
            return mv;
        }
    }
}