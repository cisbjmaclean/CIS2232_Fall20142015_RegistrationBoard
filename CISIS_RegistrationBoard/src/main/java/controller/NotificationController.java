package controller;

import beans.Notification;
import business.NotificationBO;
import forms.Menu;
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
@RequestMapping("notification")
public class NotificationController {

//    @RequestMapping(method = RequestMethod.POST)
//    public String loadMember(ModelMap model) {
//
//        model.addAttribute("memberBio", new Member());
//        return "welcome";
//    }
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(HttpServletRequest request, @ModelAttribute("notification") Notification notification) {
        //pass validation if they enter "TEST" and "TEST"
        String informationMessage = "";
        String errorMessage = "";
        String notificationToDelete = request.getParameter("delete");
        if (!(notificationToDelete == null || notificationToDelete.isEmpty())) {
            try {
                NotificationBO.deleteNotification(Integer.parseInt(notificationToDelete));
                informationMessage = "Notification deleted";
            } catch (Exception ex) {
                System.out.println("Error deleting notification");
                errorMessage= "Error deleting notification";
            }
        } else {

            System.out.println("About to add a notification (" + notification.getNotificationDetail() + ")");
            try {
                NotificationBO.insertNotification(notification);
                informationMessage = "Notification added";
            } catch (Exception ex) {
                errorMessage = "Error adding notification";
                System.out.println("Error inserting notification");
            }
        }

        ModelAndView mv;
        mv = new ModelAndView("notification");
        mv.addObject("notifications", NotificationBO.getNotifications());
        mv.addObject("errorMessage",errorMessage);
        mv.addObject("informationMessage",informationMessage);
        mv.addObject("menu", new Menu());

        return mv;
    }
}
