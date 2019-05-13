package type1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {

    private String employeeId;
    private String projectId;
    private Date dateFrom;
    private Date dateTo;

    private static SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

    public Record() {
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Date getDateFrom() {
        return this.dateFrom;
    }

    public void setDateFrom(String dateFrom) {

        try {
            this.dateFrom = myFormat.parse(dateFrom);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date getDateTo() {
        return this.dateTo;
    }

    public void setDateTo(String dateTo) {

        try {
            this.dateTo = myFormat.parse(dateTo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
