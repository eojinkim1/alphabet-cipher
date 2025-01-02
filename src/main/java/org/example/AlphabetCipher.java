package org.example;

public class AlphabetCipher {

    private static char[][] createCipherTable() {
        char[][] table = new char[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                table[i][j] = (char) ('a' + (i + j) % 26);
//                System.out.print(table[i][j] = (char) ('a' + (i + j) % 26));
            }
//            System.out.println();
        }
        return table;
    }

    private static String repeatKeyword(String keyword, int length) {
        StringBuilder repeated = new StringBuilder();
        while (repeated.length() < length) {
            repeated.append(keyword);
        }
        return repeated.substring(0, length);
    }

    public static String encrypt(String message, String keyword) {
        char[][] table = createCipherTable();
        String extendedKeyword = repeatKeyword(keyword, message.length());
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            int row = message.charAt(i) - 'a';
            int col = extendedKeyword.charAt(i) - 'a';
            encryptedMessage.append(table[row][col]);
        }

        return encryptedMessage.toString();
    }

    public static String decrypt(String encryptedMessage, String keyword) {
        char[][] table = createCipherTable();
        String extendedKeyword = repeatKeyword(keyword, encryptedMessage.length());
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            int col = extendedKeyword.charAt(i) - 'a';
            char encryptedChar = encryptedMessage.charAt(i);
            int row = 0;
            for (int j = 0; j < 26; j++) {
                if (table[j][col] == encryptedChar) {
                    row = j;
                    break;
                }
            }
            decryptedMessage.append((char) ('a' + row));
        }

        return decryptedMessage.toString();
    }

    public static void main(String[] args) {
        String message = "specialteachergun";
        String keyword = "goodteacher";

        String encrypted = encrypt(message, keyword);
        System.out.println("Encrypted Message: " + encrypted);

        String decrypted = decrypt(encrypted, keyword);
        System.out.println("Decrypted Message: " + decrypted);
    }
}
