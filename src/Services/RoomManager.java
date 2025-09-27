package Services;

import Models.Room;
// import Models.Booking;
import Exceptions.BookingException;

import java.util.HashMap;
import java.util.Map;

public class RoomManager {
    private Map<Integer, Room> rooms = new HashMap<>();

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
    public void configureRoom(int roomId, int capacity) throws BookingException {
        Room room = rooms.get(roomId);
        if (room == null) {
            throw new BookingException("Room " + roomId + " does not exist!");
        }
        room.configure(capacity);
        System.out.println("Room " + roomId + " configured with capacity " + capacity);
    }

    // Book a room
    public void bookRoom(int roomId, int invitees, String startTime, int durationMinutes) throws BookingException {
        Room room = rooms.get(roomId);
        if (room == null) {
            throw new BookingException("Room " + roomId + " does not exist!");
        }
        room.bookRoom(invitees, startTime, durationMinutes);
    }

    // Get room info
    public Room getRoom(int roomId) throws BookingException {
        Room room = rooms.get(roomId);
        if (room == null) {
            throw new BookingException("Room " + roomId + " does not exist!");
        }
        return room;
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
