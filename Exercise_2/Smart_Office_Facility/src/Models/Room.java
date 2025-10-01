package Models;

import java.util.*;
import Exceptions.BookingException;
import Exceptions.ConfigException;
import Exceptions.OccupyingException;
import Services.DeviceManager;
import Utils.TimeUtils;

public class Room { 
    int roomId;
    int capacity;
    private final DeviceManager deviceManager;
    private int currentOccupancy = 0;
    private RoomState state = RoomState.UNCONFIGURED;
    private SortedSet<Booking> bookings = new TreeSet<>();


    public Room(int roomId) {
        this.roomId = roomId;
        this.deviceManager = new DeviceManager();
        this.state = RoomState.UNCONFIGURED; 
        this.deviceManager.addDevice(new Light());
        this.deviceManager.addDevice(new Fan());
        this.deviceManager.addDevice(new AirConditioner());
    }

    public void configure(int capacity) throws ConfigException {
        if (this.isConfigured()) {
            throw new ConfigException("Room " + roomId + " is already configured!");
        }   
        if (capacity <= 0) {
            throw new ConfigException("Capacity must be a positive integer.");
        }
        this.capacity = capacity;
        this.state = RoomState.CONFIGURED;
    }

  

    public void blockRoom( String startTime, int duration) throws BookingException {
        if (state == RoomState.UNCONFIGURED) {
            throw new BookingException("Room " + roomId + " is not configured yet!");
        }
        if (TimeUtils.compareTimes(startTime, TimeUtils.getCurrentTimeHHMM()) < 0) {
            throw new BookingException("Cannot book room " + roomId + " in the past!");
        }
        
        Booking newBooking = new Booking(startTime, duration);
        for (Booking b : bookings) {
            if (b.overlaps(newBooking)) {
                throw new BookingException("Room " + roomId + " is already booked during that time!");
            }
        }

        bookings.add(newBooking);
        //remains configured state till the booking's startTime and wants to start the 5min countdown at startTime - 5min

        System.out.println("Room " + roomId + " booked from " + startTime + " for " + duration + " minutes successfully.");
    }


    public void releaseBooking(Booking booking) {
        if (state == RoomState.BOOKED) {
            state = RoomState.CONFIGURED;
            if (currentOccupancy > 0) {
                currentOccupancy = 0;
                deviceManager.updateDevices(currentOccupancy);
            }
        }
        bookings.remove(bookings.remove(booking));
        System.out.println("Room " + roomId + " is now released."+" Current occupancy: " + currentOccupancy);
    }


    public void addOccupants(int numberOfOccupants) throws OccupyingException {
        if (this.isConfigured() == false) {
            throw new OccupyingException("Room " + roomId + " is not configured yet!");
        }

        if(numberOfOccupants <0){
            throw new OccupyingException("Number of occupants must be positive.");
        }

        if (numberOfOccupants == 0){
            currentOccupancy = 0;
            System.out.println("All occupants have left room " + roomId);
        }else if (numberOfOccupants + getCurrentOccupancy() > capacity){
            throw new OccupyingException("Adding " + numberOfOccupants + " exceeds room capacity of " + capacity);
        }
        currentOccupancy += numberOfOccupants;
        System.out.println(numberOfOccupants+" occupants added to room "+roomId+". Current occupancy:"+ currentOccupancy);
        deviceManager.updateDevices(currentOccupancy);
    }

    private int getCurrentOccupancy(){
        return currentOccupancy;
    }

    public void setBooked(boolean booked) {
        if (booked) {
            if (state == RoomState.CONFIGURED) {
                state = RoomState.BOOKED;
            }
        } else {
            if (state == RoomState.BOOKED) {
                state = RoomState.CONFIGURED;
            }
        }
    }






    // Getters and Setters
    public int getCapacity() {
        return capacity;
    }
    public SortedSet<Booking> getBookings() { return bookings; }

    public boolean isOccupied() {
        return currentOccupancy > 0;
    }

    public boolean isBooked() {
        return !(state != RoomState.BOOKED);
    }

    public int getRoomNumber() {
        return roomId;
    }

    public boolean isConfigured() {
        return state != RoomState.UNCONFIGURED;
    }



    @Override
    public String toString() {
        return "Room{" +
                "roomId=" + roomId +
                ", capacity=" + capacity +
                ", currentOccupancy=" + currentOccupancy +
                ", state=" + state +
                ", bookings=" + bookings +
                '}';
    }


    
}
