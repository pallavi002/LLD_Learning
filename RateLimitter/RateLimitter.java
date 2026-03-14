package RateLimitter;

public interface RateLimitter {
    boolean allowRequest(String clientId);
}
