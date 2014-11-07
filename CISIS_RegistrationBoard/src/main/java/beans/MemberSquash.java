package beans;

/**
 *
 * @author BJ
 */
public class MemberSquash {

    private Member member;
    private int divisionCode;
    private int levelCode;
    private int clubCode;
    private String registrationDate;
    private boolean allowInformationOnWebsite;
    private boolean allowPhotoUse;
    private int paymentStatusCode ;

    public MemberSquash(){
        member = new Member();
    }
    
    public int getPaymentStatusCode() {
        return paymentStatusCode;
    }

    public void setPaymentStatusCode(int paymentStatusCode) {
        this.paymentStatusCode = paymentStatusCode;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
    
    public int getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(int divisionCode) {
        this.divisionCode = divisionCode;
    }

    public int getLevelCode() {
        return levelCode;
    }

    public void setLevelCode(int levelCode) {
        this.levelCode = levelCode;
    }

    public int getClubCode() {
        return clubCode;
    }

    public void setClubCode(int clubCode) {
        this.clubCode = clubCode;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isAllowInformationOnWebsite() {
        return allowInformationOnWebsite;
    }

    public void setAllowInformationOnWebsite(boolean allowInformationOnWebsite) {
        this.allowInformationOnWebsite = allowInformationOnWebsite;
    }

    public boolean isAllowPhotoUse() {
        return allowPhotoUse;
    }

    public void setAllowPhotoUse(boolean allowPhotoUse) {
        this.allowPhotoUse = allowPhotoUse;
    }

    
}


