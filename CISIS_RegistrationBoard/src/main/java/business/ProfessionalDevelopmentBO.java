package business;

import beans.Report;
import database.ReportsDAO;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

/**
 * This class will handle the processing associated with a business object.  
 * 
 * @author BJ
 * @since 20140611
 */
public class ProfessionalDevelopmentBO {
    public static ArrayList<Report> getEvents(HttpServletRequest request, int memberId) {
    
            //Create a local array list from the DAO results.
            ArrayList<Report> reports = ReportsDAO.getReport(request, memberId);
            Report report = new Report();

            double y = 0;
            //Calculating the value given the weight and hours.
            for (int x = 0; x < reports.size(); ++x) {
                reports.get(x).setValue();
                y = y + reports.get(x).getValue();
                report.setTotal(y);
            }
            //Setting attributes back into the request.
            report.setMemberId(memberId);
            request.setAttribute("report",report);
            request.setAttribute("reports", reports);
            //Going to the results of the report page.
            return reports;

}
}
