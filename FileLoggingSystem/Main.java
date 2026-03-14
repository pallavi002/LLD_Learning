package FileLoggingSystem;

public class Main {
    public static void main(String[] args) {
        Logger logger = LoggerChain.buildChain();

        logger.log(LogLevel.INFO, "Application Started.");
        logger.log(LogLevel.DEBUG, "Debugging mode..");
        logger.log(LogLevel.ERROR, "Error Logging !!");

    }
}
