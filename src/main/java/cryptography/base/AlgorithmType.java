package cryptography.base;

import cryptography.BSK01.MatrixA;
import cryptography.BSK01.MatrixB;
import cryptography.BSK02.Caesar;
import cryptography.BSK01.RailFence;
import cryptography.BSK02.MatrixC;
import cryptography.BSK02.Vigenere;

public enum AlgorithmType {
    MATRIXA("PRZESTAWIENIA MACIERZOWE A", new MatrixA()),
    MATRIXB("PRZESTAWIENIA MACIERZOWE B", new MatrixB()),
    RAIL_FENCE("SZYFR PLOTKOWY", new RailFence()),
    MATRIXC("PRZESTAWIENIA MACIERZOWE C", new MatrixC()),
    VIGENERE( "SZYFR VIGENERE'A", new Vigenere()),
    CAESAR("SZYFR CEZARA",new Caesar());

    private String name;
    private Cryptography cryptography;


    AlgorithmType(String name, Cryptography c) {
        this.name = name;
        this.cryptography = c;
    }


    public Cryptography getCryptography(){
        return cryptography;
    }

    public String toString(){
        return name;
    }
}
