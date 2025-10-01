package Models;

public class Fan implements Device {
    private boolean isOn;

    public Fan() {
        this.isOn = false;
    }

    @Override
    public void update(boolean isOn) {
        this.isOn = isOn;
        if (isOn) {
            System.out.println("Fan is turned ON");
        } else {
            System.out.println("Fan is turned OFF");
        }
    }

    @Override
    public String getDeviceName() {
        return "Fan";
    }
    
}
