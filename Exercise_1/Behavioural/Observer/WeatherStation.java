package Exercise_1.Behavioural.Observer;
// Subject
import java.util.*;

public class WeatherStation {
    private List<WeatherObserver> observers = new ArrayList<>();
    private String weather;

    public void addObserver(WeatherObserver o) { observers.add(o); }
    public void removeObserver(WeatherObserver o) { observers.remove(o); }

    public void setWeather(String weather) {
        this.weather = weather;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (WeatherObserver o : observers) {
            o.update(weather);
        }
    }
}
