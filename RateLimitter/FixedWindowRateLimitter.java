package RateLimitter;
import java.util.HashMap;

public class FixedWindowRateLimitter implements RateLimitter {
    int capacity;
    long windowTime;
    HashMap<String, Integer> requestCounts;
    HashMap<String, Long> windowStartTimes;

    public FixedWindowRateLimitter(int capacity, long windowTime) {
        this.capacity = capacity;
        this.windowTime = windowTime;
        this.requestCounts = new HashMap<>();
        this.windowStartTimes = new HashMap<>();

    }

    @Override
    public boolean allowRequest(String clientId) {
        long now = System.currentTimeMillis();
        windowStartTimes.putIfAbsent(clientId, now);
        requestCounts.putIfAbsent(clientId, 0);

        long lastTime = windowStartTimes.get(clientId);
        if(now - lastTime >= windowTime) {
            windowStartTimes.put(clientId, now);
            requestCounts.put(clientId, 0);
        }

        int reqs = requestCounts.get(clientId);
        if(reqs < capacity) {
            requestCounts.put(clientId, reqs + 1);
            return true;
        }

        return false;
    }
}
