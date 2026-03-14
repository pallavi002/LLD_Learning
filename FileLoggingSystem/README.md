Logger Chain Example (Chain of Responsibility Pattern)
Overview

This program demonstrates the Chain of Responsibility design pattern using a simple logging system.

Instead of using a large if-else structure to handle log levels, the program creates a chain of logger objects.
Each logger decides whether it should handle the message and then forwards it to the next logger in the chain.

Log levels supported:

INFO
DEBUG
ERROR

Each level is handled by a different logger.

Program Flow (Step-by-Step)
1. Program Starts

Execution begins in the main() method.

Logger logger = LoggerChain.buildChain();

This builds a chain of loggers and returns the first logger in the chain.

2. Building the Logger Chain

Inside LoggerChain.buildChain() the following objects are created:

ConsoleLogger
FileLogger
ErrorLogger

These loggers are then connected in sequence.

ConsoleLogger → FileLogger → ErrorLogger

Code:

console.setNext(file);
file.setNext(error);

The method returns the first logger in the chain:

return console;

So logger in main() points to:

ConsoleLogger
3. First Log Request
logger.log(INFO, "Application started")
Step 1

The request starts at ConsoleLogger.

ConsoleLogger level = INFO
Requested level = INFO

Condition matches.

ConsoleLogger prints:

Console Logger: Application started
Step 2

The request moves to the next logger.

FileLogger
DEBUG == INFO → false

Nothing happens.

Step 3

Next logger:

ErrorLogger
ERROR == INFO → false

Nothing happens.

Final result:

Console Logger: Application started
4. Second Log Request
logger.log(DEBUG, "Debugging application")
ConsoleLogger
INFO == DEBUG → false

Pass to next.

FileLogger
DEBUG == DEBUG → true

Output:

File Logger: Debugging application
ErrorLogger
ERROR == DEBUG → false

Final output:

File Logger: Debugging application
5. Third Log Request
logger.log(ERROR, "Something went wrong")
ConsoleLogger
INFO == ERROR → false

Pass forward.

FileLogger
DEBUG == ERROR → false

Pass forward.

ErrorLogger
ERROR == ERROR → true

Output:

Error Logger: Something went wrong
Final Program Output
Console Logger: Application started
File Logger: Debugging application
Error Logger: Something went wrong
Design Pattern Used

Chain of Responsibility

This pattern allows a request to pass through a chain of handlers.

Each handler:

Decides whether to process the request

Passes the request to the next handler

Structure:

Client
   ↓
Logger1 → Logger2 → Logger3 → null
Why Use This Pattern

Advantages:

Avoids large if-else chains

Easy to extend

Each logger has a single responsibility

New loggers can be added without modifying existing code

Example extension:

ConsoleLogger
     ↓
FileLogger
     ↓
ErrorLogger
     ↓
DatabaseLogger
     ↓
SlackLogger
Key Classes
Class	Responsibility
Logger	Abstract base class for all loggers
ConsoleLogger	Handles INFO logs
FileLogger	Handles DEBUG logs
ErrorLogger	Handles ERROR logs
LoggerChain	Builds the logger chain
Main	Runs the program