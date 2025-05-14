import java.io.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.util.Base64;

public class KeyManager {

    // Krijimi i çelësave RSA
    public static void generateRsaKeys() throws Exception {
        // Krijimi i çelësave RSA 2048-bit
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
    }
}