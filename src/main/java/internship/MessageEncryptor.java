package internship;

public class MessageEncryptor {
    public static String encryptMessage(String message) {
        // Преобразуем входное сообщение в последовательность битов ASCII
        StringBuilder binaryMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            String binaryChar = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
            binaryMessage.append(binaryChar);
        }

        // Запуск рекурсивной функции для шифрования
        return encryptMessageRecursive(binaryMessage.toString(), 0, new StringBuilder());
    }

    private static String encryptMessageRecursive(String binaryMessage, int index,
                                                  StringBuilder encryptedMessage) {
        // Базовый случай: если мы достигли конца последовательности битов
        if (index == binaryMessage.length()) {
            return encryptedMessage.toString();
        }

        // Начальная обработка
        char currentBit = binaryMessage.charAt(index);
        int count = 0;

        // Подсчитываем количество последовательных одинаковых битов
        while (index < binaryMessage.length() && binaryMessage.charAt(index) == currentBit) {
            count++;
            index++;
        }

        // Добавляем блок в зашифрованное сообщение
        encryptedMessage.append(encodeBlock(currentBit, count));

        // Продолжаем рекурсию
        return encryptMessageRecursive(binaryMessage, index, encryptedMessage);
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
