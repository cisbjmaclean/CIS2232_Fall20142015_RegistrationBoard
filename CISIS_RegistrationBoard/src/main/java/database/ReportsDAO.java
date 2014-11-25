package database;

import beans.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import util.ConnectionUtils;
import util.DbUtils;

/**
 *
 * @author BJ
 */
public class ReportsDAO extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

    public static ArrayList<Report> getReport(HttpServletRequest request, int memberId) {
        ArrayList<Report> reports = new ArrayList();
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        //Connecting to the database.
        try {
            conn = ConnectionUtils.getConnection();
            //SQL statement gets me all fields require and checks based on memberId.
            sql = "SELECT pd_type.pd_hour, pd_type.pd_title_eng, event.date, event.description, event.hour FROM event,pd_type WHERE member_id=" + memberId + " AND event.pd_code = pd_type.pd_code order by event.date desc";
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Create a new report and set the fields.
                Report report = new Report();
                report.setPdDescription(rs.getString("pd_title_eng"));
                report.setDate(rs.getString("date"));
                report.setDescription(rs.getString("description"));
                report.setHour(rs.getDouble("hour"));
                report.setWeight(rs.getDouble("pd_hour"));
                //Add to the arraylist.
                reports.add(report);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        return reports;
    }
    
    /*
    * This Method connects to the databse and count the results in the event table
    * based on the pd_code given.
    */
    
    public static int getCount(int pDCode) {
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        int count = 0;
        try {
            conn = ConnectionUtils.getConnection();
            sql = "SELECT COUNT(pd_code) FROM event WHERE pd_code=" + pDCode;
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            System.out.println("****************"+count+"*********************");
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        return count;
    }
}
