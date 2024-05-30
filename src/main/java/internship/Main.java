package internship;

public class Main {
    public static void main(String[] args) {
        // Пример использования
        String message = "GO";
        String encryptedMessage = MessageEncryptor.encryptMessage(message);
        System.out.println("Encrypted message: " + encryptedMessage);
    }
}
