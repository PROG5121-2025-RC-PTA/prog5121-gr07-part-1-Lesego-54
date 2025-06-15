import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testMessageStatusFlags() {
        Message msg = new Message("Hello");
        assertFalse(msg.isSent());
        assertFalse(msg.isReceived());
        assertFalse(msg.isRead());

        msg.markAsSent();
        assertTrue(msg.isSent());

        msg.markAsReceived();
        assertTrue(msg.isReceived());

        msg.markAsRead();
        assertTrue(msg.isRead());
    }
}

