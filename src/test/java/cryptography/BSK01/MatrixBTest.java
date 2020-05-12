package cryptography.BSK01;

import org.junit.jupiter.api.*;

class MatrixBTest {

    private MatrixB matrixB;


    @BeforeEach
    void setUp() {
        this.matrixB = new MatrixB();
    }


    @DisplayName("Matrix B encryption test")
    @Test
    void testEncryption() {
        String expected = "HECRN CEYI ISEP SGDI RNTO AAES RMPN SSRO EEBT ETIA EEHS";
        String encryptedMessage = matrixB.encrypt("HERE IS A SECRET MESSAGE ENCIPHERED BY TRANSPOSITION",
                "CONVENIENCE");

        Assertions.assertEquals(expected, encryptedMessage);
    }

    @DisplayName("Matrix B decryption test")
    @Test
    void testDecryption() {
        String expected = "HEREISASECRETMESSAGEENCIPHEREDBYTRANSPOSITION";
        String decryptedMessage = matrixB.decrypt("HECRN CEYI ISEP SGDI RNTO AAES RMPN SSRO EEBT ETIA EEHS", "CONVENIENCE");

        Assertions.assertEquals(expected, decryptedMessage);
    }
}