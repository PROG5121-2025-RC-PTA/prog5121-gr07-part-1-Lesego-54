public class Message {
    private String content;
    private boolean isSent;
    private boolean isReceived;
    private boolean isRead;

    public Message(String content) {
        this.content = content;
        this.isSent = false;
        this.isReceived = false;
        this.isRead = false;
    }

    public void markAsSent() { this.isSent = true; }
    public void markAsReceived() { this.isReceived = true; }
    public void markAsRead() { this.isRead = true; }

    public boolean isSent() { return isSent; }
    public boolean isReceived() { return isReceived; }
    public boolean isRead() { return isRead; }
}
