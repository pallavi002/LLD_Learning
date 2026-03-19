package NotificationSystem;

public class SmsSender implements NotificationSender {
    @Override
    public void sendNotification(Notification notification) {
        // Logic to send SMS notification
        System.out.println("Sending SMS notification: " + notification.getMessage());
    }
}