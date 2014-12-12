package database;

import beans.SummaryScreen;
import business.ProfessionalDevelopmentBO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import util.ConnectionUtils;
import util.DbUtils;

/**
 *
 * @author Zachary Theriault
 * @since 2014/11/27
 */
public class SummaryScreenDAO {

    public static ArrayList<SummaryScreen> getUserSummary(HttpServletRequest request, int memberId) {
        ArrayList<SummaryScreen> summary = new ArrayList();
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT * FROM member INNER JOIN member_bio ON member.member_id = member_bio.member_id WHERE member.member_id = " + memberId;

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();         
            ProfessionalDevelopmentBO.getEvents(request, memberId);
            while (rs.next()) {
                SummaryScreen newSummaryScreen = new SummaryScreen();
                newSummaryScreen.setMemberId(memberId);
                newSummaryScreen.setFirstName(rs.getString("first_name"));
                newSummaryScreen.setMiddleName(rs.getString("middle_name"));
                newSummaryScreen.setLastName(rs.getString("last_name"));
                newSummaryScreen.setLastUpdated(rs.getString("updated_date_time"));
                Object total = request.getSession().getAttribute("totalPoints");
                newSummaryScreen.setTotal(total);
                summary.add(newSummaryScreen);  
                
              
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        return summary;
    }

}
