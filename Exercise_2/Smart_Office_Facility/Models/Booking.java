package Models;
import java.time.*;
import java.time.format.DateTimeFormatter;
import Utils.TimeUtils;


public class Booking implements Comparable<Booking> {
    private String startTime; // Simplified as String (HH:MM), can use LocalTime
    private int duration;   // Duration in minutes

    public Booking(String startTime, int duration) {
        this.startTime = startTime;
        this.duration = duration;
    }


    public boolean overlaps(Booking other) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Parse times into LocalTime
        LocalTime thisStart = LocalTime.parse(this.startTime, formatter);
        LocalTime thisEnd = thisStart.plusMinutes(duration);

        LocalTime otherStart = LocalTime.parse(other.startTime, formatter);
        LocalTime otherEnd = otherStart.plusMinutes(other.duration);

        // Overlap check using TimeUtils.compareTimes
        boolean endsBefore = TimeUtils.compareTimes(thisEnd.format(formatter), otherStart.format(formatter)) <= 0;
        boolean startsAfter = TimeUtils.compareTimes(otherEnd.format(formatter), thisStart.format(formatter)) <= 0;

        return !(endsBefore || startsAfter); //If neither is true → they overlap.
    }

    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime thisStart = LocalTime.parse(this.startTime, formatter);
        LocalTime thisEnd = thisStart.plusMinutes(duration);
        return thisEnd.format(formatter);
    }

    @Override
    public int compareTo(Booking other) {
        return TimeUtils.compareTimes(this.startTime, other.startTime);
    }   

}
