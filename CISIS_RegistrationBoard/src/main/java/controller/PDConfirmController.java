package controller;

import beans.Event;
import beans.MemberRegistration;
import business.ProfessionalDevelopmentBO;
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
@RequestMapping("pdConfirm")
public class PDConfirmController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("event") Event event, HttpServletRequest request) throws Exception {

        //Create a new Event object.
        Event theEvent = new Event();
        //Set all the variables.
        MemberRegistration currentMember = (MemberRegistration) request.getSession().getAttribute("currentMember");         
        theEvent.setMemberId(currentMember.getMember().getMemberId());
        theEvent.setFirstName(currentMember.getMember().getFirstName());
        theEvent.setLastName(currentMember.getMember().getLastName());
        theEvent.setDate(event.getDate());
        theEvent.setEventNum(event.getEventNum());
        theEvent.setHour(event.getHour());
       //  theEvent.setMemberId(event.getMemberId());
        theEvent.setPdCode(event.getPdCode());
        theEvent.setDescription(event.getDescription());

        //Pass the theEvent to the PDDAO which will update the database.
        ProfessionalDevelopmentDAO.updateEvent(theEvent);
        //Give them a new JSP with feedbad that the theEvent was added successfully.
        ProfessionalDevelopmentBO.getEvents(request, theEvent.getMemberId());

        ModelAndView mv = new ModelAndView("pd");
        return mv;
    }
}
