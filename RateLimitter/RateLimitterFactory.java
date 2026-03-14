package RateLimitter;


public class RateLimitterFactory {

    enum Type {
    FIXED_WINDOW,
    SLIDING_WINDOW,
    TOKEN_BUCKET
}


    public static RateLimitter createRateLimitter(Type type, int capacity, long refillRate) {
        switch (type) {
            case FIXED_WINDOW:
                return new FixedWindowRateLimitter(capacity, refillRate);
            case SLIDING_WINDOW:
                return new SlidingWindowRateLimitter(capacity, refillRate);
            case TOKEN_BUCKET:
                return new TokenBucketRateLimitter(capacity, refillRate);
            default:
                throw new IllegalArgumentException("Invalid rate limiter type");
        }   
    }
}
