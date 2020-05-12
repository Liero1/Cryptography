package cryptography.BSK01;

import cryptography.base.Cryptography;

import java.util.*;

public class MatrixB implements Cryptography {

    @Override
    public String encrypt(String message, String key) {
        String text = message.replaceAll(" ", "");
        int textLen = text.length();
        int keyLen = key.length();
        char[][] matrix = new char[keyLen][(int) Math.ceil((double) textLen/keyLen)];

        fillMatrixWithZeros(matrix);
        fillMatrix(text, matrix);

        List<Integer> order = getOrder(key);
        String encryptedMessage = "";

        for(int i=0; i<order.size(); i++) {
            for(int j=0; j<matrix[i].length; j++) {
                if(matrix[order.get(i)][j] != 0) {
                    encryptedMessage += matrix[order.get(i)][j];
                }
            }

            if (i < order.size() - 1) {
                encryptedMessage += " ";
            }
        }

        return encryptedMessage;
    }

    @Override
    public String decrypt(String message, String key) {
        String text = message.replaceAll(" ", "");
        int textLen = text.length();
        int keyLen = key.length();
        char[][] matrix = new char[keyLen][(int) Math.ceil((double) textLen/keyLen)];
        List<Integer> order = getOrder(key);

        fillMatrixWithZeros(matrix);
        fillMatrixFromEncrypted(message, matrix, order);

        String decryptedMsg = "";
        int x = 0;

        for (int i=0; i<matrix[i].length; i++) {
            for (int j=0; j<matrix.length; j++, x++) {
                if (message.length() > x && matrix[j][i] != 0) {
                    decryptedMsg += matrix[j][i];
                } else break;
            }
        }

        return decryptedMsg;
    }

    private static void fillMatrixWithZeros(char[][] matrix) {
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    private static void fillMatrix(String message, char[][] matrix) {
        int x = 0;

        for(int i=0; i<matrix[i].length; i++) {
            for(int j=0; j<matrix.length; j++, x++) {
                if (message.length() > x) {
                    matrix[j][i] = message.charAt(x);
                } else break;
            }
        }
    }

    private static void fillMatrixFromEncrypted(String encryptedMsg, char[][] matrix, List<Integer> order) {
        String[] words = encryptedMsg.split(" ");

        for (int i=0; i<order.size(); i++) {
            String word = words[i];

            for(int j=0; j<matrix[order.get(i)].length; j++) {
                if (word.length() > j) {
                    matrix[order.get(i)][j] = word.charAt(j);
                }
            }
        }
    }

    private static List<Integer> getOrder(String key) {
        List<Integer> order = new ArrayList<>();
        TreeSet<Character> characters = new TreeSet<>();

        for(int i = 0; i<key.length(); i++) {
            characters.add(key.charAt(i));
        }

        for (char character : characters) {
            for (int i = 0; i < key.length(); i++) {
                if (key.charAt(i) == character) {
                    order.add(i);
                }
            }
        }

        return order;
    }
}