package Models;

public class AirConditioner implements Device {
    private boolean isOn;

    public AirConditioner() {
        this.isOn = false;
    }

    @Override
    public void update(boolean isOn) {
        this.isOn = isOn;
        if (isOn) {
            System.out.println("Air Conditioner is turned ON");
        } else {
            System.out.println("Air Conditioner is turned OFF");
        }
    }

    @Override
    public String getDeviceName() {
        return "Air Conditioner";
    }
}
