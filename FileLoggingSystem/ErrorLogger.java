package FileLoggingSystem;

public class ErrorLogger extends Logger {
    public ErrorLogger() {
        super(LogLevel.ERROR);
    }

    @Override
    void write(String message) {
        System.out.println("Error Logger " + message);
    }
}