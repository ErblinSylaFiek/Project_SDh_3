import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.net.Socket;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.X509EncodedKeySpec;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 12345);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecretKey desKey = keyGen.generateKey();

        String message = "Pershendetje nga klienti";
        Cipher desCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[8];
        random.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        desCipher.init(Cipher.ENCRYPT_MODE, desKey, ivSpec);
        byte[] encryptedMessage = desCipher.doFinal(message.getBytes());

        byte[] publicKeyBytes = new FileInputStream("server_public.key").readAllBytes();
        X509EncodedKeySpec pubSpec = new X509EncodedKeySpec(publicKeyBytes);
        PublicKey publicKey = KeyFactory.getInstance("RSA").generatePublic(pubSpec);

        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] encryptedDesKey = rsaCipher.doFinal(desKey.getEncoded());
    }
}
