package RateLimitter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimitter implements RateLimitter {
    private static class Bucket {
        double tokens;
        long lastRefillTime;

        Bucket(double tokens, long lastRefillTime) {
            this.tokens = tokens;
            this.lastRefillTime = lastRefillTime;
        }
    }

    private int capacity;
    private long timeWindowMillis;
    private Map<String, Bucket> buckets;

    public TokenBucketRateLimitter(int capacity, long timeWindowMillis) {
        this.capacity = capacity;
        this.timeWindowMillis = timeWindowMillis;
        this.buckets = new ConcurrentHashMap<>();
    }

    @Override
    public boolean allowRequest(String clientId) {
        long now = System.currentTimeMillis();
        
        buckets.putIfAbsent(clientId, new Bucket(capacity, now));
        Bucket bucket = buckets.get(clientId);

        synchronized (bucket) {
            double tokensToAdd = (double) (now - bucket.lastRefillTime) / timeWindowMillis * capacity;
            bucket.tokens = Math.min(capacity, bucket.tokens + tokensToAdd);
            bucket.lastRefillTime = now;

            if (bucket.tokens >= 1.0) {
                bucket.tokens -= 1.0;
                return true;
            }
            return false;
        }
    }
}
