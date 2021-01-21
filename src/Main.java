import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", 8080)) {
            byte[] buffer = new byte[4096];
            InputStream is = client.getInputStream();

            FileOutputStream fos = new FileOutputStream("aux_recibido.txt");
            int count;
            while ((count = is.read(buffer)) > 0) {
                System.out.println(count);
                fos.write(buffer, 0, count);
            }
            is.close();
            fos.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
