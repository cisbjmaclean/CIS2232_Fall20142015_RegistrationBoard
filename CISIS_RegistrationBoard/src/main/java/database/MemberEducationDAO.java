package database;

import beans.MemberEducation;
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
public class MemberEducationDAO {

    /**
     * This method will insert.
     *
     * @return
     * @author BJ
     * @since 20140615
     */
    public static void insertMemberEducation(MemberEducation memberEducation) throws Exception {
        System.out.println("inserting education");
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row.
         */
        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT max(me_sequence) FROM member_education WHERE member_id = " + memberEducation.getMemberId();

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int nextMESequence = 1;
            if (rs.next()) {
                nextMESequence = rs.getInt(1) + 1;
            }

            sql = "INSERT INTO member_education (member_id, me_sequence, program_code, designation, me_year, "
                    + "me_province_code, me_institution, me_core_ind, me_active_ind, created_date_time, "
                    + "created_user_id, updated_date_time, updated_user_id) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?,?, sysdate(), ?, sysdate(), ?)";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, memberEducation.getMemberId());
            ps.setInt(2, nextMESequence);
            ps.setInt(3, memberEducation.getProgramCode());
            ps.setString(4, memberEducation.getDesignation());
            ps.setInt(5, memberEducation.getYear());
            ps.setInt(6, memberEducation.getProvinceCode());
            ps.setString(7, memberEducation.getInstitution());
            ps.setBoolean(8, memberEducation.isCoreIndicator());
            ps.setInt(9, 1);
            ps.setString(10, memberEducation.getUserId());
            ps.setString(11, memberEducation.getUserId());

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
     * Delete the specified member education (set to inactive)
     *
     * @param memberId
     * @param memberEducationSequence
     */
    public static void deleteMemberEducation(int memberId, int memberEducationSequence) throws Exception {

        System.out.println("inserting education");
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row.
         */
        try {
            conn = ConnectionUtils.getConnection();

            sql = "update member_education set me_active_ind = 0, updated_date_time = sysdate() "
                    + "where member_id = ? and me_sequence=?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, memberId);
            ps.setInt(2, memberEducationSequence);

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

    public static ArrayList<MemberEducation> getMemberEducation(int memberId) {
        ArrayList<MemberEducation> education = new ArrayList();
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT * FROM member_education WHERE member_id = " + memberId + " and me_active_ind = 1";

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MemberEducation newMemberEducation = new MemberEducation();
                newMemberEducation.setMemberId(memberId);
                newMemberEducation.setMemberEducationSequence(rs.getInt("me_sequence"));
                newMemberEducation.setProgramCode(rs.getInt("program_code"));
                newMemberEducation.setProgramDescription(CodeValueDAO.getCodeValueDescription(util.Util.EDUCATION_PROGRAM_CODE_TYPE, newMemberEducation.getProgramCode()));
                newMemberEducation.setDesignation(rs.getString("designation"));
                newMemberEducation.setYear(rs.getInt("me_year"));
                newMemberEducation.setProvinceCode(rs.getInt("me_province_code"));
                newMemberEducation.setProvinceDescription(CodeValueDAO.getCodeValueDescription(util.Util.PROVINCE_CODE_TYPE, newMemberEducation.getProvinceCode()));
                newMemberEducation.setInstitution(rs.getString("me_institution"));
                newMemberEducation.setCoreIndicator(rs.getBoolean("me_core_ind"));
                newMemberEducation.setActiveIndicator(rs.getBoolean("me_active_ind"));
                education.add(newMemberEducation);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        return education;
    }

}