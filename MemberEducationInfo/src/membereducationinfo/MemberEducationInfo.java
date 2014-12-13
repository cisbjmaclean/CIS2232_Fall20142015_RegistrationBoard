/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package membereducationinfo;

import java.util.List;
import java.util.Scanner;
import services.MemberEd;
import services.MemberEd_Service;
import services.MemberEducation;

/**
 *
 * @author Trevor
 */
public class MemberEducationInfo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MemberEd_Service service = new MemberEd_Service();
        // Create interface of web service
        MemberEd ed = service.getMemberEdPort();

        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Member ID");
        int id = userInput.nextInt();

        // call method with id - return member name
        try {
            List<MemberEducation> edu = ed.getMemberEd(id);
            for (int i = 0; i < edu.size(); i++) {

                System.out.println(edu.get(i).getProgramDescription());
                System.out.println(edu.get(i).getDesignation());
                System.out.println(edu.get(i).getYear());
                System.out.println(edu.get(i).getProvinceDescription());
                System.out.println(edu.get(i).getInstitution());
                
            }
            // System.out.println(notification);
        } catch (Exception err) {
            System.out.println("No education to print");
        }

    }

}
