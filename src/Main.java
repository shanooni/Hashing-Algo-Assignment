import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {

        Encryptor encryptor = new Encryptor();

        String message1 = "Hello Harry, can you transfer the money to my account 0123456789 on the whatsapp platform";

        String message2 = "Harry hello, can you transfer the money to my account #0123456789 on the whatsapp platform";

        System.out.println(encryptor.showMessageWithHash(message1,"md5"));
        System.out.println(encryptor.showMessageWithHash(message2,"md5"));
    }
}