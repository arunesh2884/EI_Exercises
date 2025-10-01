package Models;

public class Light implements Device {
    private boolean isOn;
    public Light() {
        this.isOn = false;
    }

    @Override
    public void update(boolean isOn) {
        this.isOn = isOn;
        if (isOn) {
            System.out.println("Light is turned ON");
        } else {
            System.out.println("Light is turned OFF");
        }
    }


    @Override
    public String getDeviceName() {
        return "Light";
    }
}

