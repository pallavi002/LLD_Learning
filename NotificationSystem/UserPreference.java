package NotificationSystem;

import java.util.List;

public class UserPreference {
    private String userId;
    private List<Notification.Type> enabledChannels;

    public UserPreference(String userId, List<Notification.Type> enabledChannels) {
        this.userId = userId;
        this.enabledChannels = enabledChannels;
    }

    public String getUserId() {
        return userId;
    }

    public List<Notification.Type> getEnabledChannels() {
        return enabledChannels;
    }
}
