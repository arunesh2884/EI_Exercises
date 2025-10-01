package Exercise_1.Behavioural.Observer;

public class Main {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        station.addObserver(new PhoneDisplay());
        station.addObserver(new LEDDisplay());

        station.setWeather("Sunny, 30°C");
        station.setWeather("Rainy, 22°C");
    }
}