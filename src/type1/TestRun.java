package type1;

import java.util.ArrayList;
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


        String empId1 = "";
        String empId2 = "";
        String prjId = "";
        long period = 0L;



        for (int i = 0; i < records.size(); i++) {
            for (int j = i + 1; j < records.size(); j++) {

                Record one = records.get(i);
                Record two = records.get(j);

                if (one.getProjectId().equals(two.getProjectId())) {

                    long diff = one.getDateTo().getTime() - one.getDateFrom().getTime();

                    if (diff > period) {
                        period = diff;
                        empId1 = one.getEmployeeId();
                        empId2 = two.getEmployeeId();

                        prjId = one.getProjectId();
                    }


                }
            }
        }


            long days = TimeUnit.DAYS.convert(period, TimeUnit.MILLISECONDS);
            System.out.printf("Days %d , Employee1 is %s, Employee2 is %s, Project ID %s", days, empId1, empId2, prjId);



    }
}


