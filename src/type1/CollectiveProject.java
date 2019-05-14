package type1;

public class CollectiveProject {

    private String projectId;
    private String firstEmployeeId;
    private String secondEmployeeId;
    private long period;

    public CollectiveProject() {
    }

    public String getProjectId() {
        return this.projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFirstEmployeeId() {
        return this.firstEmployeeId;
    }

    public void setFirstEmployeeId(String firstEmployeeId) {
        this.firstEmployeeId = firstEmployeeId;
    }

    public String getSecondEmployeeId() {
        return this.secondEmployeeId;
    }

    public void setSecondEmployeeId(String secondEmployeeId) {
        this.secondEmployeeId = secondEmployeeId;
    }

    public long getPeriod() {
        return this.period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return String.format("Employee with ID: %s and Employee with ID: %s work together %d days on Project with ID: %s.",
                this.firstEmployeeId,
                this.secondEmployeeId,
                this.period,
                this.projectId);
    }

}
