package Exercise_1.Behavioural.Observer;

public class LEDDisplay implements WeatherObserver {
    @Override
    public void update(String weather) {
        System.out.println("[LEDDisplay] Weather updated: " + weather);
    }
}