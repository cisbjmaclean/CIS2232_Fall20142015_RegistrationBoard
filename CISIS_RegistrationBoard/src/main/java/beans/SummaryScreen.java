package beans;

/**
 *
 * @author Zachary Theriault
 * @since 2014/11/27
 */
public class SummaryScreen {

    private int memberId = 0;
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";
    private String lastUpdated = "";
    private Object total = 0;

    public SummaryScreen() {
        // Do nothing
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Object getTotal() {
        return total;
    }

    public void setTotal(Object total) {
        this.total = total;
    }

}