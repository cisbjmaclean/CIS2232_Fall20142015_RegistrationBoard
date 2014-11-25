package beans;

/**
 *
 * @author bjmaclean
 */
public class MemberEmployment{

    private int memberId;
    private boolean primaryIndicator;
    private String action;
    private int statusCode;
    private int currencyCode;
    private boolean practiceViaTelephoneIndicator;
    private boolean practiceViaInternetIndicator;
    private boolean practiceInPersonIndicator;
    private String practiceJurisdictions;

    public boolean isPracticeViaTelephoneIndicator() {
        return practiceViaTelephoneIndicator;
    }

    public void setPracticeViaTelephoneIndicator(boolean practiceViaTelephoneIndicator) {
        this.practiceViaTelephoneIndicator = practiceViaTelephoneIndicator;
    }

    public boolean isPracticeViaInternetIndicator() {
        return practiceViaInternetIndicator;
    }

    public void setPracticeViaInternetIndicator(boolean practiceViaInternetIndicator) {
        this.practiceViaInternetIndicator = practiceViaInternetIndicator;
    }

    public boolean isPracticeInPersonIndicator() {
        return practiceInPersonIndicator;
    }

    public void setPracticeInPersonIndicator(boolean practiceInPersonIndicator) {
        this.practiceInPersonIndicator = practiceInPersonIndicator;
    }

    
    
    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public boolean isPrimaryIndicator() {
        return primaryIndicator;
    }

    public void setPrimaryIndicator(boolean primaryIndicator) {
        this.primaryIndicator = primaryIndicator;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(int currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getPracticeJurisdictions() {
        return practiceJurisdictions;
    }

    public void setPracticeJurisdictions(String practiceJurisdictions) {
        this.practiceJurisdictions = practiceJurisdictions;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
