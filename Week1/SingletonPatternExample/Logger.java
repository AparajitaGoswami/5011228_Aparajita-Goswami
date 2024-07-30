// Logger.java
public class Logger {
    // Private static instance of the class
    private static Logger instance;

    // Private constructor to prevent instantiation from outside
    private Logger() {
        // Initialize any resources needed for logging
    }

    // Public static method to provide access to the instance
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Example logging method
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}
