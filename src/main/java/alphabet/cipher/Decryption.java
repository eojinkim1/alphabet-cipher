package alphabet.cipher;

public class Decryption {

    private final CipherTable cipherTable;

    public Decryption(CipherTable cipherTable) {
        this.cipherTable = cipherTable;
    }

    public String decrypt(String encryptedMessage, String keyword) {
        String extendedKeyword = KeywordUtil.repeatKeyword(keyword, encryptedMessage.length());
        StringBuilder decryptedMessage = new StringBuilder();

        for (int i = 0; i < encryptedMessage.length(); i++) {
            int col = extendedKeyword.charAt(i) - 'a';
            char encryptedChar = encryptedMessage.charAt(i);
            int row = cipherTable.findRowForChar(col, encryptedChar);
            decryptedMessage.append((char) ('a' + row));
        }
        return decryptedMessage.toString();
    }
}
