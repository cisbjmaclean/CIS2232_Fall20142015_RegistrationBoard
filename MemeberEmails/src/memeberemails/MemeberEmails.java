/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package memeberemails;

import java.util.Scanner;
import services.ActiveMemberEmails;
import services.ActiveMemberEmails_Service;

/**
 *
 * @author Trevor
 */
public class MemeberEmails {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create web service 
        ActiveMemberEmails_Service service = new ActiveMemberEmails_Service();
        // Create interface of web service
        ActiveMemberEmails emails = service.getActiveMemberEmailsPort();

        Scanner userInput = new Scanner(System.in);
        int input = 0;
        while (input != 999) {
            System.out.println("Enter 1: to show Active Member Emails"
                    + "\nEnter 999 to exit");

            input = userInput.nextInt();

            if (input == 1) {
                // call method with id - return member name
                try {
                    String memberEmail = emails.activeEmails();
                    System.out.println(memberEmail);                    
                } catch (Exception membererr) {
                    System.out.println("No active member emails to print");
                }
            } 
        }
    }
}
