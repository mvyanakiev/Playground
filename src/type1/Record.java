package type1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static type1.Config.*;

class Record {

    private String employeeId;
    private String projectId;
    private Date dateFrom;
    private Date dateTo;
    private SimpleDateFormat myFormat = new SimpleDateFormat(DATA_FORMAT);

    Record() {
    }

    String getEmployeeId() {
        return this.employeeId;
    }

    void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    String getProjectId() {
        return this.projectId;
    }

    void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    Date getDateFrom() {
        return this.dateFrom;
    }

    void setDateFrom(String dateFrom) {
        this.dateFrom = dataParser(dateFrom);
    }

    Date getDateTo() {
        return this.dateTo;
    }

    void setDateTo(String dateTo) {
        if (dateTo == null || dateTo.isEmpty()) {
            this.dateTo = new Date();
        } else {
            this.dateTo = dataParser(dateTo);
        }
    }

    private Date dataParser(String date) {
        try {
            return myFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
