import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Locale;

public class Encryptor {

    private String algorithmType;

    private int bitSize;

    private int cipherTextSize;

    public Encryptor() {
    }

    public String encryptString(String message, String hashFunction) throws NoSuchAlgorithmException {
        String algorithm = hashFunction.toUpperCase(Locale.ROOT);
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

        String provider = String.valueOf(messageDigest.getProvider());
        algorithmType = messageDigest.getAlgorithm();
        bitSize = messageDigest.getDigestLength();


        byte[] digest = messageDigest.digest(message.getBytes());

        String cipherText = HexFormat.of().formatHex(digest);
        cipherTextSize = cipherText.length();
        return cipherText;
    }

    public String showMessageWithHash(String message,String algorithm) throws NoSuchAlgorithmException {
        String hash = encryptString(message,algorithm);

        return "Message: " + message +
                "\nHash: " + hash +
                "\nAlgorithm: " + algorithmType +
                "\ncipher text length: "+ cipherTextSize+
                "\nbit size of : " + bitSize;
    }
}
