package beans;

/**
 *
 * @author Roger Myers
 * @since 2014/06/24
 */
public class Event {

    private int eventNum = 0;
    private int memberId = 0;
    private int pdCode = 0;
    private String pdDescription = "";//This is the string that holds the description for the drop down items
    private String date = "";
    private double hour;
    private String description = "";//This is the user entered description for the event.
    private String firstName = "";
    private String lastName = "";

    public Event() {
        //do nothing
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEventNum() {
        return eventNum;
    }

    public void setEventNum(int eventNum) {
        this.eventNum = eventNum;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getPdCode() {
        return pdCode;
    }

    public void setPdCode(int pdCode) {
        this.pdCode = pdCode;
    }

    public String getPdDescription() {
        return pdDescription;
    }

    public void setPdDescription(String pdDescription) {
        this.pdDescription = pdDescription;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

}
