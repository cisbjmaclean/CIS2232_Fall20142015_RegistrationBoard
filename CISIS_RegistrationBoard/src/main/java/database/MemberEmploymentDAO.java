package database;

import beans.Member;
import beans.MemberEmployment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import util.ConnectionUtils;
import util.DbUtils;

/**
 *
 * @author BJ
 */
public class MemberEmploymentDAO {

    public static MemberEmployment getMemberEmployment(int memberId) {
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        MemberEmployment memberEmployment = new MemberEmployment();
        memberEmployment.setMemberId(memberId);
        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT * FROM member_employment WHERE member_id = " + memberId;

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                memberEmployment.setStatusCode(rs.getInt("employment_status_code"));
                memberEmployment.setCurrencyCode(rs.getInt("currency_code"));
                memberEmployment.setPracticeViaTelephoneIndicator(rs.getBoolean("practice_via_telephone_ind"));
                memberEmployment.setPracticeViaInternetIndicator(rs.getBoolean("practice_via_internet_ind"));
                memberEmployment.setPracticeInPersonIndicator(rs.getBoolean("practice_in_person_ind"));
                memberEmployment.setPracticeJurisdictions(rs.getString("practice_jurisdictions"));
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        return memberEmployment;
    }

    
    public static void updateEmployment(MemberEmployment memberEmployment) throws Exception {

        System.out.println("updating employer");
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        
        /*
         * Setup the sql to update or insert the row.
         */
        try {
            conn = ConnectionUtils.getConnection();
            sql = "UPDATE member_employment SET "
                    + "employment_status_code=?, currency_code=?,"
                    + "practice_via_telephone_ind=?, practice_via_internet_ind=?,"
                    + "practice_in_person_ind=?, practice_jurisdictions=? "
                    + "WHERE member_id = ?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, memberEmployment.getStatusCode());
            ps.setInt(2, memberEmployment.getCurrencyCode());
            ps.setBoolean(3, memberEmployment.isPracticeViaTelephoneIndicator());
            ps.setBoolean(4, memberEmployment.isPracticeViaInternetIndicator());
            ps.setBoolean(5, memberEmployment.isPracticeInPersonIndicator());
            ps.setString(6, memberEmployment.getPracticeJurisdictions());
            ps.setInt(7, memberEmployment.getMemberId());

            ps.executeUpdate();

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            throw e;
        } finally {
            DbUtils.close(ps, conn);
        }
        return;

    }

}
