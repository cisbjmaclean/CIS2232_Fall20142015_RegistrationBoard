/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

/**
 *
 * @author BJ
 */
public class Mail {

    // Recipient's email ID needs to be mentioned.
    private String to = "bj.maclean@gmail.com";

    // Sender's email ID needs to be mentioned
    private String from = "PEIDietitiansBoard@gmail.com";

    // Assuming you are sending email from localhost
    //String host = "localhost";
    private String host = "smtp.gmail.com";
//    private String userName = "PEIDietitiansBoard@gmail.com";
//    private String password = "HockeyDietitians";
    private String userName = "hollandcollegecis@gmail.com";
    private String password = "HC20140501";    
    private String subject = "This is the Subject Line!";
    private String theMessage = "This is actual message";
    private MimeMessage message;

    public Mail() {
        setup();
    }

    public Mail(String to, String from, String subject, String theMessage) {
        this.to = to;
        this.from = from;
        this.subject = subject;
        this.theMessage = theMessage;
        setup();
    }

    private void setup() {
        // Get system properties
        Properties properties = System.getProperties();
        // Setup mail server
        properties.setProperty("mail.smtp.host", host);

        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", userName); // User name
        properties.put("mail.smtp.password", password); // password
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        // Get the default Session object.
//        Session session = Session.getDefaultInstance(properties);
        Session session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("bj.maclean@gmail.com", "firetmkhfnsulcjk");
                    }
                });
        try {
            // Create a default MimeMessage object.
            message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(this.subject);

            // Now set the actual message
            message.setText(this.theMessage);
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

    public void sendMail() {
        try {
            // Send message
            Transport.send(message);
        } catch (MessagingException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Error in sendMail");
        }
        System.out.println("Sent message successfully....");

    }
}
