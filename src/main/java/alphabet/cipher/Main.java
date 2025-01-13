package alphabet.cipher;

public class Main {
    public static void main(String[] args) {
        CipherTable cipherTable = new CipherTable();
        Encryption encryption = new Encryption(cipherTable);
        Decryption decryption = new Decryption(cipherTable);

        String message = "iloveyou";
        String keyword = "metoo";

        String encrypted = encryption.encrypt(message, keyword);
        System.out.println("Encrypted Message: " + encrypted);

        String decrypted = decryption.decrypt(encrypted, keyword);
        System.out.println("Decrypted Message: " + decrypted);
    }
}
