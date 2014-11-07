package beans;

/**
 * This action form will contain information about a notification in the system.
 * 
 * @author bjmaclean
 */
public class Notification {
    private int memberId;
    private String userId;
    private String action;
    private String notificationDate;
    private int notificationType; 
    private String notificationDetail;
    private int notificationId;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(String notificationDate) {
        this.notificationDate = notificationDate;
    }

    public int getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(int notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotificationDetail() {
        return notificationDetail;
    }

    public void setNotificationDetail(String notificationDetail) {
        this.notificationDetail = notificationDetail;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }
    
    
    
}
