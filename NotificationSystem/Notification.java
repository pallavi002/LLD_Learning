package NotificationSystem;

public class Notification {
    String id;
    String message;

    public enum Type {
        EMAIL,
        SMS,
        PUSH
    }

    public Notification(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}