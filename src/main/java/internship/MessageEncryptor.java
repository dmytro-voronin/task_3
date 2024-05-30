package internship;

public class MessageEncryptor {
    public static String encryptMessage(String message) {
        StringBuilder encryptedMessage = new StringBuilder();
        
        // Преобразуем входное сообщение в последовательность битов ASCII
        StringBuilder binaryMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            String binaryChar = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
            binaryMessage.append(binaryChar);
        }
        
        // Проходим по последовательности битов, формируя зашифрованное сообщение
        char prevBit = binaryMessage.charAt(0);
        int count = 1;
        for (int i = 1; i < binaryMessage.length(); i++) {
            char currentBit = binaryMessage.charAt(i);
            if (currentBit == prevBit) {
                count++;
            } else {
                // Добавляем блоки в зашифрованное сообщение
                encryptedMessage.append(encodeBlock(prevBit, count));
                prevBit = currentBit;
                count = 1;
            }
        }
        
        // Добавляем последний блок
        encryptedMessage.append(encodeBlock(prevBit, count));
        
        return encryptedMessage.toString();
    }
    
    private static String encodeBlock(char bit, int count) {
        StringBuilder block = new StringBuilder();
        if (bit == '0') {
            block.append("00");
        } else {
            block.append("0");
        }
        block.append(" ");
        for (int i = 0; i < count; i++) {
            block.append("0");
        }
        block.append(" ");
        return block.toString();
    }
}
