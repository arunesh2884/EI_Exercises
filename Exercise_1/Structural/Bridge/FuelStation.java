package Exercise_1.Structural.Bridge;

public class FuelStation extends FuelSession {

    public FuelStation(FuelVendor fuelVendor) {
        super(fuelVendor);
    }

    @Override
    public void begin(String vehicleId) {
        if (vehicleId == null || vehicleId.isEmpty()) {
            System.err.println("[ERROR] Invalid Vehicle ID.");
            return;
        }
        fuelVendor.startFueling(vehicleId);
    }

    @Override
    public void end(String vehicleId) {
        if (vehicleId == null || vehicleId.isEmpty()) {
            System.err.println("[ERROR] Invalid Vehicle ID.");
            return;
        }
        fuelVendor.stopFueling(vehicleId);
    }
}