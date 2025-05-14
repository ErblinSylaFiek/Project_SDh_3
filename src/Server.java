import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class Server{
    public static void main(String []args)throws IOException {
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

            clientSocket.close();
            serverSocket.close();
    }
    private static PrivateKey loadPrivateKey(String filePath) throws Exception {
        FileInputStream keyFile = new FileInputStream(filePath);
        byte[] keyBytes = keyFile.readAllBytes();
        keyFile.close();

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        return keyFactory.generatePrivate(keySpec);
    }
}