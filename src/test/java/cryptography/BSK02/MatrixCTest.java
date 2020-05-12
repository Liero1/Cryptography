package cryptography.BSK02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MatrixCTest {

    private MatrixC matrixC;


    @BeforeEach
    void setUp() {
        this.matrixC = new MatrixC();
    }

    @DisplayName("Matrix C encryption test")
    @Test
    void testEncryption() {
        Assertions.assertEquals("HEESPNI RR SSEES EIY A SCBT EMGEPN ANDI CT RTAHSO IEERO",
                matrixC.encrypt("HERE IS A SECRET MESSAGE ENCIPHERED BY TRANSPOSITION", "CONVENIENCE"));
    }

    @DisplayName("Matrix C decryption test")
    @Test
    void testDecryption() {
        Assertions.assertEquals("HEREISASECRETMESSAGEENCIPHEREDBYTRANSPOSITION",
                matrixC.decrypt("HEESPNI RR SSEES EIY A SCBT EMGEPN ANDI CT RTAHSO IEERO", "CONVENIENCE"));
    }
}