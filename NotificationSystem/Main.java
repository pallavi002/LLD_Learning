package NotificationSystem;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Notification notification = new Notification("1", "Your order has been shipped!");
        UserPreference userPreference = new UserPreference("user123", Arrays.asList(Notification.Type.EMAIL, Notification.Type.SMS));

        NotificationService notificationService = new NotificationService();
        notificationService.sendNotification(notification, userPreference);
    }
}