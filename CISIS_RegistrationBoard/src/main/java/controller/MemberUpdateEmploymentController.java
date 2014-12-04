package controller;

import beans.MemberEmployment;
import beans.MemberRegistration;
import business.MemberEmploymentBO;
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
@RequestMapping("memberUpdateEmployment")
public class MemberUpdateEmploymentController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("memberEmployment") MemberEmployment memberEmployment, HttpServletRequest request) {

        try {
            MemberRegistration currentMember = (MemberRegistration) request.getSession().getAttribute("currentMember");
            memberEmployment.setMemberId(currentMember.getMember().getMemberId());
            MemberEmploymentBO.updateEmployment(memberEmployment);
        } catch (Exception ex) {
            Logger.getLogger(MemberUpdateEmploymentController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("There was an error updating the member");
        }

        ModelAndView mv;
        mv = new ModelAndView("employment");
        mv.addObject("informationMessage", "Member information saved");
        mv.addObject("memberEmployment");
        return mv;
    }
}