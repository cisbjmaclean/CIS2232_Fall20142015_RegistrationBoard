package beans;

/**
 *
 * @author BJ
 */
public class CodeValue {

    private String description;
    private String descriptionShort;
    private int codeTypeId;
    private int codeValueSequence;

    public CodeValue(String description, String descriptionShort, int codeTypeId, int codeValueSequence) {
        this.description = description;
        this.descriptionShort = descriptionShort;
        this.codeTypeId = codeTypeId;
        this.codeValueSequence = codeValueSequence;
    }

    public CodeValue(){
        //nothing.
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public void setDescriptionShort(String descriptionShort) {
        this.descriptionShort = descriptionShort;
    }

    public int getCodeTypeId() {
        return codeTypeId;
    }

    public void setCodeTypeId(int codeTypeId) {
        this.codeTypeId = codeTypeId;
    }

    public int getCodeValueSequence() {
        return codeValueSequence;
    }

    public void setCodeValueSequence(int codeValueSequence) {
        this.codeValueSequence = codeValueSequence;
    }

    
}
