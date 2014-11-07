package database;

import beans.Notification;
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
public class NotificationDAO {

    /**
     * This method will insert.
     *
     * @return
     * @author BJ
     * @since 20140615
     */
    public static void insertNotification(Notification notification) throws Exception {
        System.out.println("inserting notification");
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row.
         */
        try {
            conn = ConnectionUtils.getConnection();

            sql = "INSERT INTO `notification`(`notification_type_code`,  "
                    + "`notification_detail`, `status_code`, `created_date_time`, "
                    + "`created_user_id`, `updated_date_time`, `updated_user_id`) "
                    + "VALUES (?, ?, 1, sysdate(), ?, sysdate(), ?)";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, notification.getNotificationType());
            ps.setString(2, notification.getNotificationDetail());
            ps.setString(3, notification.getUserId());
            ps.setString(4, notification.getUserId());

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
     * @param memberId
     * @param memberEducationSequence 
     */
    public static void deleteNotification(int notificationId) throws Exception{
        
        System.out.println("deleting notification");
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row.
         */
        try {
            conn = ConnectionUtils.getConnection();

            sql = "update notification set status_code = 0, updated_date_time = sysdate() "
                + "where notification_id = ? ";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, notificationId);

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
        

    
    public static ArrayList<Notification> getNotifications() {
        ArrayList<Notification> notifications = new ArrayList();
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT * FROM notification WHERE status_code = 1 order by created_date_time desc";

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Notification newNotification = new Notification();
                newNotification.setNotificationId(rs.getInt("notification_id"));
                newNotification.setNotificationDetail(rs.getString("notification_detail"));
                newNotification.setNotificationType(rs.getInt("notification_type_code"));
                newNotification.setNotificationDate(rs.getString("created_date_time"));
                newNotification.setUserId(rs.getString("created_user_id"));
                notifications.add(newNotification);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        System.out.println("DEBUGGING-Found "+notifications.size()+" notifications");
        return notifications;
    }

}
