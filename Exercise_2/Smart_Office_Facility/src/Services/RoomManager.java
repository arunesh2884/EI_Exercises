package Services;

import Models.Booking;
import Models.Room;
import Utils.TimeUtils;
// import Models.Booking;
import Exceptions.BookingException;
import Exceptions.ConfigException;
import Exceptions.OccupyingException;

import java.sql.Time;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RoomManager {
    private Map<Integer, Room> rooms = new HashMap<>();
    private  ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public RoomManager() {
        System.out.println("Room Manager started.");
        scheduler.scheduleAtFixedRate(this::tick, 0, 1, TimeUnit.MINUTES);
    }

    // Called every minute
    public void tick() {
        String now = TimeUtils.getCurrentTimeHHMM();
        System.out.println("Tick: " + now);
        for (Room room : rooms.values()) {
            for (Booking booking : room.getBookings()) {

                // Activate booking at start time
                if (now.equals(booking.getStartTime())) {

                    room.setBooked(true);
                    System.out.println("\nRoom " + room.getRoomNumber() + " booking started at " + now );
                    System.out.println("will be released in 5 minutes if no occupancy detected.\n");
                    // Schedule 2-min post start occupancy check
                    scheduler.schedule(() -> checkAndRelease(room, booking), 2, TimeUnit.MINUTES);
                }

                // After booking end time, remove booking
                if (TimeUtils.compareTimes(now, booking.getEndTime()) >= 0 && room.isBooked()) {
                    room.releaseBooking(booking);
                }
            }
        }
    }

     private void checkAndRelease(Room room, Booking booking) {
        if (!room.isOccupied() && room.isBooked()) {
            room.releaseBooking(booking);
            room.setBooked(false);
            // send notification if needed
            System.out.println("Room " + room.getRoomNumber() + " has been released due to no occupancy.");
        }
    }

    // Add a room (only creates it, not configured yet)
    public void addRoom(int roomId) {
        if (rooms.containsKey(roomId)) {
            System.out.println("Room " + roomId + " already exists.");
            return;
        }
        rooms.put(roomId, new Room(roomId));
        System.out.println("Room " + roomId + " added.");
    }



    // Configure a room with capacity
    public void configureRoom(int roomId, int capacity)  {
        try {
                Room room = rooms.get(roomId);
            if (room == null) {
                throw new ConfigException("Room " + roomId + " does not exist!");
            }
            room.configure(capacity);
            System.out.println("Room " + roomId + " configured with capacity " + capacity);

        } catch (ConfigException e) {
            System.out.println("Configuration error: " + e.getMessage());
        }
       
    }

    // Book a room
    public void blockRoom(int roomId, String startTime, int durationMinutes)  {
        
        try {
            Room room = rooms.get(roomId);
            if (room == null) {
                throw new BookingException("Room " + roomId + " does not exist!");
            }
            room.blockRoom( startTime, durationMinutes);
        } catch (BookingException e) {
            System.out.println("Booking error: " + e.getMessage());
        }
    }

    // Get room info
    public Room getRoom(int roomId) throws BookingException {
        Room room = rooms.get(roomId);
        if (room == null) {
            throw new BookingException("Room " + roomId + " does not exist!");
        }
        return room;
    }

    public void addOccupant(int roomId, int numberOfOccupants) {
        try {
            Room room = rooms.get(roomId);
            if (room == null) {
                throw new OccupyingException("Room " + roomId + " does not exist!");
            }
            if(room.isConfigured() == false){
                throw new OccupyingException("Room " + roomId + " is not configured yet!");
            }
            if (!room.isBooked()) {
                throw new OccupyingException("Room " + roomId + " is currently not booked!");
            }
            if(0 > numberOfOccupants){
                throw new OccupyingException("Number of occupants must be positive.");
            }  
        
                room.addOccupants(numberOfOccupants);
        } catch (OccupyingException e) {
            System.out.println("Error adding occupants to room " + roomId + ": " + e.getMessage());
        }
    }


    // Display all rooms
    public void listRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
            return;
        }
        for (Room room : rooms.values()) {
            System.out.println(room);
        }
    }

   
}
