import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String []args){
        try{
            ServerSocket serverSocket=new ServerSocket(12345);
            System.out.println("Serveri eshte duke pritur lidhje...");

            Socket clientSocket=serverSocket.accept();
            System.out.println("Klienti u lidh nga: "+clientSocket.getInetAddress());

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());

            int keyLength = in.readInt();
            byte[] encryptedDesKey = new byte[keyLength];
            in.readFully(encryptedDesKey);

            int msgLength = in.readInt();
            byte[] encryptedMessage = new byte[msgLength];
            in.readFully(encryptedMessage);

            byte[] iv = new byte[8];
            in.readFully(iv);

            //...

            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}