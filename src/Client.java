import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 12345);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecretKey desKey = keyGen.generateKey();
    }
}
