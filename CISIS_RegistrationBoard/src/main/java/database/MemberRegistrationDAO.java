package database;

import beans.Member;
import beans.MemberRegistrationBoard;
import business.MemberBO;
import exceptions.PasswordException;
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
public class MemberRegistrationDAO {

    public static void addMemberRegistration(MemberRegistrationBoard memberBoard) throws Exception {

        System.out.println("inserting a new member");
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        conn = ConnectionUtils.getConnection();
        try {
            MemberBO.addMember(memberBoard.getMember());

            sql = "INSERT INTO `member_bio_registration`(member_id`, `salutation_code`, `previous_surnames`, `email_to_members`, "
                    + "`email_to_business`, `email_to_government`, `email_to_peida_executive`, `website_address`, `bilingual_e_f_ind`, "
                    + "`bilingual_other`, `canadian_citizen_ind`, `landed_immigrant_ind`, `country_of_origin_code`, `immigrant_authorized_ind`, "
                    + "`immigrant_authorized_expiry_date`) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            ps = conn.prepareStatement(sql);

            //The new member id should be populated now since the object was passed 
            //by reference to the addMember method above.
            ps.setInt(1, memberBoard.getMember().getMemberId());
         //   ps.setInt(2, memberBoard.getDivisionCode());
         //   ps.setInt(3, memberBoard.getLevelCode());
         //   ps.setInt(4, memberBoard.getClubCode());
         //   ps.setString(5, memberBoard.getRegistrationDate());
         //   ps.setBoolean(6, memberBoard.isAllowInformationOnWebsite());
         //   ps.setBoolean(7, memberBoard.isAllowPhotoUse());
         //   ps.setInt(8, 0);
         //   ps.executeUpdate();

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            throw e;
        } finally {
            DbUtils.close(ps, conn);
        }
        return;
    }

    public static ArrayList<MemberRegistrationBoard> getAllActiveMembers() {

        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        ArrayList<MemberRegistrationBoard> membersRestration = new ArrayList();
        ArrayList<Member> members = MemberDAO.getAllActiveMembers();
        for (Member nextMember : members) {
            MemberRegistrationBoard memberBoard = new MemberRegistrationBoard();
            memberBoard.setMember(nextMember);
            getMemberRestrationComponents(memberBoard);
            membersRestration.add(memberBoard);
        }

        return membersRestration;
    }

    public static MemberRegistrationBoard getMemberRestrationByUserid(String userId) {
        MemberRegistrationBoard memberBoard = new MemberRegistrationBoard();
        memberBoard.setMember(MemberDAO.getMemberByUserid(userId));
        getMemberRestrationComponents(memberBoard);
        return memberBoard;
    }

    public static MemberRegistrationBoard getMemberRestrationComponents(MemberRegistrationBoard memberBoard) {

        String sql = "SELECT * FROM member_bio_registration WHERE member_id = " + memberBoard.getMember().getMemberId();
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConnectionUtils.getConnection();

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
         //       memberBoard.setDivisionCode(rs.getInt("division_code"));
         //       memberBoard.setLevelCode(rs.getInt("level_code"));
         //       memberBoard.setClubCode(rs.getInt("club_code"));
         //       memberBoard.setRegistrationDate(rs.getString("registration_date"));
         //       memberBoard.setAllowInformationOnWebsite(rs.getBoolean("permission_add_to_player_list"));
         //       memberBoard.setAllowPhotoUse(rs.getBoolean("permission_use_photo"));
         //       memberBoard.setPaymentStatusCode(rs.getInt("payment_status"));
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);
        } finally {
            DbUtils.close(ps, conn);
        }

        return memberBoard;
    }

    public static MemberRegistrationBoard getMemberRestration(String memberId) {
        MemberRegistrationBoard memberBoard = new MemberRegistrationBoard();
        memberBoard.setMember(MemberDAO.getMember(memberId));
        getMemberRestrationComponents(memberBoard);
        return memberBoard;
    }

    /**
     * This method will update.
     *
     * @return
     * @author BJ
     * @since 20131202
     */
    public static void updateMember(MemberRegistrationBoard member) throws Exception {
        //Have to update the member based on member id.

        MemberDAO.updateMember(member.getMember());
        
        //Also update bio_registration fields
                PreparedStatement psMember = null;
        String sql = null;
        Connection conn = null;
        /*
         * Setup the sql to update or insert the row (based on update flag).
         */
        try {
            conn = ConnectionUtils.getConnection();

            sql = "UPDATE member_bio_registration SET `salutation_code`=?,`previous_surnames`=?,"
                    + "`email_to_members`=?,``email_to_business`=?,``email_to_government`=?,"
                    + "`email_to_peida_executive`=?,`website_address`=?, `bilingual_e_f_ind`=?, "
                    + "`bilingual_other`=?, `canadian_citizen_ind`=?, `landed_immigrant_ind`=?,"
                    + "`country_of_origin_code`=?, `immigrant_authorized_ind`=?,`immigrant_authorized_expiry_date`=?"
                    + "WHERE member_id = ? ";
 
        //    psMember = conn.prepareStatement(sql);
        //    psMember.setInt(1, member.getDivisionCode());
        //    psMember.setInt(2, member.getLevelCode());
        //    psMember.setInt(3, member.getClubCode());
        //    psMember.setString(4, member.getRegistrationDate());
        //    psMember.setBoolean(5, member.isAllowInformationOnWebsite());
        //    psMember.setBoolean(6, member.isAllowPhotoUse());
        //    psMember.setInt(7, member.getPaymentStatusCode());
        //    psMember.setInt(8, member.getMember().getMemberId());
        //    psMember.executeUpdate();
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            throw e;
        } finally {
            DbUtils.close(psMember, conn);
        }

        
    }
}
