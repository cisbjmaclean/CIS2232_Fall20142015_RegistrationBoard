package services;

import beans.Notification;
import business.NotificationBO;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author Trevor
 */
@WebService(serviceName = "Notifications")
public class Notifications {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "getNotification")
    public ArrayList<Notification> getNotification() {
        return NotificationBO.getNotifications();
    }
}