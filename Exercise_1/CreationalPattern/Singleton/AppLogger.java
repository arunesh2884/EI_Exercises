package Exercise_1.CreationalPattern.Singleton;
// Singleton Logger class
public class AppLogger {
    private static AppLogger instance;   // the single instance
    private static final Object lock = new Object();

    // private constructor prevents external instantiation
    private AppLogger() {
        System.out.println("[Logger Initialized]");
    }

    // global access point with lazy initialization
    public static AppLogger getInstance() {
        if (instance == null) {
            synchronized (lock) {  // thread-safe
                if (instance == null) {
                    instance = new AppLogger();
                }
            }
        }
        return instance;
    }

    // logging method
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
}
