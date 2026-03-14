package FileLoggingSystem;

public class ConsoleLogger extends Logger {
    public ConsoleLogger() {
        super(LogLevel.INFO);
    }

    @Override
    void write(String message) {
        System.out.println("Console Logger " + message);
    }
}