package beans;

/**
 *
 * @author bjmaclean
 */
public class MemberEducation {

    private int memberId;
    private int memberEducationSequence;
    private String userId;
    private int programCode;
    private String programDescription;
    private String designation;
    private int year;
    private int provinceCode;
    private String provinceDescription;
    private String institution;
    private boolean coreIndicator;
    private boolean activeIndicator;

    public static final int INTERNSHIP_PROGRAM_CODE = 7;

    public int getMemberEducationSequence() {
        return memberEducationSequence;
    }

    public void setMemberEducationSequence(int memberEducationSequence) {
        this.memberEducationSequence = memberEducationSequence;
    }

    public boolean isActiveIndicator() {
        return activeIndicator;
    }

    public void setActiveIndicator(boolean activeIndicator) {
        this.activeIndicator = activeIndicator;
    }

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public boolean isCoreIndicator() {
        return coreIndicator;
    }

    public void setCoreIndicator(boolean coreIndicator) {
        this.coreIndicator = coreIndicator;
    }

    public String getProvinceDescription() {
        return provinceDescription;
    }

    public void setProvinceDescription(String provinceDescription) {
        this.provinceDescription = provinceDescription;
    }

    public int getProgramCode() {
        return programCode;
    }

    public void setProgramCode(int programCode) {
        this.programCode = programCode;
    }

    public String getProgramDescription() {
        return programDescription;
    }

    public void setProgramDescription(String programDescription) {
        this.programDescription = programDescription;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

}