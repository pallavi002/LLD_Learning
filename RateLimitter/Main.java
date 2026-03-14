package RateLimitter;

public class Main {
    public static void main(String[] args) {
        RateLimitter fixedWindowRateLimitter = RateLimitterFactory.createRateLimitter(RateLimitterFactory.Type.FIXED_WINDOW, 5, 1000);
        RateLimitter SlidingWindowRateLimitter = RateLimitterFactory.createRateLimitter(RateLimitterFactory.Type.SLIDING_WINDOW, 5, 1000);
        RateLimitter TokenBucketRateLimiter = RateLimitterFactory.createRateLimitter(RateLimitterFactory.Type.TOKEN_BUCKET, 5, 1000);

        for(int i=0; i<10; i++) {
            System.out.println("Fixed Window- Request " + i + "allowed? "  + fixedWindowRateLimitter.allowRequest("1"));
        }

        for(int i=0; i<10; i++) {
            System.out.println("Sliding Window- Request " + i + "allowed? "  + SlidingWindowRateLimitter.allowRequest("1"));
        }

        for(int i=0; i<10; i++) {
            System.out.println("Token Bucket Window- Request " + i + "allowed? "  + TokenBucketRateLimiter.allowRequest("1"));
        }

    }
}
