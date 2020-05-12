package cryptography.BSK02;


import cryptography.base.Cryptography;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MatrixC implements Cryptography {

    @Override
    public String encrypt(String message, String key) {
        String text = message.replaceAll(" ", "");
        int keyLen = key.length();
        List<char[]> matrix = new ArrayList<>();
        List<Integer> order = getOrder(key);

        fillMatrix(text, key, matrix);
        String encryptedMessage = "";

        for (int i=0; i<keyLen; i++) {
            for (char[] row : matrix) {
                if (row[order.get(i)] != ' ') {
                    encryptedMessage += row[order.get(i)];
                }
            }

            encryptedMessage += ' ';
        }

        return encryptedMessage.trim();
    }

    private void fillMatrix(String text, String key, List<char[]> matrix) {
        List<Integer> order = getOrder(key);
        int keyLen = key.length();
        int charIndex = 0;

        for (int i=0; i<order.size(); i++) {
            char[] row = new char[keyLen];
            Arrays.fill(row, ' ');
            matrix.add(row);

            for (int j=0; j<=order.get(i); j++) {
                row[j] = text.charAt(charIndex);

                if (charIndex++ == text.length() - 1) {
                    return;
                }
            }
        }
    }

    private List<Integer> getOrder(String key) {
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

    @Override
    public String decrypt(String message, String key) {
        String text = message.replaceAll(" ", "");
        int matrixHeight = findMatrixHeight(message.split(" "));
        List<char[]> matrix = new ArrayList<>();
        List<Integer> order = getOrder(key);

        initializeMatrix(matrix, key.length(), matrixHeight);
        markMatrix(matrix, order, text.length());
        fillMatrix(matrix, order, text);

        String decryptedMessage = "";

        for (int i=0; i<matrix.size(); i++) {
            for (int j=0; j<matrix.get(i).length; j++) {
                if (matrix.get(i)[j] != ' ') {
                    decryptedMessage += matrix.get(i)[j];
                } else {
                    break;
                }
            }
        }

        return decryptedMessage;
    }

    private int findMatrixHeight(String[] words) {
        int height = words[0].length();

        for (String word : words) {
            if (word.length() > height) {
                height = word.length();
            }
        }

        return height;
    }

    private void initializeMatrix(List<char[]> matrix, int width, int height) {
        for (int i=0; i<height; i++) {
            matrix.add(new char[width]);
        }
    }

    private void markMatrix(List<char[]> matrix, List<Integer> order, int textLen) {
        int charCounter = 0;

        for (int i=0; i<matrix.size(); i++) {
            for (int j=0; j<matrix.get(i).length; j++) {
                if (j <= order.get(i)) {
                    matrix.get(i)[j] = '-';

                    if (charCounter-- == textLen) {
                        return;
                    }
                } else {
                    matrix.get(i)[j] = ' ';
                }
            }
        }
    }

    private void fillMatrix(List<char[]> matrix, List<Integer> order, String text) {
        int charIndex = 0;

        for (int i=0; i<order.size(); i++) {
            int column = order.get(i);

            for (char[] row : matrix) {
                if (row[column] == '-') {
                    row[column] = text.charAt(charIndex++);
                }
            }
        }
    }
}