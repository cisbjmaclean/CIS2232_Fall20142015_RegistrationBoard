package business;

import database.AccessDAO;
import forms.Login;

/**
 *
 * @author bjmaclean
 */
public class AccessBO {

    public static boolean validate(Login login) throws Exception {
        return AccessDAO.validate(login);
    }

    public static boolean validate(String username, String password) throws Exception {
        Login login = new Login();
        login.setUsername(username);
        login.setPassword(password);
        return validate(login);
    }

}