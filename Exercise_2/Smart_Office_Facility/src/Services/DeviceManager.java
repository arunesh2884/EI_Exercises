package Services;

import java.util.ArrayList;
import java.util.List;

import Models.Device;

public class DeviceManager {

    private List<Device> devices = new ArrayList<>();
    public void addDevice(Device device) { devices.add(device); }

    public void notifyDevices(boolean turnOn) {
        for (Device device : devices) {
            device.update(turnOn);
        }
    }

    public void updateDevices(int occupancy) {
        if (occupancy > 2) {
            notifyDevices(true);
        } else {
            notifyDevices(false);
        }
    }


    public List<Device> getDevices() { return devices; }

}