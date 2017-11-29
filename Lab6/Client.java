import java.io.*;
import java.net.Socket;
import java.util.Scanner;
public class Client {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost", 1234);
            System.out.println("Just connected to " + client.getRemoteSocketAddress());
            Scanner scanner = new Scanner(System.in);
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            DataInputStream in = new DataInputStream(client.getInputStream());
            System.out.println("Write a word[-1 to exit]:");
            String read = scanner.nextLine();
            out.writeUTF(read);
            while (!read.contains("-1")) {
                System.out.println(in.readUTF());
                System.out.println("Write a word[-1 to exit]:");
                read = scanner.nextLine();
                out.writeUTF(read);}
            client.close();
            System.out.println("Disconnected");
        } catch (Exception e) {
            e.printStackTrace();}}}
