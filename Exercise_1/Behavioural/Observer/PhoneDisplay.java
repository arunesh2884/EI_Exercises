package Exercise_1.Behavioural.Observer;

public class PhoneDisplay implements WeatherObserver {
    @Override
    public void update(String weather) {
        System.out.println("[PhoneDisplay] Weather updated: " + weather);
    }
}