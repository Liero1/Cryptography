package cryptography.BSK02;

import cryptography.base.Cryptography;

public class Vigenere implements Cryptography {

    String finishText;


    public String encrypt(String message, String key) {
         this.finishText = "";
        message = message.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < message.length(); i++)
        {
            char c = message.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            this.finishText += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return this.finishText;
    }


    public String decrypt(String message, String key) {
        this.finishText = "";
        message = message.toUpperCase();
        key = key.toUpperCase();
        for (int i = 0, j = 0; i < message.length(); i++)
        {
            char c = message.charAt(i);
            if (c < 'A' || c > 'Z')
                continue;
            this.finishText += (char) ((c - key.charAt(j) + 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return this.finishText;
    }
}
