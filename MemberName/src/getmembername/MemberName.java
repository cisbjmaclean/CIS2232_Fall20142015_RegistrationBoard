/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package getmembername;

import java.util.Scanner;
import services.GetMemberName;
import services.GetMemberName_Service;

/**
 *
 * @author Trevor
 */
public class MemberName {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create web service 
        GetMemberName_Service service = new GetMemberName_Service();
        // Create interface of web service
        GetMemberName name = service.getGetMemberNamePort();

        Scanner userInput = new Scanner(System.in);

        System.out.println("Enter Member ID");
        String id = userInput.nextLine();

        // call method with id - return member name
        try {
            String memberName = name.getname(id);
            System.out.println(memberName);
        } catch (Exception membererr) {
            System.out.println(membererr + "Member does not exist");
        }
    }

}
