package FileLoggingSystem;

public class LoggerChain {
    public static Logger buildChain() {
        Logger consoleLogger = new ConsoleLogger();
        Logger debugLogger = new DebugLogger();
        Logger errorLogger = new ErrorLogger();

        consoleLogger.setNext(debugLogger);
        debugLogger.setNext(errorLogger);

        return consoleLogger;
    }
}