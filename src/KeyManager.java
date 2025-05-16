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

        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Ruajtja e çelësave në skedarë
        try (
                FileOutputStream privateKeyFile = new FileOutputStream("server_private.pem");
                FileOutputStream publicKeyFile = new FileOutputStream("server_public.pem")
        ) {
            privateKeyFile.write(privateKey.getEncoded());
            publicKeyFile.write(publicKey.getEncoded());
        }

        System.out.println("Çelësat RSA janë krijuar dhe ruajtur.");
    }

    // Krijimi i një çelësi sekret për DES-CBC
    public static SecretKey generateSecretKey() throws Exception {
        byte[] keyBytes = new byte[8]; // DES kërkon një çelës 8-byte
        SecureRandom random = new SecureRandom();
        random.nextBytes(keyBytes);
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, "DES");
        return secretKey;
    }

    // Dërgo çelësin publik te klienti (në këtë rast vetëm leximi i çelësit)
    public static byte[] sendPublicKey() throws IOException {
        try (FileInputStream publicKeyFile = new FileInputStream("server_public.pem")) {
            return publicKeyFile.readAllBytes(); // Java 9+ ose përdor .available() me Java 8
        }
    }

    // Testimi i krijimit të çelësave
    public static void testKeyCreation() throws Exception {
        generateRsaKeys();
        SecretKey secretKey = generateSecretKey();
        System.out.println("Çelësi sekret (hex): " + bytesToHex(secretKey.getEncoded()));
    }

    // Konvertimi i bytes në hex për shfaqje
    public static String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02X", b));
        }
        return hexString.toString();
    }

}
