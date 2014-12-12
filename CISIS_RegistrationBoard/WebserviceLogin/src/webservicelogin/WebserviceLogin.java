/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservicelogin;

import services.LoginService;
import services.LoginService_Service;

/**
 *
 * @author Trevor
 */
public class WebserviceLogin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LoginService_Service webLogin = new LoginService_Service();
        Login login = webLogin.getLoginServicePort();
    }
    
}
