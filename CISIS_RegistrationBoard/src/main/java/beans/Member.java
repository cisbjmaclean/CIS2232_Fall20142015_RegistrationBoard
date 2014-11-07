package beans;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.beanutils.BeanUtils;

/**
 *
 * @author BJ
 */
public class Member {

    private static Path path = Paths.get("c:\\CIS2232\\RegistrationBoard.txt");
    private int memberId;
    private String userId = "";
    private String newUserId = "";
    private String accessString = "";
    private String firstName = "";
    private String middleName = "";
    private String lastName = "";
    private String addressLine1 = "";
    private String addressLine2 = "";
    private String municipality = "";
    private int provinceCode;
    private String postalCode = "";
    private String homePhone = "";
    private String workPhone = "";
    private String workPhoneExtension = "";
    private String fax = "";
    private String emailAddress = "";
    private String dateOfBirth = "";
    private int genderCode;
    private String password;
    private int userType;
    
    public static Path getPath() {
        return path;
    }

    public static void setPath(Path path) {
        Member.path = path;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
    
    
    

//    public Member(int memberId) throws Exception {
//        Member theMember = MemberBO.getMember(String.valueOf(memberId));
//        BeanUtils.copyProperties(this, theMember);
//    }

    public Member() {
        //do nothing
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getNewUserId() {
        return newUserId;
    }

    public void setNewUserId(String newUserId) {
        this.newUserId = newUserId;
    }


    public int getGenderCode() {
        return genderCode;
    }

    public void setGenderCode(int genderCode) {
        this.genderCode = genderCode;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
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

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkPhoneExtension() {
        return workPhoneExtension;
    }

    public void setWorkPhoneExtension(String workPhoneExtension) {
        this.workPhoneExtension = workPhoneExtension;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessString() {
        return accessString;
    }

    public void setAccessString(String accessString) {
        this.accessString = accessString;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    //Method that will timeStamp who logged into the registration board.
    public void fileWrite() throws IOException {
        OutputStream output;
        BufferedWriter writer= null;
        String timeStamp = new SimpleDateFormat("MM, dd : HH:mm:ss").format(Calendar.getInstance().getTime());
        String toWrite = "User login: "+firstName+" "+lastName+"\t"+timeStamp;
        if (writer == null) {
            try {
                output = new BufferedOutputStream(Files.newOutputStream(path, CREATE, APPEND));
                writer = new BufferedWriter(new OutputStreamWriter(output));
            } catch (Exception ioe) {
                System.out.println("There was an error creating the writer");
            }
        }

        writer.write(toWrite);
        writer.newLine();
        writer.flush();
        writer.close();
        
    }

}


