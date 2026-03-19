package NotificationSystem;

public class PushSender implements NotificationSender {
    @Override
    public void sendNotification(Notification notification) {
        // Logic to send push notification
        System.out.println("Sending push notification: " + notification.getMessage());
    }
}