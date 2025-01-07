package alphabet.cipher;

import org.example.AlphabetCipher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AlphabetCipherTest {

    @Test
    void createCipherTable() {
        char[][] table = AlphabetCipher.createCipherTable();

        for (int i = 0; i < 26; i++) {
            assertEquals((char) ('a' + i), table[0][i]);
        }

        // 두 번째 행이 'b'부터 시작하는지 확인
        for (int i = 0; i < 26; i++) {
            assertEquals((char) ('a' + (i + 1) % 26), table[1][i]);
        }
    }

    @Test
    void testRepeatedKeyword() {
        String keyword = AlphabetCipher.repeatKeyword("keyword", 10);
        assertEquals("keywordkey", keyword);

        keyword = AlphabetCipher.repeatKeyword("keyword", 3);
        assertEquals("key", keyword);
    }

    @Test
    void testEncrypt() {
        String message = "iloveyou";
        String keyword = "metoo";
        String encrypted = AlphabetCipher.encrypt(message, keyword);

        assertEquals("uphjsksn", encrypted);
    }

    @Test
    void testDecrypt() {
        String message = "ihateyou";
        String keyword = "metoo";

        String encrypted = AlphabetCipher.encrypt(message, keyword);
        String decrypted = AlphabetCipher.decrypt(encrypted, keyword);

        assertEquals(message, decrypted);
    }

    @Test
    void testEgeCase() {
        String encrypted = AlphabetCipher.encrypt("", "key");
        assertEquals("", encrypted);
        String decrypted = AlphabetCipher.decrypt("", "key");
        assertEquals("", decrypted);

        assertThrows(IllegalArgumentException.class, () -> {
            AlphabetCipher.encrypt("message", "");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            AlphabetCipher.decrypt("encryptedMessage", "");
        });
    }
}
