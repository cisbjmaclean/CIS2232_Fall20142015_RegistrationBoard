package database;

import beans.Member;
import beans.MemberSquash;
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
public class MemberSquashDAO {

    public static void addMemberSquash(MemberSquash memberSquash) throws Exception {

        System.out.println("inserting a new squash member");
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        conn = ConnectionUtils.getConnection();
        try {
            MemberBO.addMember(memberSquash.getMember());

            sql = "INSERT INTO `member_squash`(`member_id`, `division_code`, `level_code`, "
                    + "`club_code`, `registration_date`, `permission_add_to_player_list`, "
                    + "`permission_use_photo`, `payment_status`) "
                    + "VALUES (?,?,?,?,?,?,?,?)";

            ps = conn.prepareStatement(sql);

            //The new member id should be populated now since the object was passed 
            //by reference to the addMember method above.
            ps.setInt(1, memberSquash.getMember().getMemberId());
            ps.setInt(2, memberSquash.getDivisionCode());
            ps.setInt(3, memberSquash.getLevelCode());
            ps.setInt(4, memberSquash.getClubCode());
            ps.setString(5, memberSquash.getRegistrationDate());
            ps.setBoolean(6, memberSquash.isAllowInformationOnWebsite());
            ps.setBoolean(7, memberSquash.isAllowPhotoUse());
            ps.setInt(8, 0);
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

    public static ArrayList<MemberSquash> getAllActiveMembers() {

        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        ArrayList<MemberSquash> membersSquash = new ArrayList();
        ArrayList<Member> members = MemberDAO.getAllActiveMembers();
        for (Member nextMember : members) {
            MemberSquash memberSquash = new MemberSquash();
            memberSquash.setMember(nextMember);
            getMemberSquashComponents(memberSquash);
            membersSquash.add(memberSquash);
        }

        return membersSquash;
    }

    public static MemberSquash getMemberSquashByUserid(String userId) {
        MemberSquash memberSquash = new MemberSquash();
        memberSquash.setMember(MemberDAO.getMemberByUserid(userId));
        getMemberSquashComponents(memberSquash);
        return memberSquash;
    }

    public static MemberSquash getMemberSquashComponents(MemberSquash memberSquash) {

        String sql = "SELECT * FROM member_squash WHERE member_id = " + memberSquash.getMember().getMemberId();
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConnectionUtils.getConnection();

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                memberSquash.setDivisionCode(rs.getInt("division_code"));
                memberSquash.setLevelCode(rs.getInt("level_code"));
                memberSquash.setClubCode(rs.getInt("club_code"));
                memberSquash.setRegistrationDate(rs.getString("registration_date"));
                memberSquash.setAllowInformationOnWebsite(rs.getBoolean("permission_add_to_player_list"));
                memberSquash.setAllowPhotoUse(rs.getBoolean("permission_use_photo"));
                memberSquash.setPaymentStatusCode(rs.getInt("payment_status"));
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);
        } finally {
            DbUtils.close(ps, conn);
        }

        return memberSquash;
    }

    public static MemberSquash getMemberSquash(String memberId) {
        MemberSquash memberSquash = new MemberSquash();
        memberSquash.setMember(MemberDAO.getMember(memberId));
        getMemberSquashComponents(memberSquash);
        return memberSquash;
    }

    /**
     * This method will update.
     *
     * @return
     * @author BJ
     * @since 20131202
     */
    public static void updateMember(MemberSquash member) throws Exception {
        //Have to update the member based on member id.

        MemberDAO.updateMember(member.getMember());
        
        //Also update squash fields
                PreparedStatement psMember = null;
        String sql = null;
        Connection conn = null;
        /*
         * Setup the sql to update or insert the row (based on update flag).
         */
        try {
            conn = ConnectionUtils.getConnection();

            sql = "UPDATE member_squash SET `division_code`=?,`level_code`=?,"
                    + "`club_code`=?,`registration_date`=?,`permission_add_to_player_list`=?,"
                    + "`permission_use_photo`=?,`payment_status`=? WHERE member_id = ? ";

            psMember = conn.prepareStatement(sql);
            psMember.setInt(1, member.getDivisionCode());
            psMember.setInt(2, member.getLevelCode());
            psMember.setInt(3, member.getClubCode());
            psMember.setString(4, member.getRegistrationDate());
            psMember.setBoolean(5, member.isAllowInformationOnWebsite());
            psMember.setBoolean(6, member.isAllowPhotoUse());
            psMember.setInt(7, member.getPaymentStatusCode());
            psMember.setInt(8, member.getMember().getMemberId());
            psMember.executeUpdate();
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            throw e;
        } finally {
            DbUtils.close(psMember, conn);
        }

        
    }
}
