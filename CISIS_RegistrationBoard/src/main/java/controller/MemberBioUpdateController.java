package controller;

import beans.MemberRegistration;
import business.MemberRegistrationBO;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@RequestMapping("memberBioUpdate")
public class MemberBioUpdateController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("memberRegistration") MemberRegistration memberRegistration) {

        //Use the model to update the database and then return back to the member page.
        System.out.println("submitted member for update, name=" + memberRegistration.getMember().getLastName());
        System.out.println("Member id to add/edit=" + memberRegistration.getMember().getMemberId());
        if (memberRegistration.getMember().getMemberId() == 0) {
            MemberRegistrationBO.addMember(memberRegistration);

        } else {
            try {
                MemberRegistrationBO.updateMemberRegistration(memberRegistration);
            } catch (Exception ex) {
                Logger.getLogger(MemberBioUpdateController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("There was an error updating the member");
            }
        }

        ModelAndView mv;
        mv = new ModelAndView("memberBio");
        mv.addObject("informationMessage", "Member information saved");
        mv.addObject("memberRegistration", memberRegistration);
        return mv;
    }
}