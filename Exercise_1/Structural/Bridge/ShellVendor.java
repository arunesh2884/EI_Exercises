package Exercise_1.Structural.Bridge;

public class ShellVendor implements FuelVendor {
    @Override
    public void startFueling(String vehicleId) {
        System.out.println("[ShellVendor] Starting fueling for vehicle " + vehicleId + " with high-octane fuel.");
    }

    @Override
    public void stopFueling(String vehicleId) {
        System.out.println("[ShellVendor] Stopping fueling for vehicle " + vehicleId);
    }
}