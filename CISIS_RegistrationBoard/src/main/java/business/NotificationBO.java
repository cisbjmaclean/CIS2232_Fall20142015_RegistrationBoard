package business;

import beans.Notification;
import database.NotificationDAO;
import java.util.ArrayList;

/**
 * This class will handle the processing associated with a business object.
 *
 * @author BJ
 * @since 20140611
 */
public class NotificationBO {

public static ArrayList<Notification> getNotifications(){
    return NotificationDAO.getNotifications();
}

public static void insertNotification(Notification notification) throws Exception{
    NotificationDAO.insertNotification(notification);
}

public static void deleteNotification(int notificationId) throws Exception{
    NotificationDAO.deleteNotification(notificationId);
}

}
