package type1;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static type1.Config.*;

public class TestRun {

    public static void main(String[] args) throws IOException {

        List<Record> records = new ArrayList<>();

        FileInputStream fileStream = new FileInputStream(FILE_PATH);
        BufferedReader br = new BufferedReader(new InputStreamReader(fileStream));

        String strLine;

        while ((strLine = br.readLine()) != null)   {

            String [] token = strLine.split(", ");

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

        fileStream.close();









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
                    }
                }
            }
        }

        if (project.getPeriod() == 0) {
            System.out.println(NO_ANSWER_MESSAGE);
        } else {
            System.out.println(project.toString());
        }
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



