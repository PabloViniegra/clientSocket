import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

public class Message implements Serializable, Runnable {
    private String uniqueID;
    private String message;
    private Socket socket;

    public Message( String message, Socket socket) {
        this.uniqueID = UUID.randomUUID().toString();
        this.message = message;
        this.socket = socket;
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

    @Override
    public void run() {
        PrintWriter printWriter;
        try {
            printWriter = new PrintWriter(this.socket.getOutputStream(), true);
            System.out.print("Escribe un mensaje: ");
            String response = new Scanner(System.in).nextLine();
            String[] tokens = response.split(" ");
            for (String token : tokens) {
                printWriter.println(token);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
