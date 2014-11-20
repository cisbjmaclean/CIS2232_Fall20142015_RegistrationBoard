package controller;

import beans.Member;
import beans.MemberRegistrationBoard;
import business.MemberBO;
import business.MemberRegistrationBoardBO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    
//    @RequestMapping(method = RequestMethod.GET)
//    public String loadMember(ModelMap model) {
//        
//        model.addAttribute("memberBio", new Member());
//        
//        return "welcome";
//    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("memberBoard") MemberRegistrationBoard memberBoard) {
        //pass validation if they enter "TEST" and "TEST"

        //Use the model to update the database and then return back to the member page.
        System.out.println("submitted member for update, level=" + memberBoard.getLevelCode());
        System.out.println("submitted member for update, name=" + memberBoard.getMember().getLastName());
        System.out.println("Member id to add/edit="+memberBoard.getMember().getMemberId());
        if (memberBoard.getMember().getMemberId() == 0) {
            MemberRegistrationBoardBO.addMember(memberBoard);          
            
        } else {
            try {
                MemberRegistrationBoardBO.updateMemberRegistration(memberBoard);
            } catch (Exception ex) {
                Logger.getLogger(MemberBioUpdateController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("There was an error updating the member");
            }
        }
        
        ModelAndView mv;
        mv = new ModelAndView("memberBio");
        mv.addObject("informationMessage","Member information saved");
        mv.addObject("memberBoard", memberBoard);
        return mv;
    }
}
