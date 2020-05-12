package cryptography.BSK01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RailFenceTest {

    private RailFence railFence;


    @BeforeEach
    void setUp() {
        this.railFence = new RailFence();
    }


    @DisplayName("Rail Fence encryption test")
    @Test
    void encryptionTest() {
        assertEquals("CTARPORPYYGH", railFence.encrypt("CRYPTOGRAPHY", "3"));
    }

    @DisplayName("Rail Fence decryption test")
    @Test
    void decryptionTest() {
        assertEquals("CRYPTOGRAPHY", railFence.decrypt("CTARPORPYYGH", "3"));
    }

    @DisplayName("Rail Fence key parsing test")
    @Test
    void keyParsingTest() {
        assertThrows(NumberFormatException.class, () -> railFence.encrypt("CRYPTOGRAPHY", "ABC"));
        assertThrows(NumberFormatException.class, () -> railFence.encrypt("CRYPTOGRAPHY", "/"));
        assertThrows(NumberFormatException.class, () -> railFence.encrypt("CRYPTOGRAPHY", "-"));
        assertThrows(NumberFormatException.class, () -> railFence.encrypt("CRYPTOGRAPHY", "^"));
        assertThrows(NumberFormatException.class, () -> railFence.encrypt("CRYPTOGRAPHY", " "));

        assertThrows(NumberFormatException.class, () -> railFence.decrypt("CTARPORPYYGH", "ABC"));
        assertThrows(NumberFormatException.class, () -> railFence.decrypt("CRYPTOGRAPHY", "/"));
        assertThrows(NumberFormatException.class, () -> railFence.decrypt("CRYPTOGRAPHY", "-"));
        assertThrows(NumberFormatException.class, () -> railFence.decrypt("CRYPTOGRAPHY", "^"));
        assertThrows(NumberFormatException.class, () -> railFence.decrypt("CRYPTOGRAPHY", " "));
    }
}