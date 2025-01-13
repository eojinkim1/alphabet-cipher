package alphabet.cipher;

import static alphabet.cipher.KeywordUtil.repeatKeyword;

public class Encryption {

    private final CipherTable cipherTable;

    public Encryption(CipherTable cipherTable) {
        this.cipherTable = cipherTable;
    }

    public String encrypt(String message, String keyword) {
        String extendedKeyword = repeatKeyword(keyword, message.length()); //import 하는 것이 아니라 앞에 KeywordUtil.repeatKeyword 도 가능
        StringBuilder encryptedMessage = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            int row = message.charAt(i) - 'a';
            int col = extendedKeyword.charAt(i) - 'a';
            encryptedMessage.append(cipherTable.getChar(row, col));
        }
        return encryptedMessage.toString();
    }
}
