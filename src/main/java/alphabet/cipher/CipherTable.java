package alphabet.cipher;

public class CipherTable {

    private static final char[][] CIPHER_TABLE = generateCipherTable();

    public static char[][] createCipherTable() {
        return CIPHER_TABLE;
    }

    private static char[][] generateCipherTable() {
        char[][] table = new char[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                table[i][j] = (char) ('a' + (i + j) % 26);
            }
        }
        return table;
    }

    public char getChar(int row, int col) {
        return CIPHER_TABLE[row][col];
    }

    public int findRowForChar(int col, char targetChar) {
        for (int row = 0; row < 26; row++) {
            if (CIPHER_TABLE[row][col] == targetChar) {
                return row;
            }
        }
        throw new IllegalArgumentException("문자를 CIPHER_TABLE 에서 찾을 수 없습니다.");
    }
}
