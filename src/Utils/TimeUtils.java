package Utils;
import java.time.LocalTime;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimeUtils {

    //function to return current time in format of HH:MM 
    public static String getCurrentTimeHHMM() {
        LocalTime now = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return now.format(formatter);
    }


    public static int compareTimes(String time1, String time2) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime t1 = LocalTime.parse(time1, formatter);
        LocalTime t2 = LocalTime.parse(time2, formatter);
        return t1.compareTo(t2);
        // returns <0 if t1 < t2, 0 if equal, >0 if t1 > t2
    }

    
    public static boolean isValidTimeFormat(String timeStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        try {
            LocalTime.parse(timeStr, formatter);
            return true; // valid format and valid time
        } catch (DateTimeParseException e) {
            return false; // invalid format or invalid time
        }
    }
}