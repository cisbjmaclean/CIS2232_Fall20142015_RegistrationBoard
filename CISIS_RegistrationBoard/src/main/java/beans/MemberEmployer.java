package beans;

import database.CodeValueDAO;

/**
 *
 * @author bjmaclean
 */
public class MemberEmployer {

    private int memberId;
    private int sequence;
    private boolean primaryIndicator;
    private String name = "";
    private String userId;
    private String addressLine1 = "";
    private String addressLine2 = "";
    private String municipality = "";
    private int provinceCode;
    private String postalCode = "";
    private int positionCode;
    private int practiceAreaCode;
    private int employmentStatusCode;
    private int employmentCategoryCode;
    private int fundingSourceCode;
    private String action;

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    
    
    public boolean isPrimaryIndicator() {
        return primaryIndicator;
    }

    public void setPrimaryIndicator(boolean primaryIndicator) {
        this.primaryIndicator = primaryIndicator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getMunicipality() {
        return municipality;
    }

    public void setMunicipality(String municipality) {
        this.municipality = municipality;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(int positionCode) {
        this.positionCode = positionCode;
    }

    public int getPracticeAreaCode() {
        return practiceAreaCode;
    }

    public void setPracticeAreaCode(int practiceAreaCode) {
        this.practiceAreaCode = practiceAreaCode;
    }

    public int getEmploymentStatusCode() {
        return employmentStatusCode;
    }

    public void setEmploymentStatusCode(int employmentStatusCode) {
        this.employmentStatusCode = employmentStatusCode;
    }

    public int getEmploymentCategoryCode() {
        return employmentCategoryCode;
    }

    public void setEmploymentCategoryCode(int employmentCategoryCode) {
        this.employmentCategoryCode = employmentCategoryCode;
    }

    public int getFundingSourceCode() {
        return fundingSourceCode;
    }

    public void setFundingSourceCode(int fundingSourceCode) {
        this.fundingSourceCode = fundingSourceCode;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
