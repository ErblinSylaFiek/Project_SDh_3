import java.net.ServerSocket;
import java.net.Socket;

public class Server{
    public static void main(String []args){
        try{
            ServerSocket serverSocket=new ServerSocket(12345);
            System.out.println("Serveri eshte duke pritur lidhje...");

            Socket clientSocket=serverSocket.accept();
            System.out.println("Klienti u lidh nga: "+clientSocket.getInetAddress());

            //....

            clientSocket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}