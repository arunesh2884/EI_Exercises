package Exercise_1.Structural.Bridge;

public class HPVendor implements FuelVendor {
    @Override
    public void startFueling(String vehicleId) {
        System.out.println("[HPVendor] Starting fueling for vehicle " + vehicleId + " with premium petrol.");
    }

    @Override
    public void stopFueling(String vehicleId) {
        System.out.println("[HPVendor] Stopping fueling for vehicle " + vehicleId);
    }
}
