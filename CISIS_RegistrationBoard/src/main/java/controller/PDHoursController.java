package controller;

import beans.Event;
import beans.MemberRegistration;
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
@RequestMapping("pdHours")
public class PDHoursController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("event") Event theEvent, HttpServletRequest request) throws Exception {

        //Create a new Event object.
        //Set all the variables.
        
        MemberRegistration currentMember = (MemberRegistration) request.getSession().getAttribute("currentMember");
        theEvent.setMemberId(currentMember.getMember().getMemberId());
        theEvent.setFirstName(currentMember.getMember().getFirstName());
        theEvent.setLastName(currentMember.getMember().getLastName());
        
        //Check to make sure that hours has been set
        if (theEvent.getHour() > 0) {
            //Send information back to request
             ModelAndView mv = new ModelAndView("pdConfirm");
             mv.addObject("event", theEvent);
            //Send them to the confirm page.
           
            return mv;
        } else {
            //Send information back to the request
            ModelAndView mv = new ModelAndView("pdHours");
            mv.addObject("event", theEvent);
            //Return them to the page that asks them for the hours.
            
            return mv;
        }
    }
}
