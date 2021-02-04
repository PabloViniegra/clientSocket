import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws IOException {
        String sentence;
        String modifiedSentence;
        Socket clientSocket;
        while(true){
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            clientSocket = new Socket("localhost", 2343);

            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("Ready");
            sentence = in.readLine();
            out.writeBytes(sentence + '\n');
            modifiedSentence = in.readLine();
            System.out.println(modifiedSentence);
        }

    }
}
