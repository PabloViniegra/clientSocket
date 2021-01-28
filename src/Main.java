import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Thread thread = null;
        Socket client = null;
        BufferedReader bufferedReader = null;
        try {
            client = new Socket("localhost", 8080);
            bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            Message message = new Message("", client);
            thread = new Thread(message);
            thread.start();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
