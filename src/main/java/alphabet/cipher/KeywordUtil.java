package alphabet.cipher;

public class KeywordUtil {
    public static String repeatKeyword(String keyword, int length) {
        if (keyword.isEmpty()) {
            throw new IllegalArgumentException("Keyword가 입력되지 않았습니다.");
        }
        return secretKeyword(keyword, length);
    }

    private static String secretKeyword(String keyword, int length) {
        StringBuilder repeated = new StringBuilder();
        while (repeated.length() < length) {
            repeated.append(keyword);
        }
        return repeated.substring(0, length);
    }
}
