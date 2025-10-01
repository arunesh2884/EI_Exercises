package Exercise_1.Structural.Bridge;

public abstract class FuelSession {
    protected FuelVendor fuelVendor;

    public FuelSession(FuelVendor fuelVendor) {
        this.fuelVendor = fuelVendor;
    }

    public abstract void begin(String vehicleId);
    public abstract void end(String vehicleId);
}