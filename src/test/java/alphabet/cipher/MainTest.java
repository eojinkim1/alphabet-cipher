package alphabet.cipher;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {
    CipherTable cipherTable = new CipherTable();
    Encryption encryption = new Encryption(cipherTable);
    Decryption decryption = new Decryption(cipherTable);

    @Test
    void testEncrypt() {
        String message = "iloveyou";
        String keyword = "metoo";
        String encrypted = encryption.encrypt(message, keyword);

        assertEquals("uphjsksn", encrypted);
    }

    @Test
    void testDecrypt() {
        String message = "ihateyou";
        String keyword = "metoo";

        String encrypted = encryption.encrypt(message, keyword);
        String decrypted = decryption.decrypt(encrypted, keyword);

        assertEquals(message, decrypted);
    }

    @Test
    void testShortAndLongKeywords() {
        String keyword = KeywordUtil.repeatKeyword("keyword", 10);
        assertEquals("keywordkey", keyword);

        keyword = KeywordUtil.repeatKeyword("keyword", 3);
        assertEquals("key", keyword);
    }

    @Test
    void testEdgeCases() {
        // 빈 문자열 암호화/복호화 확인
        assertEquals("", encryption.encrypt("", "key"));
        assertEquals("", decryption.decrypt("", "key"));

        // 키워드가 빈 문자열일 경우 예외 처리 확인
        assertThrows(IllegalArgumentException.class, () -> {
            encryption.encrypt("message", "");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            decryption.decrypt("encryptedMessage", "");
        });
    }
}
