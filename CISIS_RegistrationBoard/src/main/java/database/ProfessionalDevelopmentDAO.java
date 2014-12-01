package database;

import beans.Event;
import beans.ProfessionalDevelopment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import util.ConnectionUtils;
import util.DbUtils;

/**
 *
 * @author Roger Myers
 * @since 2014/06/24
 */
public class ProfessionalDevelopmentDAO {

    public static ArrayList<ProfessionalDevelopment> pds = new ArrayList();

    public static void loadCodes(HttpServletRequest request) {
        //Will load all the different pd types so that can be used in drop down.
        request.getSession().setAttribute("pd_types", getProfessionalDevelopment());
    }

    public static ArrayList<ProfessionalDevelopment> getProfessionalDevelopment() {

        pds.clear();
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT * FROM `pd_type`";

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Setting the results into a new PD.
                ProfessionalDevelopment pd = new ProfessionalDevelopment();
                pd.setPdCode(rs.getInt("pd_code"));
                pd.setPdTitle(rs.getString("pd_title_eng"));
                pd.setPdTitle(rs.getString("pd_title_fr"));
                pd.setPdHour(rs.getInt("pd_hour"));
                pd.setPdComment(rs.getString("pd_comment_eng"));
                pd.setPdComment(rs.getString("pd_comment_fr"));
                pd.setHourReq(rs.getBoolean("hour_req"));
                //Adding result to the arraylist.
                pds.add(pd);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        return pds;
    }

    //Method that accept an event and updates the database.
    public static void updateEvent(Event event) throws Exception {

        System.out.println("updating event");
        PreparedStatement psEvent = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row (based on update flag).
         */
        try {
            conn = ConnectionUtils.getConnection();
            sql = "INSERT INTO event SET event_num=?,member_id=?,pd_code=?,date=?,description=?,hour=? ";

            psEvent = conn.prepareStatement(sql);
            //This next update uses auto increment.
            psEvent.setNull(1, java.sql.Types.INTEGER);
            psEvent.setInt(2, event.getMemberId());
            psEvent.setInt(3, event.getPdCode());
            psEvent.setString(4, event.getDate());
            psEvent.setString(5, event.getDescription());
            //This takes care of null pointers.
            if (event.getHour() != 0.0) {
                psEvent.setDouble(6, event.getHour());
            } else {
                psEvent.setDouble(6, 0.0);
            }
            //Runs the update.
            psEvent.executeUpdate();

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            throw e;
        } finally {
            DbUtils.close(psEvent, conn);
        }
    }
}
