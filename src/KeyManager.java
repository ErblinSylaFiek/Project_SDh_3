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

    // Ekspozimi i çelësave
    PrivateKey privateKey = keyPair.getPrivate();
    PublicKey publicKey = keyPair.getPublic();

    // Ruajtja e çelësave në skedarë
        try(
    FileOutputStream privateKeyFile = new FileOutputStream("server_private.pem");
    FileOutputStream publicKeyFile = new FileOutputStream("server_public.pem"))

    {
        privateKeyFile.write(privateKey.getEncoded());
        publicKeyFile.write(publicKey.getEncoded());
    }

        System.out.println("Çelësat RSA janë krijuar dhe ruajtur.");

    // Krijimi i një çelësi sekret për DES-CBC
    public static SecretKey generateSecretKey() throws Exception {
        // Krijimi i çelësit sekret 8-byte për DES
        byte[] keyBytes = new byte[8]; // DES kërkon një çelës 8-byte
        SecureRandom random = new SecureRandom();
        random.nextBytes(keyBytes);
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "DES");
        return secretKey;
    }
}