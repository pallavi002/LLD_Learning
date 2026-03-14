# Rate Limiter

This project contains implementations of various Rate Limiting algorithms in Java.

## Implementations Included

1. **Fixed Window Rate Limiter**: Limits requests based on a fixed time window.
2. **Sliding Window Rate Limiter**: A more refined rate limiter that tracks request timestamps to prevent bursts at the boundary of time windows.
3. **Token Bucket Rate Limiter**: Uses a bucket of tokens where each request consumes a token, and tokens are refilled at a constant rate.

## Structure
- `RateLimitter.java`: An interface for the rate limiter.
- `RateLimitterFactory.java`: A factory class to create instances of different rate limiters.
- `FixedWindowRateLimitter.java`: Implementation of the Fixed Window algorithm.
- `SlidingWindowRateLimitter.java`: Implementation of the Sliding Window Log algorithm.
- `TokenBucketRateLimitter.java`: Implementation of the Token Bucket algorithm.
- `Main.java`: The main method showcasing the usage of all the implementations.

## How to Compile and Run

To compile and run the Java files, you should do so from the parent directory (`LLD_Learning`) because the classes are inside the `RateLimitter` package.

### Prerequisites
- Java Development Kit (JDK) installed on your system.

### Steps

1. Open your terminal.

2. Navigate to the parent directory (`LLD_Learning`):
   ```bash
   cd /Users/pallavilodhi/Codes/LLD_Learning
   ```

3. Compile all the Java files inside the `RateLimitter` directory:
   ```bash
   javac RateLimitter/*.java
   ```

4. Run the `Main` class using the package name:
   ```bash
   java RateLimitter.Main
   ```

### Expected Output
When you run the `Main` class, it simulates 10 consecutive requests for each rate limiting algorithm (configured to allow 5 requests per 1000 milliseconds). You will see output indicating whether each request is `true` (allowed) or `false` (blocked).
