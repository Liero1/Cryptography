package cryptography.BSK01;

import cryptography.base.Cryptography;

public class RailFence implements Cryptography {

    int columns;
    boolean checkdown;
    String finishText = "";

    public String encrypt(String message, String railsAsString) {
        this.checkdown = false;
        int rails = Integer.parseInt(railsAsString);
        int j = 0;
        this.columns = message.length();
        this.finishText = "";
        char[][] a = new char[rails][this.columns];


        for (int i = 0; i < this.columns; i++) {
            if (j == 0 || j == rails - 1)
                checkdown = !checkdown;
            a[j][i] = message.charAt(i);
            if (checkdown) {
                j++;
            } else
                j--;
        }

        for (int i = 0; i < rails; i++) {
            for (int k = 0; k < this.columns; k++) {
                if (a[i][k] != 0)
                    this.finishText = this.finishText + a[i][k];
            }
        }
        return this.finishText;
    }

    public String decrypt(String message, String railsAsString) {
        boolean checkdown = false;
        int rails = Integer.parseInt(railsAsString);
        int j = 0;
        this.columns = message.length();
        this.finishText = "";
        char[][] a = new char[rails][this.columns];
        for (int i = 0; i < this.columns; i++) {
            if (j == 0 || j == rails - 1)
                checkdown = !checkdown;
            a[j][i] = '@';
            if (checkdown) j++;
            else j--;
        }

        int index = 0;
        for (int i = 0; i < rails; i++) {
            for (int k = 0; k < this.columns; k++) {
                if (a[i][k] == '@' && index < message.length()) {
                    a[i][k] = message.charAt(index++);
                }
            }
        }

        checkdown = false;
        j = 0;
        for (int i = 0; i < this.columns; i++) {
            if (j == 0 || j == rails - 1)
                checkdown = !checkdown;
            this.finishText += a[j][i];
            if (checkdown) j++;
            else j--;
        }
        return this.finishText;
    }
}
