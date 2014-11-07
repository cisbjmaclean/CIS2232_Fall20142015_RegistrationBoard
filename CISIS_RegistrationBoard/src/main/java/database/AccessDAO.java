/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import forms.Login;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.ConnectionUtils;
import util.Util;

/**
 *
 * @author bjmaclean
 */
public class AccessDAO {

    public static boolean validate(Login login) throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception ex) {
            System.err.println("Error in AccessDAO");
        }
        boolean found = false;
        try {

            //***************************************************************************************
            // This is the sql to obtain the student information from the database.  Note the student_id 
            // attribute is set in the prepared statement (would replace the ?).
            //***************************************************************************************
            sql = "SELECT * FROM member_access WHERE user_id = ?";

            ps = conn.prepareStatement(sql);
            if (Util.debugOn) {
                System.out.println("checking access table for " + login.getUsername());
            }
            ps.setString(1, login.getUsername());
            rs = ps.executeQuery();
            while (rs.next()) {
                if (Util.debugOn) {
                    System.out.println("Password for " + rs.getString("user_id")
                            + " is " + rs.getString("password"));
                }
                if (login.getPassword().equals(rs.getString("password"))) {

                    found = true;
                }
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            //In the finally close the resources used to make this connection to the database.
        } finally {
            ps.close();
            rs.close();
            conn.close();
        }

        return found;
    }

}
