package controller;

import beans.Member;
import beans.MemberSquash;
import business.MemberBO;
import business.MemberSquashBO;
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
    public ModelAndView onSubmit(@ModelAttribute("memberSquash") MemberSquash memberSquash) {
        //pass validation if they enter "TEST" and "TEST"

        //Use the model to update the database and then return back to the member page.
        System.out.println("submitted member for update, level=" + memberSquash.getLevelCode());
        System.out.println("submitted member for update, name=" + memberSquash.getMember().getLastName());
        System.out.println("Member id to add/edit="+memberSquash.getMember().getMemberId());
        if (memberSquash.getMember().getMemberId() == 0) {
            MemberSquashBO.addMember(memberSquash);          
            
        } else {
            try {
                MemberSquashBO.updateMemberSquash(memberSquash);
            } catch (Exception ex) {
                Logger.getLogger(MemberBioUpdateController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("There was an error updating the member");
            }
        }
        
        ModelAndView mv;
        mv = new ModelAndView("memberBio");
        mv.addObject("informationMessage","Member information saved");
        mv.addObject("memberSquash", memberSquash);
        return mv;
    }
}
