package cryptography.BSK01;

import cryptography.base.Cryptography;

import java.util.LinkedList;

public class MatrixA implements Cryptography {
    @Override
    public String encrypt(String message, String key) {
        String text = message.replaceAll(" ", "");
        int keyLength = key.length();
        int textLength = text.length();
        int[] keyArray = new int[keyLength];

        //wpisanie klucza do tablicy
        for(int i=0;i<keyLength;i++){
            keyArray[i] = Integer.parseInt(String.valueOf(key.charAt(i)))-1;
        }
        char[][] matrix = new char[(int) Math.ceil((double) textLength/keyLength)][keyLength];

        //wypełnienie tablicy
        fillMatrix(text,matrix);

        String encryptedMessage = "";

        //chodzenie po macierzy wierszami i odczytywanie znaków z macierzy według kolejności ustalonej przez klucz
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                encryptedMessage += matrix[i][keyArray[j]];
            }
        }

        return encryptedMessage.replace(".", "");
    }
    @Override
    public String decrypt(String message, String key) {
        int keyLength = key.length();
        int textLength = message.length();
        LinkedList<Integer> keyList = new LinkedList<>();

        //wpisanie cyfr z klucza do listy
        for(int j=0;j<keyLength;j++){
            keyList.add(j,Integer.parseInt(String.valueOf(key.charAt(j)))-1);
        }
        char[][] matrix = new char[(int) Math.ceil((double) textLength/keyLength)][keyLength];

        //wypełnienie macierzy wiadomością
        fillMatrix(message,matrix);

        String decryptedMessage = "";

        //przykładowy klucz: 2031
        //zmodyfikowany klucz do odszyfrowania: indexOf(0)=1,indexOf(1)=3,indexOf(2)=0,indexOf(3)=2  -->k: 1302
        //chodzenie po macierzy wierszami i odczytywanie znaków poprzez zmodyfikowany klucz
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                decryptedMessage += matrix[i][keyList.indexOf(j)];
            }
        }

        return decryptedMessage;
    }

    private static void fillMatrix(String message, char[][] matrix) {
        int x = 0;
        //wpisanie wiadomości do macierzy wierszami
        //jeśli wiadomość jest krótsza niż ilość pól w macierzy to pozostałe pola są oznaczone przez kropke
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; ++j, x++) {
                if (message.length() > x) {
                    matrix[i][j] = message.charAt(x);
                } else {
                    matrix[i][j] = '.';
                }
            }
        }
    }
}
