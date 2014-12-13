
package services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for memberEducation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="memberEducation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="activeIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="coreIndicator" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="designation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="institution" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="memberEducationSequence" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="memberId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="programCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="programDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="provinceCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="provinceDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="year" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "memberEducation", propOrder = {
    "activeIndicator",
    "coreIndicator",
    "designation",
    "institution",
    "memberEducationSequence",
    "memberId",
    "programCode",
    "programDescription",
    "provinceCode",
    "provinceDescription",
    "userId",
    "year"
})
public class MemberEducation {

    protected boolean activeIndicator;
    protected boolean coreIndicator;
    protected String designation;
    protected String institution;
    protected int memberEducationSequence;
    protected int memberId;
    protected int programCode;
    protected String programDescription;
    protected int provinceCode;
    protected String provinceDescription;
    protected String userId;
    protected int year;

    /**
     * Gets the value of the activeIndicator property.
     * 
     */
    public boolean isActiveIndicator() {
        return activeIndicator;
    }

    /**
     * Sets the value of the activeIndicator property.
     * 
     */
    public void setActiveIndicator(boolean value) {
        this.activeIndicator = value;
    }

    /**
     * Gets the value of the coreIndicator property.
     * 
     */
    public boolean isCoreIndicator() {
        return coreIndicator;
    }

    /**
     * Sets the value of the coreIndicator property.
     * 
     */
    public void setCoreIndicator(boolean value) {
        this.coreIndicator = value;
    }

    /**
     * Gets the value of the designation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * Sets the value of the designation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDesignation(String value) {
        this.designation = value;
    }

    /**
     * Gets the value of the institution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * Sets the value of the institution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstitution(String value) {
        this.institution = value;
    }

    /**
     * Gets the value of the memberEducationSequence property.
     * 
     */
    public int getMemberEducationSequence() {
        return memberEducationSequence;
    }

    /**
     * Sets the value of the memberEducationSequence property.
     * 
     */
    public void setMemberEducationSequence(int value) {
        this.memberEducationSequence = value;
    }

    /**
     * Gets the value of the memberId property.
     * 
     */
    public int getMemberId() {
        return memberId;
    }

    /**
     * Sets the value of the memberId property.
     * 
     */
    public void setMemberId(int value) {
        this.memberId = value;
    }

    /**
     * Gets the value of the programCode property.
     * 
     */
    public int getProgramCode() {
        return programCode;
    }

    /**
     * Sets the value of the programCode property.
     * 
     */
    public void setProgramCode(int value) {
        this.programCode = value;
    }

    /**
     * Gets the value of the programDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramDescription() {
        return programDescription;
    }

    /**
     * Sets the value of the programDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramDescription(String value) {
        this.programDescription = value;
    }

    /**
     * Gets the value of the provinceCode property.
     * 
     */
    public int getProvinceCode() {
        return provinceCode;
    }

    /**
     * Sets the value of the provinceCode property.
     * 
     */
    public void setProvinceCode(int value) {
        this.provinceCode = value;
    }

    /**
     * Gets the value of the provinceDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProvinceDescription() {
        return provinceDescription;
    }

    /**
     * Sets the value of the provinceDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProvinceDescription(String value) {
        this.provinceDescription = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the year property.
     * 
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     */
    public void setYear(int value) {
        this.year = value;
    }

}
