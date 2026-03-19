package NotificationSystem;

import java.util.List;

class NotificationService {
    public NotificationSender sendNotification(Notification notification, UserPreference userPreference) {
        List<Notification.Type> enabledChannels = userPreference.getEnabledChannels();

        for(Notification.Type channel : enabledChannels) {
            switch(channel) {
                case Notification.Type.EMAIL:
                    return new EmailSender();
                case Notification.Type.SMS:
                    return new SmsSender();
                case Notification.Type.PUSH:
                    return new PushSender();
                default:
                    System.out.println("Unknown notification channel: " + channel);
            }
        }
        return null;
    }
}