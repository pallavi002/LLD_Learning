package FileLoggingSystem;

public abstract class Logger {
    LogLevel logLevel;
    Logger nextLogger;

    public Logger(LogLevel logLevel) {
        this.logLevel = logLevel;
        this.nextLogger = null;
    }

    public void setNext(Logger logger) {
        this.nextLogger = logger;
    }

    public void log(LogLevel level, String message) {
        if(this.logLevel == level) {
            write(message);
        }

        if(this.nextLogger != null) {
            nextLogger.log(level, message);
        }
    }

    abstract void write(String message);
}