package RateLimitter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Deque;

public class SlidingWindowRateLimitter implements RateLimitter {
    int capacity;
    long windowTime;
    HashMap<String, Deque<Long>> windowStartTimes;

    public SlidingWindowRateLimitter(int capacity, long windowTime) {
        this.capacity = capacity;
        this.windowTime = windowTime;
        this.windowStartTimes = new HashMap<>();
    }

    @Override
    public boolean allowRequest(String clientId) {
        long now = System.currentTimeMillis();
        windowStartTimes.putIfAbsent(clientId, new LinkedList<>());

        Deque<Long> requestCount = windowStartTimes.get(clientId);

        if(!requestCount.isEmpty() && now - requestCount.peek() >= windowTime) {
            requestCount.poll();
        }

        if(requestCount.size() < capacity) {
            requestCount.add(now);
            return true;
        }

        return false;
    }
}