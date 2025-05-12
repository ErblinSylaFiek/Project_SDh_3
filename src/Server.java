import java.net.ServerSocket;
import java.io.IOException;

public class Server {
    public static ServerSocket createServer()throws IOException{
        String serverIp = "127.0.0.1";
        int serverPort = 12345;
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("Serveri po pret lidhje...");
        return serverSocket;
    }
    public static void main(String [] args){

    }
}
