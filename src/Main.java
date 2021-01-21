import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", 8080)) {
            Message message = new Message("Este mensaje es autogenerado");
            ObjectOutputStream ous = new ObjectOutputStream(client.getOutputStream());
            ous.writeObject(message);
            ous.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
