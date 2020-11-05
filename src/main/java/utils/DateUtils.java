package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static String getAfterThreeDaysDate() {
        LocalDate date = LocalDate.now();
        date = date.plusDays(3);
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
