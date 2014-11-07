package controller;

import beans.CodeValue;
import static database.CodeValueDAO.getCodeValues;
import java.util.ArrayList;
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
@RequestMapping("viewCodes")
public class ViewCodesController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("codeValue") CodeValue codeValue) {
        //pass validation if they enter "TEST" and "TEST"
        ModelAndView mv;
         mv = new ModelAndView("viewCodeValues");
        System.out.println("code type entered="+codeValue.getCodeTypeId());
        ArrayList<CodeValue> test = getCodeValues(String.valueOf(codeValue.getCodeTypeId()));
        mv.addObject("theCollection", test);
        return mv;
    }
}
