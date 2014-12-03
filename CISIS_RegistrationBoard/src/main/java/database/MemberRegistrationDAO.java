package database;

import beans.Member;
import beans.MemberRegistration;
import business.MemberBO;
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

    
    public static void addMemberRegistration(MemberRegistration memberBoard) throws Exception {

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
            ps.setInt(2, memberBoard.getSalutationCode());
            ps.setString(3, memberBoard.getPreviousSurnames());
            ps.setBoolean(4, memberBoard.isEmailToMembers());
            ps.setBoolean(5, memberBoard.isEmailToBusiness());
            ps.setBoolean(6, memberBoard.isEmailToGovernment());
            ps.setBoolean(7, memberBoard.isEmailToPEIDAExecutive());   
            ps.setString(8, memberBoard.getWebsite()); 
            ps.setBoolean(9, memberBoard.isBilingual());
            ps.setString(10, memberBoard.getBilingualOther());
            ps.setBoolean(11, memberBoard.isCanadianCitizen());
            ps.setBoolean(12, memberBoard.isLandedImmigrant());
            ps.setInt(13, memberBoard.getCountryOfOriginCode());
            ps.setBoolean(14, memberBoard.isImmigrantAuthorized());
            ps.setString(15, memberBoard.getImmigrantAuthorizedExpiryDate());
            ps.executeUpdate();
            
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

    public static ArrayList<MemberRegistration> getAllActiveMembers() {

        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        ArrayList<MemberRegistration> membersRestration = new ArrayList();
        ArrayList<Member> members = MemberDAO.getAllActiveMembers();
        for (Member nextMember : members) {
            MemberRegistration memberBoard = new MemberRegistration();
            memberBoard.setMember(nextMember);
            getMemberRestrationComponents(memberBoard);
            membersRestration.add(memberBoard);
        }

        return membersRestration;
    }

    public static MemberRegistration getMemberRestrationByUserid(String userId) {
        MemberRegistration memberBoard = new MemberRegistration();
        memberBoard.setMember(MemberDAO.getMemberByUserid(userId));
        getMemberRestrationComponents(memberBoard);
        return memberBoard;
    }

    public static MemberRegistration getMemberRestrationComponents(MemberRegistration memberBoard) {

        String sql = "SELECT * FROM member_bio_registration WHERE member_id = " + memberBoard.getMember().getMemberId();
        PreparedStatement ps = null;
        Connection conn = null;

        try {
            conn = ConnectionUtils.getConnection();

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                memberBoard.setSalutationCode(rs.getInt("salutation_code"));
                memberBoard.setPreviousSurnames(rs.getString("previous_surnames"));
                memberBoard.setEmailToMembers(rs.getBoolean("email_to_members"));
                memberBoard.setEmailToBusiness(rs.getBoolean("email_to_business"));
                memberBoard.setEmailToGovernment(rs.getBoolean("email_to_government"));
                memberBoard.setEmailToPEIDAExecutive(rs.getBoolean("email_to_peida_executive"));
                memberBoard.setWebsite(rs.getString("website_address"));
                memberBoard.setBilingual(rs.getBoolean("bilingual_e_f_ind"));
                memberBoard.setBilingualOther(rs.getString("bilingual_other"));
                memberBoard.setCanadianCitizen(rs.getBoolean("canadian_citizen_ind"));
                memberBoard.setLandedImmigrant(rs.getBoolean("landed_immigrant_ind"));
                memberBoard.setCountryOfOriginCode(rs.getInt("country_of_origin_code"));
                memberBoard.setImmigrantAuthorized(rs.getBoolean("immigrant_authorized_ind"));
                memberBoard.setImmigrantAuthorizedExpiryDate(rs.getString("immigrant_authorized_expiry_date"));

            
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            System.out.println(errorMessage);
        } finally {
            DbUtils.close(ps, conn);
        }

        return memberBoard;
    }

    public static MemberRegistration getMemberRestration(String memberId) {
        MemberRegistration memberBoard = new MemberRegistration();
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
    public static void updateMember(MemberRegistration member) throws Exception {
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
                    + "`email_to_members`=?,`email_to_business`=?,`email_to_government`=?,"
                    + "`email_to_peida_executive`=?,`website_address`=?, `bilingual_e_f_ind`=?, "
                    + "`bilingual_other`=?, `canadian_citizen_ind`=?, `landed_immigrant_ind`=?,"
                    + "`country_of_origin_code`=?, `immigrant_authorized_ind`=?,`immigrant_authorized_expiry_date`=?"
                    + "WHERE member_id = ? ";
            
            psMember = conn.prepareStatement(sql);
            psMember.setInt(1, member.getSalutationCode());
            psMember.setString(2, member.getPreviousSurnames());
            psMember.setBoolean(3, member.isEmailToMembers());
            psMember.setBoolean(4, member.isEmailToBusiness());
            psMember.setBoolean(5, member.isEmailToGovernment());
            psMember.setBoolean(6, member.isEmailToPEIDAExecutive());   
            psMember.setString(7, member.getWebsite()); 
            psMember.setBoolean(8, member.isBilingual());
            psMember.setString(9, member.getBilingualOther());
            psMember.setBoolean(10, member.isCanadianCitizen());
            psMember.setBoolean(11, member.isLandedImmigrant());
            psMember.setInt(12, member.getCountryOfOriginCode());
            psMember.setBoolean(13, member.isImmigrantAuthorized());
            psMember.setString(14, member.getImmigrantAuthorizedExpiryDate());
            psMember.setInt(15, member.getMember().getMemberId());
            psMember.executeUpdate();
 
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
