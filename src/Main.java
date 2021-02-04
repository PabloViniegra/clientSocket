import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost",8080);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            String texto;
            String received;
            do {
                System.out.print("Escribe:");
                texto = sc.nextLine();
                out.println(texto);
                received = in.readLine();
                System.out.println("Texto recibido: " + received);
            } while (!texto.equals("#"));
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
