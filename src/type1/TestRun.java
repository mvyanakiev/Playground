package type1;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static type1.Config.NO_PROJECTS_MESSAGE;

public class TestRun {

    public static void main(String[] args) {

        List<Record> records = new ArrayList<>();

//        Record rec1 = new Record();
//        rec1.setEmployeeId("1");
//        rec1.setProjectId("prj1");
//        rec1.setDateFrom("2000-01-01");
//        rec1.setDateTo("2001-01-01");
//        records.add(rec1);
//
//        Record rec2 = new Record();
//        rec2.setEmployeeId("2");
//        rec2.setProjectId("prj2");
//        rec2.setDateFrom("2000-01-01");
//        rec2.setDateTo("2002-01-01");
//        records.add(rec2);
//
//        Record rec3 = new Record();
//        rec3.setEmployeeId("3");
//        rec3.setProjectId("prj3");
//        rec3.setDateFrom("2000-01-01");
//        rec3.setDateTo("2003-01-01");
//        records.add(rec3);
//
//        Record rec4 = new Record();
//        rec4.setEmployeeId("4");
//        rec4.setProjectId("prj3");
//        rec4.setDateFrom("2000-01-01");
//        rec4.setDateTo("2001-07-07");
//        records.add(rec4);
//
//        Record rec5 = new Record();
//        rec5.setEmployeeId("5");
//        rec5.setProjectId("prj3");
//        rec5.setDateFrom("2001-01-01");
//        rec5.setDateTo(null);
//        records.add(rec5);

        String input = "123, prj1, 2000-01-01, 2001-01-01 \n 256, prj2, 2000-01-01, ";

        String[] lines = input.split("\n");

        for (String line : lines) {
            String [] token = line.split(", ");

            Record record = new Record();
            record.setEmployeeId(token[0].trim());
            record.setProjectId(token[1].trim());
            record.setDateFrom(token[2].trim());

            if (token.length > 3) {
                record.setDateTo(token[3].trim());
            } else {
                record.setDateTo("");
            }




            records.add(record);
        }


//        List<CollectiveProject> collectiveProjects = new LinkedList<>();

        CollectiveProject project = new CollectiveProject();
        project.setPeriod(0);
        project.setFirstEmployeeId("");
        project.setSecondEmployeeId("");
        project.setProjectId("");


        for (int i = 0; i < records.size(); i++) {
            for (int j = i + 1; j < records.size(); j++) {

                Record first = records.get(i);
                Record second = records.get(j);

                if (first.getProjectId().equals(second.getProjectId())) {

                    long period = getPeriod(first.getDateFrom(), first.getDateTo(), second.getDateFrom(), second.getDateTo());

                    if (period > 0 && period > project.getPeriod()) {

                        project.setPeriod(period);
                        project.setFirstEmployeeId(first.getEmployeeId());
                        project.setSecondEmployeeId(second.getEmployeeId());
                        project.setProjectId(first.getProjectId());

//                        collectiveProjects.add(project);
                    }
                }
            }
        }

        if (project.getPeriod() == 0) {
            System.out.println(NO_PROJECTS_MESSAGE);
        } else {
            System.out.println(project.toString());
        }


//        for (CollectiveProject collectiveProject : collectiveProjects) {
//            System.out.println(collectiveProject.toString());
//        }

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



