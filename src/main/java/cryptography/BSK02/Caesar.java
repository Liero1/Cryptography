package cryptography.BSK02;

import cryptography.base.Cryptography;

public class Caesar implements Cryptography {
    @Override
    public String encrypt(String message, String key) {
        int k = Integer.parseInt(key);
        //zmiana wiadomości na wielkie litery
        String text = message.replaceAll(" ", "").toUpperCase();
        //wpisanie wiadomości do tablicy znaków
        char[] array = text.toCharArray();
        //przechodzenie po kolei po znakach wiadomości i dodawanie klucza
        for(int j=0;j<array.length;j++){
            char c = (char) (array[j] + k);
            //jeśli zaszyfrowany znak wykracza poza alfabet to jest odejmowane lub dodawane 26 (ilość liter w alfabecie)
            if(c>90) c-=26;
            else if(c<65) c+=26;
            array[j] = c;
        }
        return String.valueOf(array);
    }

    @Override
    public String decrypt(String message, String key) {
        int k = Integer.parseInt(key);
        //zmiana wiadomości na wielkie litery
        String text = message.replaceAll(" ", "").toUpperCase();
        char[] array = text.toCharArray();
        //przechodzenie po kolei po znakach wiadomości i odejmowanie klucza
        for(int i=0;i<array.length;i++){
            char a = (char) (array[i]-k);
            //jeśli zaszyfrowany znak wykracza poza alfabet to jest odejmowane lub dodawane 26 (ilość liter w alfabecie)
            if(a>90) a-=26;
            else if(a<65) a+=26;
            array[i] = a;
        }
        return String.valueOf(array);
    }
}
