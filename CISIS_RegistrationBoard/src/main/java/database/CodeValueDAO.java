package database;

import beans.CodeValue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import util.ConnectionUtils;
import util.DbUtils;

/**
 *
 * @author BJ
 */

public class CodeValueDAO {
public static void loadCodes(HttpServletRequest request){
    System.out.println("About to load codes");
    request.getSession().setAttribute("organizations",getCodeValues("1"));
    request.getSession().setAttribute("statuses",getCodeValues("2"));
    request.getSession().setAttribute("salutations",getCodeValues("3"));
    request.getSession().setAttribute("circulation_groups",getCodeValues("4"));
    request.getSession().setAttribute("provinces",getCodeValues("5"));
    ArrayList<CodeValue> test = getCodeValues("5");
    System.out.println("Loaded "+test.size()+ "provinces");
    request.getSession().setAttribute("genders",getCodeValues("6"));
    request.getSession().setAttribute("countries",getCodeValues("7"));
    request.getSession().setAttribute("programs",getCodeValues("8"));
    request.getSession().setAttribute("employment_statuses",getCodeValues("9"));
    request.getSession().setAttribute("currencies",getCodeValues("10"));
    request.getSession().setAttribute("practice_areas",getCodeValues("11"));
    request.getSession().setAttribute("employment_statuses",getCodeValues("12"));
    request.getSession().setAttribute("employment_categories",getCodeValues("13"));
    request.getSession().setAttribute("funding_sources",getCodeValues("14"));
    request.getSession().setAttribute("positions",getCodeValues("15"));
    request.getSession().setAttribute("notification_types",getCodeValues("16"));
    request.getSession().setAttribute("user_types",getCodeValues("17"));
    request.getSession().setAttribute("divisions",getCodeValues("18"));
    request.getSession().setAttribute("levels",getCodeValues("19"));
    request.getSession().setAttribute("clubs",getCodeValues("20"));
    
    
    return;
}    

public static CodeValue getCodeValueFromSession(HttpServletRequest request, String collectionName, int codeSequenceValue){
    
    ArrayList<CodeValue> theList = (ArrayList<CodeValue>) request.getSession().getAttribute(collectionName);
    boolean found = false;
    int location = 0;
    CodeValue theCodeValue = null;
    while (!found && location < theList.size()){
        if (theList.get(location).getCodeValueSequence() == codeSequenceValue){
            found = true;
            theCodeValue = theList.get(location);
        }
        location++;
    }
    
    return theCodeValue;
} 

public static ArrayList<CodeValue> getCodeValues(String codeTypeId){
        ArrayList<CodeValue> codes = new ArrayList();

        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT * FROM `code_value` WHERE code_type_id = "+codeTypeId;

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // It is possible to get the columns via name
                // also possible to get the columns via the column number
                // which starts at 1

                // e.g. resultSet.getSTring(2);
                CodeValue codeValue = new CodeValue();
                codeValue.setCodeTypeId(Integer.parseInt(codeTypeId));
                codeValue.setCodeValueSequence(rs.getInt("code_value_sequence"));
                codeValue.setDescription(rs.getString("english_description"));
                codeValue.setDescriptionShort(rs.getString("english_description_short"));
                codes.add(codeValue);
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }

        return codes;

}

public static String getCodeValueDescription(int codeTypeId, int sequence){
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        String description = "";
        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT * FROM `code_value` WHERE code_type_id = "+codeTypeId+ " and code_value_sequence = "+sequence;

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                description = rs.getString("english_description");
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }

        return description;

}


}
