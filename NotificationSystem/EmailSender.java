package NotificationSystem;

public class EmailSender implements NotificationSender {
    @Override
    public void sendNotification(Notification notification) {
        // Logic to send email notification
        System.out.println("Sending email notification: " + notification.getMessage());
    }
}