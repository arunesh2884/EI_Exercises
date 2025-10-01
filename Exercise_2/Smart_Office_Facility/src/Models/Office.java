package Models;

import Exceptions.BookingException;
import Exceptions.ConfigException;
import Services.RoomManager;

public class Office {

    private static Office instance;
    private int roomCount;
    private boolean isConfigured = false;
    private RoomManager roomManager;

    private Office() {
        // private constructor to enforce singleton pattern
        // only one instance of Office can exist
    }


    public static Office getInstance() {
        if (instance == null) {
            instance = new Office();
        }
        return instance;
    }



    public void configureOffice(int roomCount) {
        try {
            if (isConfigured) {
                throw new ConfigException("Office is already configured.");
            }
            
            if(roomCount <= 0){
                throw new ConfigException("Room count must be a positive integer.");
            }
            roomManager = new RoomManager();
            this.roomCount = roomCount;
            System.out.println("Office configured with " + roomCount + " rooms:");
            for (int i = 1; i <= roomCount; i++) {
                roomManager.addRoom(i);
            }
            isConfigured=true;
        } catch (ConfigException e) {
            System.out.println("Configuration error: " + e.getMessage());
        } 
    }




    public void configureRoom(int roomId,int roomCapacity) throws BookingException{
        roomManager.configureRoom(roomId, roomCapacity);
    }



    public RoomManager getRoomManager() {
        try {
            if (!isConfigured) {
            throw new BookingException("Office not configured. Please configure the office first.");
        }
        return roomManager;
        } catch (BookingException e) {
            System.out.println("Booking error: " + e.getMessage());
        }
        return null;
    }

    public void blockRoom(int roomId, String startTime, int duration) throws BookingException {
        roomManager.blockRoom(roomId, startTime, duration);
    }

}
