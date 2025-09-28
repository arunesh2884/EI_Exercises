package Models;

import java.util.*;
import Exceptions.BookingException;
import Services.DeviceManager;

public class Room { 
    int roomId;
    int capacity;
    private final DeviceManager deviceManager;
    private int currentOccupancy = 0;
    enum RoomState { UNCONFIGURED, CONFIGURED }
    RoomState state;
    List<Booking> bookings = new ArrayList<>();


    public Room(int roomId) {
        this.roomId = roomId;
        this.deviceManager = new DeviceManager();
        this.state = RoomState.UNCONFIGURED; 
        this.deviceManager.addDevice(new Light());
        this.deviceManager.addDevice(new Fan());
        this.deviceManager.addDevice(new AirConditioner());
    }

    public void configure(int capacity) {
        this.capacity = capacity;
        this.state = RoomState.CONFIGURED;
    }

  

    public void blockRoom( String startTime, int duration) throws BookingException {
        if (state == RoomState.UNCONFIGURED) {
            throw new BookingException("Room " + roomId + " is not configured yet!");
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

    public void addOccupants(int numberOfOccupants) {
        if (state == RoomState.UNCONFIGURED) {
            throw new UnsupportedOperationException("Room " + roomId + " is not configured yet!");
        }

        if(numberOfOccupants <0){
            throw new UnsupportedOperationException("Number of occupants must be positive.");
        }

        if (numberOfOccupants == 0){
            currentOccupancy = 0;
            System.out.println("All occupants have left room " + roomId);
        }else if (numberOfOccupants + getCurrentOccupancy() > capacity){
            throw new UnsupportedOperationException("Adding " + numberOfOccupants + " exceeds room capacity of " + capacity);
        }
        currentOccupancy += numberOfOccupants;
        System.out.println(numberOfOccupants+" occupants added to room "+roomId+". Current occupancy:"+ currentOccupancy);
        deviceManager.updateDevices(currentOccupancy);
    }

    private int getCurrentOccupancy(){
        return currentOccupancy;
    }


    
}
