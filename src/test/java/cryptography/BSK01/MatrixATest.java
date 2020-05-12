package cryptography.BSK01;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MatrixATest {

    private MatrixA matrixA;


    @BeforeEach
    void setUp() {
        this.matrixA = new MatrixA();
    }

    @DisplayName("Matrix A encryption test")
    @Test
    void encryptionTest() {
        assertEquals("YCPRGTROHAYPAOS", matrixA.encrypt("CRYPTOGRAPHYOSA", "3142"));
    }

    @DisplayName("Matrix A decryption test")
    @Test
    @Disabled
    void decryptionTest() {
        assertEquals("CRYPTOGRAPHYOSA", matrixA.decrypt("YCPRGTROHAYPAOS", "3142"));
    }

    @DisplayName("Matrix A key parsing test")
    @Test
    void keyParsingTest() {
        assertThrows(NumberFormatException.class, () -> matrixA.encrypt("CRYPTOGRAPHYOSA", "A"));
        assertThrows(NumberFormatException.class, () -> matrixA.encrypt("CRYPTOGRAPHYOSA", ":"));
        assertThrows(NumberFormatException.class, () -> matrixA.encrypt("CRYPTOGRAPHYOSA", "."));
        assertThrows(NumberFormatException.class, () -> matrixA.encrypt("CRYPTOGRAPHYOSA", "@"));
        assertThrows(NumberFormatException.class, () -> matrixA.encrypt("CRYPTOGRAPHYOSA", "/"));

        assertThrows(NumberFormatException.class, () -> matrixA.decrypt("YCPRGTROHAYPAOS", "A"));
        assertThrows(NumberFormatException.class, () -> matrixA.decrypt("YCPRGTROHAYPAOS", ":"));
        assertThrows(NumberFormatException.class, () -> matrixA.decrypt("YCPRGTROHAYPAOS", "."));
        assertThrows(NumberFormatException.class, () -> matrixA.decrypt("YCPRGTROHAYPAOS", "@"));
        assertThrows(NumberFormatException.class, () -> matrixA.decrypt("YCPRGTROHAYPAOS", "/"));
    }
}