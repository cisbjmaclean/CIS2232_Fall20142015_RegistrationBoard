package database;

import beans.Member;
import beans.MemberEducation;
import beans.MemberEmployer;
import beans.MemberEmployment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConnectionUtils;
import util.DbUtils;

/**
 *
 * @author BJ
 */
public class MemberEmployerDAO {

    /**
     * Delete the specified member employer (set to inactive)
     * @param memberId
     * @param memberEmployerSequence 
     */
    public static void deleteMemberEmployer(int memberId, int memberEmployerSequence) throws Exception{
        
        System.out.println("deleting an employer");
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row.
         */
        try {
            conn = ConnectionUtils.getConnection();

            sql = "update member_employer set me_active_ind = 0, updated_date_time = sysdate() "
                + "where member_id = ? and me_sequence=?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, memberId);
            ps.setInt(2, memberEmployerSequence);

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

    
    /**
     * This method will insert.
     *
     * @return
     * @author BJ
     * @since 20140615
     */
    //should be synchronized to ensure no duplicate sequence number...
    public static void insertMemberEmployer(MemberEmployer memberEmployer) throws Exception {
        System.out.println("inserting employer");
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row.
         */
        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT max(me_sequence) FROM member_education WHERE member_id = " + memberEmployer.getMemberId();

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int nextMESequence = 1;
            if (rs.next()) {
                nextMESequence = rs.getInt(1) + 1;
            }

            sql = "INSERT INTO member_employer(member_id, me_sequence, me_active_ind, "
                    + "member_employer_primary_ind, employer_name, address_1, address_2, "
                    + "municipality, province_code, postal_code, position_code, "
                    + "practice_area_code, employment_status_code, "
                    + "employment_category_code, funding_source_code, created_date_time, "
                    + "created_user_id, updated_date_time, updated_user_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?, sysdate(), ?, sysdate(), ?)";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, memberEmployer.getMemberId());
            ps.setInt(2, nextMESequence);
            ps.setInt(3, 1);
            ps.setBoolean(4, memberEmployer.isPrimaryIndicator());
            ps.setString(5, memberEmployer.getName());
            ps.setString(6, memberEmployer.getAddressLine1());
            ps.setString(7, memberEmployer.getAddressLine2());
            ps.setString(8, memberEmployer.getMunicipality());
            ps.setInt(9, memberEmployer.getProvinceCode());
            ps.setString(10, memberEmployer.getPostalCode());
            ps.setInt(11, memberEmployer.getPositionCode());
            ps.setInt(12, memberEmployer.getPracticeAreaCode());
            ps.setInt(13, memberEmployer.getEmploymentStatusCode());
            ps.setInt(14, memberEmployer.getEmploymentCategoryCode());
            ps.setInt(15, memberEmployer.getFundingSourceCode());
            ps.setString(16, memberEmployer.getUserId());
            ps.setString(17, memberEmployer.getUserId());

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

//    /**
//     * Delete the specified member education (set to inactive)
//     *
//     * @param memberId
//     * @param memberEducationSequence
//     */
//    public static void deleteMemberEmployer(int memberId, int memberEducationSequence) throws Exception {
//
//        System.out.println("inserting education");
//        PreparedStatement ps = null;
//        String sql = null;
//        Connection conn = null;
//
//        /*
//         * Setup the sql to update or insert the row.
//         */
//        try {
//            conn = ConnectionUtils.getConnection();
//
//            sql = "update member_employer set me_active_ind = 0, updated_date_time = sysdate() "
//                    + "where member_id = ? and me_sequence=?";
//
//            ps = conn.prepareStatement(sql);
//            ps.setInt(1, memberId);
//            ps.setInt(2, memberEducationSequence);
//
//            ps.executeUpdate();
//
//        } catch (Exception e) {
//            String errorMessage = e.getMessage();
//            e.printStackTrace();
//            throw e;
//        } finally {
//            DbUtils.close(ps, conn);
//        }
//        return;
//
//    }

    public static ArrayList<MemberEmployer> getMemberEmployers(int memberId) {
        ArrayList<MemberEmployer> employers = new ArrayList();
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT * FROM member_employer WHERE member_id = " + memberId + " and me_active_ind = 1";
            //sql = "SELECT * FROM member_employer WHERE member_id = 0 and me_active_ind = 1";

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                MemberEmployer newMemberEmployer = new MemberEmployer();
                newMemberEmployer.setMemberId(rs.getInt("member_id"));
                newMemberEmployer.setSequence(rs.getInt("me_sequence"));
                newMemberEmployer.setPrimaryIndicator(rs.getBoolean("member_employer_primary_ind"));
                newMemberEmployer.setName(rs.getString("employer_name"));
                newMemberEmployer.setAddressLine1(rs.getString("address_1"));
                newMemberEmployer.setAddressLine2(rs.getString("address_2"));
                newMemberEmployer.setMunicipality(rs.getString("municipality"));
                newMemberEmployer.setProvinceCode(rs.getInt("province_code"));
                newMemberEmployer.setPostalCode(rs.getString("postal_code"));
                newMemberEmployer.setPositionCode(rs.getInt("position_code"));
                newMemberEmployer.setPracticeAreaCode(rs.getInt("practice_area_code"));
                newMemberEmployer.setEmploymentStatusCode(rs.getInt("employment_status_code"));
                newMemberEmployer.setEmploymentCategoryCode(rs.getInt("employment_category_code"));
                newMemberEmployer.setFundingSourceCode(rs.getInt("funding_source_code"));

                employers.add(newMemberEmployer);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        return employers;
    }

}
