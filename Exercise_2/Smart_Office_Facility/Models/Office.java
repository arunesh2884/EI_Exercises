package Models;

import Exceptions.BookingException;
import Services.RoomManager;

public class Office {
    private static Office instance;
    private int roomCount;
    private boolean isConfigured = false;
    private RoomManager roomManager;


    public static Office getInstance() {
        if (instance == null) {
            instance = new Office();
        }
        return instance;
    }


    public void configureOffice(int roomCount) {
        roomManager = new RoomManager();
        this.roomCount = roomCount;
        for (int i = 1; i <= roomCount; i++) {
            roomManager.addRoom(i);
        }   
        
        isConfigured=true;
    }

    public void configureRoom(int roomId,int roomCapacity) throws BookingException{
        roomManager.configureRoom(roomId, roomCapacity);
    }

    public RoomManager getRoomManager() throws BookingException {
        if (!isConfigured) {
            throw new BookingException("Office not configured. Please configure the office first.");
        }
        return roomManager;
    }

    public void blockRoom(int roomId, String startTime, int duration) throws BookingException {
        roomManager.blockRoom(roomId, startTime, duration);
    }

}
