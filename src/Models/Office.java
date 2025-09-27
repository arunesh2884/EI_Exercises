package Models;

import Exceptions.BookingException;
import Services.RoomManager;

public class Office {
    Boolean isConfigured = false;
    int roomCount;
    RoomManager roomManager;

    public Office() {
        roomManager = new RoomManager();
    }

    public void configureOffice(int roomCount) {
        this.roomCount = roomCount;
        for (int i = 1; i <= roomCount; i++) {
            roomManager.addRoom(i);
        }
        isConfigured = true;
    }

    public void configureRoom(int roomId,int roomCapacity) throws BookingException{
        roomManager.configureRoom(roomId, roomCapacity);
    }


}
