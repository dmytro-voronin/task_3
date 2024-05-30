package internship;

public class Main {
    public static void main(String[] args) {
        String message = "GO";
        String encryptedMessage = MessageEncryptor.encryptMessage(message);
        System.out.println("Encrypted message: " + encryptedMessage);
    }
}
