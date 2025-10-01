package Exercise_1.CreationalPattern.Singleton;

public class SingletonMain {
    public static void main(String[] args) {
        // Getting the same logger instance everywhere
        AppLogger logger1 = AppLogger.getInstance();
        AppLogger logger2 = AppLogger.getInstance();

        logger1.log("Application started.");
        logger2.log("User logged in.");
        logger1.log("Data processing completed.");

        // verifying both references point to the same object
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 are the SAME instance (Singleton).");
        }
    }
}
