import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {
        try (Socket client = new Socket("localhost", 8080)) {
            PrintWriter out = new PrintWriter(client.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String cadena = "",eco = "";
            System.out.println("Introduzca un texto: ");
            do {
                cadena = reader.readLine();
                out.println(cadena);
                eco = in.readLine();
                System.out.println("ECO RECIBIDO DEL SERVIDOR "+ eco);
                System.out.println("Introduzca un texto");
                cadena = reader.readLine();
            } while (!cadena.equals("*"));
            out.close();
            in.close();
            System.out.println("FINALIZADA LA CONEXIÓN");
            reader.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
