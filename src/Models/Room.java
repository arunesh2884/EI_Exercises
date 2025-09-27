package Models;

import java.util.*;
import Exceptions.BookingException;

public class Room { 
    int roomId;
    int capacity;
    RoomState state;
    List<Booking> bookings = new ArrayList<>();


    public Room(int roomId) {
        this.roomId = roomId;
        this.state = RoomState.UNCONFIGURED; // default
    }

    public void configure(int capacity) {
        this.capacity = capacity;
        this.state = RoomState.CONFIGURED;
    }

    public void markMaintenance() {
        this.state = RoomState.MAINTENANCE;
    }

    // Booking logic
    public void bookRoom(int invitees, String startTime, int duration) throws BookingException {
        if (state == RoomState.UNCONFIGURED) {
            throw new BookingException("Room " + roomId + " is not configured yet!");
        }
        if (state == RoomState.MAINTENANCE) {
            throw new BookingException("Room " + roomId + " is under maintenance!");
        }
        if (invitees > capacity) {
            throw new BookingException("Room " + roomId + " capacity exceeded!");
        }

        Booking newBooking = new Booking(startTime, duration);
        for (Booking b : bookings) {
            if (b.overlaps(newBooking)) {
                throw new BookingException("Room " + roomId + " is already booked during that time!");
            }
        }

        bookings.add(newBooking);
        this.state = RoomState.CONFIGURED; // stays configured even after booking
        System.out.println("Room " + roomId + " booked successfully.");
    }


    
}
