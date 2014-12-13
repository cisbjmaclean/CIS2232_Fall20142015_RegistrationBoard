/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getnotifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import services.Notification;
import services.Notifications;
import services.Notifications_Service;

/**
 *
 * @author Trevor
 */
public class GetNotifications {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Notifications_Service service = new Notifications_Service();
        // Create interface of web service
        Notifications notify = service.getNotificationsPort();

        Scanner userInput = new Scanner(System.in);
        int input = 0;
        while (input != 999) {
            System.out.println("Enter 1: to show Notifications"
                    + "\nEnter 999 to exit");

            input = userInput.nextInt();

            if (input == 1) {
                // call method with id - return member name
                try {
                    List<Notification> notification = notify.getNotification();
                    for(int i = 0; i < notification.size(); i++){
                        
                        System.out.println(notification.get(i).getNotificationDetail());
                    } 
                   // System.out.println(notification);
                } catch (Exception err) {
                    System.out.println("No notifications to print");
                }
            } 
        }
    }
    
}
