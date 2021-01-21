import java.io.Serializable;
import java.util.UUID;

public class Message implements Serializable {
    private String uniqueID;
    private String message;

    public Message( String message) {
        this.uniqueID = UUID.randomUUID().toString();;
        this.message = message;
    }

    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
