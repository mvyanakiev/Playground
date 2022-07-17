package hacker_rank;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ТimeConversion {
    public static void main(String[] args) throws ParseException {
        System.out.println(timeConversion("07:12:13PM"));
    }

    public static String timeConversion(String s) throws ParseException {
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm:ssaa", Locale.US);
        Date date = parseFormat.parse(s);
        return displayFormat.format(date);

//        int hour = Integer.parseInt(s.substring(0, 2)) % 12;
//        if (s.endsWith("PM"))
//            hour += 12;
//        return String.format("%02d", hour) + s.substring(2, 8);
    }
}
