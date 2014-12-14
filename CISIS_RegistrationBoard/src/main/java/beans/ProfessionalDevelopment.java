package beans;

import database.ProfessionalDevelopmentDAO;
import beans.Event;

/**
 * W
 *
 * @author rmyers6284
 */
public class ProfessionalDevelopment {

    private int pdCode;
    private int pdHour;
    private boolean hourReq;
    private String pdTitle;
    private String pdComment;

    public ProfessionalDevelopment(int pdCode, int pdHour, boolean hourReq, String pdTitle, String pdComment) {
        this.pdCode = pdCode;
        this.pdHour = pdHour;
        this.hourReq = hourReq;
        this.pdTitle = pdTitle;
        this.pdComment = pdComment;
    }

    public ProfessionalDevelopment() {
        //Does nothing.
    }

    public int getPdCode() {
        return pdCode;
    }

    public void setPdCode(int pdCode) {
        this.pdCode = pdCode;
    }

    public int getPdHour() {
        return pdHour;
    }

    public void setPdHour(int pdHour) {
        this.pdHour = pdHour;
    }

    public boolean isHourReq() {
        return hourReq;
    }

    public void setHourReq(boolean hourReq) {
        this.hourReq = hourReq;
    }

    public String getPdTitle() {
        return pdTitle;
    }

    public void setPdTitle(String pdTitle) {
        this.pdTitle = pdTitle;
    }

    public String getPdComment() {
        return pdComment;
    }

    public void setPdComment(String pdComment) {
        this.pdComment = pdComment;
    }

    //Method that checks to see if the event requires hours.
    public static boolean checkHours(Event ev) {
        for (int x = 0; x < ProfessionalDevelopmentDAO.pds.size(); ++x) {
            //Get the professional development from the array list that equals the one entered by the user.
            if (ProfessionalDevelopmentDAO.pds.get(x).getPdCode() == ev.getPdCode()) {
                //If that items has the boolean that requires hours return true;
                if (ProfessionalDevelopmentDAO.pds.get(x).isHourReq()) {
                    return true;
                }
            }
        }
        return false;
    }

}