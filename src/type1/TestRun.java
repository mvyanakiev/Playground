package type1;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestRun {

    public static void main(String[] args) {

        List<Record> records = new ArrayList<>();

        Record rec1 = new Record();
        rec1.setEmployeeId("1");
        rec1.setProjectId("prj1");
        rec1.setDateFrom("2000-01-01");
        rec1.setDateTo("2001-01-01");
        records.add(rec1);

        Record rec2 = new Record();
        rec2.setEmployeeId("2");
        rec2.setProjectId("prj2");
        rec2.setDateFrom("2000-01-01");
        rec2.setDateTo("2002-01-01");
        records.add(rec2);

        Record rec3 = new Record();
        rec3.setEmployeeId("3");
        rec3.setProjectId("prj3");
        rec3.setDateFrom("2000-01-01");
        rec3.setDateTo("2003-01-01");
        records.add(rec3);

        Record rec4 = new Record();
        rec4.setEmployeeId("4");
        rec4.setProjectId("prj3");
        rec4.setDateFrom("2000-01-01");
        rec4.setDateTo("2001-07-07");
        records.add(rec4);


//        String empId1 = "";
//        String empId2 = "";
//        String prjId = "";
//        long period = 0L;

        List<CollectiveProject> collectiveProjects = new LinkedList<>();


        for (int i = 0; i < records.size(); i++) {
            for (int j = i + 1; j < records.size(); j++) {

                Record first = records.get(i);
                Record second = records.get(j);

                if (first.getProjectId().equals(second.getProjectId())) {

                    long period = getPeriod(first.getDateFrom(), first.getDateTo(), second.getDateFrom(), second.getDateTo());

                    if (period > 0) {

                        CollectiveProject project = new CollectiveProject();
                        project.setPeriod(period);
                        project.setFirstEmployeeId(first.getEmployeeId());
                        project.setSecondEmployeeId(second.getEmployeeId());
                        project.setProjectId(first.getProjectId());

                        collectiveProjects.add(project);
                    }


//                    long diff = first.getDateTo().getTime() - first.getDateFrom().getTime();
//
//                    if (diff > period) {
//                        period = diff;
//                        empId1 = first.getEmployeeId();
//                        empId2 = second.getEmployeeId();
//
//                        prjId = first.getProjectId();
//                    }


                }
            }
        }


        for (CollectiveProject collectiveProject : collectiveProjects) {
            System.out.println(collectiveProject.toString());
        }


//        long days = TimeUnit.DAYS.convert(period, TimeUnit.MILLISECONDS);
//        System.out.printf("Days %d , Employee1 is %s, Employee2 is %s, Project ID %s", days, empId1, empId2, prjId);

    }


    private static long getPeriod(Date firstStart, Date firstEnd, Date secondStart, Date secondEnd) {

        Date maxStart = firstStart.getTime() > secondStart.getTime() ? firstStart : secondStart;
        Date minEnd = firstEnd.getTime() < secondEnd.getTime() ? firstEnd : secondEnd;

        long interval = minEnd.getTime() - maxStart.getTime();

        if (interval > 0) {
            return TimeUnit.DAYS.convert(interval, TimeUnit.MILLISECONDS);
        } else {
            return 0;
        }

    }
}



