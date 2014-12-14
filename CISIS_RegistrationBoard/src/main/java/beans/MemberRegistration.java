package beans;

/**
 *
 * @author BJ
 */
public class MemberRegistration {

    private Member member;
    private int salutationCode;
    private String previousSurnames = "";
    private boolean emailToMembers = false;
    private boolean emailToBusiness = false;
    private boolean emailToGovernment = false;
    private boolean emailToPEIDAExecutive = false;
    private boolean bilingual;
    private String bilingualOther;
    private boolean canadianCitizen;
    private boolean landedImmigrant;
    private int countryOfOriginCode;
    private boolean immigrantAuthorized;
    private String immigrantAuthorizedExpiryDate;
    private String website;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public int getSalutationCode() {
        return salutationCode;
    }

    public void setSalutationCode(int salutationCode) {
        this.salutationCode = salutationCode;
    }

    public String getPreviousSurnames() {
        return previousSurnames;
    }

    public void setPreviousSurnames(String previousSurnames) {
        this.previousSurnames = previousSurnames;
    }

    public boolean isEmailToMembers() {
        return emailToMembers;
    }

    public void setEmailToMembers(boolean emailToMembers) {
        this.emailToMembers = emailToMembers;
    }

    public boolean isEmailToBusiness() {
        return emailToBusiness;
    }

    public void setEmailToBusiness(boolean emailToBusiness) {
        this.emailToBusiness = emailToBusiness;
    }

    public boolean isEmailToGovernment() {
        return emailToGovernment;
    }

    public void setEmailToGovernment(boolean emailToGovernment) {
        this.emailToGovernment = emailToGovernment;
    }

    public boolean isEmailToPEIDAExecutive() {
        return emailToPEIDAExecutive;
    }

    public void setEmailToPEIDAExecutive(boolean emailToPEIDAExecutive) {
        this.emailToPEIDAExecutive = emailToPEIDAExecutive;
    }

    public boolean isBilingual() {
        return bilingual;
    }

    public void setBilingual(boolean bilingual) {
        this.bilingual = bilingual;
    }

    public String getBilingualOther() {
        return bilingualOther;
    }

    public void setBilingualOther(String bilingualOther) {
        this.bilingualOther = bilingualOther;
    }

    public boolean isCanadianCitizen() {
        return canadianCitizen;
    }

    public void setCanadianCitizen(boolean canadianCitizen) {
        this.canadianCitizen = canadianCitizen;
    }

    public boolean isLandedImmigrant() {
        return landedImmigrant;
    }

    public void setLandedImmigrant(boolean landedImmigrant) {
        this.landedImmigrant = landedImmigrant;
    }

    public int getCountryOfOriginCode() {
        return countryOfOriginCode;
    }

    public void setCountryOfOriginCode(int countryOfOriginCode) {
        this.countryOfOriginCode = countryOfOriginCode;
    }

    public boolean isImmigrantAuthorized() {
        return immigrantAuthorized;
    }

    public void setImmigrantAuthorized(boolean immigrantAuthorized) {
        this.immigrantAuthorized = immigrantAuthorized;
    }

    public String getImmigrantAuthorizedExpiryDate() {
        return immigrantAuthorizedExpiryDate;
    }

    public void setImmigrantAuthorizedExpiryDate(String immigrantAuthorizedExpiryDate) {
        this.immigrantAuthorizedExpiryDate = immigrantAuthorizedExpiryDate;
    }

}