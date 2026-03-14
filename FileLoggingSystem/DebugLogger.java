package FileLoggingSystem;

public class DebugLogger extends Logger {
    public DebugLogger() {
        super(LogLevel.DEBUG);
    }

    @Override
    void write(String message) {
        System.out.println("Debug Logger " + message);
    }
}