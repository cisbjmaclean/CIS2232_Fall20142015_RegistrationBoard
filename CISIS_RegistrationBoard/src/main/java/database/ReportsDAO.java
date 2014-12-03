package database;

import beans.Member;
import beans.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
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
            System.out.println("****************" + count + "*********************");
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        return count;
    }

    //For report
    public static ArrayList<Member> getAllInactiveMembers() {

        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        ArrayList<Member> members = new ArrayList();
        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT * FROM member_bio mb, member m WHERE "
                    + "m.status_type = 2 and "
                    + "m.created_date_time >= '2014-01-01' and "
                    + "m.member_id = mb.member_id";

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Member newMember = new Member();
                newMember.setMemberId(rs.getInt("member_id"));
                newMember.setFirstName(rs.getString("first_name"));
                newMember.setMiddleName(rs.getString("middle_name"));
                newMember.setLastName(rs.getString("last_name"));
                newMember.setAddressLine1(rs.getString("address_1"));
                newMember.setAddressLine2(rs.getString("address_2"));
                newMember.setMunicipality(rs.getString("municipality"));
                newMember.setProvinceCode(rs.getInt("province_code"));
                newMember.setPostalCode(rs.getString("postal_code"));
                newMember.setHomePhone(rs.getString("home_phone"));
                newMember.setWorkPhone(rs.getString("work_phone"));
                newMember.setWorkPhoneExtension(rs.getString("work_phone_extension"));
                newMember.setFax(rs.getString("fax_number"));
                newMember.setEmailAddress(rs.getString("email_address"));
                newMember.setDateOfBirth(rs.getString("date_of_birth"));
                newMember.setGenderCode(rs.getInt("gender_code"));
                members.add(newMember);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        return members;
    }

    //add for report
    public static ArrayList<Member> confirmMembers(Member member) {

        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        int id = member.getMemberId();
        System.out.println("member id = " + id);
        ArrayList<Member> members = new ArrayList();
        try {
            conn = ConnectionUtils.getConnection();

            sql = "UPDATE member SET status_type = 1 where "
                    + "status_type = 2 and member_id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, member.getMemberId());
            ps.executeUpdate();
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        return members;
    }

    public static void confirmAllMembers() {

        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        ArrayList<Member> members = new ArrayList();
        try {
            conn = ConnectionUtils.getConnection();

            sql = "UPDATE member SET status_type = ? WHERE status_type = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, 2);
            ps.executeUpdate();
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
    }

    // for get all list of waiting from Database
    public static ArrayList<Member> getAllconfirmMembers() {
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        int year = Calendar.getInstance().get(Calendar.YEAR);

        ArrayList<Member> members = new ArrayList();
        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT * FROM member_bio mb, member m WHERE "
                    + "m.confirm_type = 2 and "
                    + "m.created_date_time >= '" + year + "-01-01' and "
                    + "m.member_id = mb.member_id";

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Member newMember = new Member();
                newMember.setMemberId(rs.getInt("member_id"));
                newMember.setFirstName(rs.getString("first_name"));
                newMember.setMiddleName(rs.getString("middle_name"));
                newMember.setLastName(rs.getString("last_name"));
                newMember.setAddressLine1(rs.getString("address_1"));
                newMember.setAddressLine2(rs.getString("address_2"));
                newMember.setMunicipality(rs.getString("municipality"));
                newMember.setProvinceCode(rs.getInt("province_code"));
                newMember.setPostalCode(rs.getString("postal_code"));
                newMember.setHomePhone(rs.getString("home_phone"));
                newMember.setWorkPhone(rs.getString("work_phone"));
                newMember.setWorkPhoneExtension(rs.getString("work_phone_extension"));
                newMember.setFax(rs.getString("fax_number"));
                newMember.setEmailAddress(rs.getString("email_address"));
                newMember.setDateOfBirth(rs.getString("date_of_birth"));
                newMember.setGenderCode(rs.getInt("gender_code"));
                members.add(newMember);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        return members;
    }

    public static void confirmAllConfirmMembers() {
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        ArrayList<Member> members = new ArrayList();
        try {
            conn = ConnectionUtils.getConnection();

            sql = "UPDATE member SET confirm_type = ? WHERE confirm_type = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, 1);
            ps.setInt(2, 2);
            ps.executeUpdate();
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
    }

    public static ArrayList<Member> confirmaMembers(Member aMember) {
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        int id = aMember.getMemberId();
        System.out.println("member id = " + id);
        ArrayList<Member> members = new ArrayList();
        
        try {
            conn = ConnectionUtils.getConnection();

            sql = "UPDATE member SET confirm_type = 1 where "
                    + "confirm_type = 2 and member_id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, aMember.getMemberId());
            ps.executeUpdate();
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        return members;
    }
}
