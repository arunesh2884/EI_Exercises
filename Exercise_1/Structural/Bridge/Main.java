package Exercise_1.Structural.Bridge;

public class Main {
    public static void main(String[] args) {
        simulateFueling(new HPVendor(), "CAR-101");
        simulateFueling(new ShellVendor(), "CAR-202");
        System.out.println("\nAll fueling sessions completed successfully.");
    }

    private static void simulateFueling(FuelVendor vendor, String vehicleId) {
        FuelStation station = new FuelStation(vendor);
        station.begin(vehicleId);
        System.out.println("   fueling...   ");
        station.end(vehicleId);
        System.out.println();
    }
}