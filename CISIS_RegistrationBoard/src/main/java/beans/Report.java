package beans;

/**
 *
 * @author Roger Myers
 * @since 2014/06/24
 */
public class Report {

    private String pdDescription = "";
    private String date = "";
    private String description = "";
    private double value = 0.0;
    private double hour = 0.0;
    private double weight = 0.0;
    private int memberId = 0;
    private double total = 0;

    public Report() {
        //Do nothing.
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
    
    //Calculates the value
    public void setValue() {
        //If no hours then value is the weight.
        if (hour == 0) {
            this.value = weight;
        //If their is hours entered then take weight into consideration.    
        } else {
            this.value = hour * weight;
        }
    }
}


