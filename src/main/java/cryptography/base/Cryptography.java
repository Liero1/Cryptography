package cryptography.base;

public interface Cryptography {
    String encrypt(String message, String key);

    String decrypt(String message, String key);
}
