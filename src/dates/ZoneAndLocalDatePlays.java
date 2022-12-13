package dates;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class ZoneAndLocalDatePlays {
    public static void main(String[] args) {

        ZonedDateTime eventDate = ZonedDateTime.of(LocalDateTime.now() , ZoneOffset.UTC);

        System.out.println("UTC Zoned initial = " + eventDate);

        ZoneId cetZone = ZoneId.of("CET");
        ZonedDateTime cetZoned = eventDate.withZoneSameInstant(cetZone);
        System.out.println("CET Zoned = " + cetZoned);

        LocalDateTime toLocalDateTime = cetZoned.toLocalDateTime();
        System.out.println("CET to local = " + toLocalDateTime);

    }
}
