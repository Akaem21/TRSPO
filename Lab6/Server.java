import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
public class Server extends Thread {
    Socket cSocket;
    static int counter;
    Server(Socket cSocket) {
        this.cSocket = cSocket;}
    public static void main(String args[]) throws Exception {
        ServerSocket sSock = new ServerSocket(1234);
        System.out.println("Listening");
        while (true) {
            Socket sock = sSock.accept();
            new Thread(new Server(sock)).start();}}
    public void run() {
        try {
            System.out.println("Connected " + cSocket.getRemoteSocketAddress() + ", Counter: " + ++counter);
            DataInputStream in = new DataInputStream(cSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(cSocket.getOutputStream());
            String read = in.readUTF();
            while (!read.contains("-1")) {
                out.writeUTF(Oxford.getInstance().dictionary(read));
                read = in.readUTF();}
            System.out.println("Disconnected " + cSocket.getRemoteSocketAddress() + ", Counter: " + --counter);
            cSocket.close();
        } catch (Exception e) {
            e.printStackTrace();}}}
