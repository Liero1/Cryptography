package cryptography.BSK02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CaesarTest {

    private Caesar caesar;


    @BeforeEach
    void setUp() {
        this.caesar = new Caesar();
    }

    @DisplayName("Caesar encryption test")
    @Test
    void testEncryption() {
        assertEquals("FUBSWRJUDSKB", caesar.encrypt("CRYPTOGRAPHY", "3"));
        assertEquals("JCFRUQJYJCYYTYWFSXQFYJ", caesar.encrypt("EXAMPLE TEXT TO TRANSLATE", "5"));
        assertEquals("ZSVHKGZOZSOOJOMVINGVOZ", caesar.encrypt("EXAMPLE TEXT TO TRANSLATE", "-5"));
        assertEquals("PILXAWPEPIEEZECLYDWLEP", caesar.encrypt("EXAMPLE TEXT TO TRANSLATE", "-15"));
        assertEquals("EXAMPLETEXTTOTRANSLATE", caesar.encrypt("EXAMPLE TEXT TO TRANSLATE", "0"));
    }

    @DisplayName("Caesar decryption test")
    @Test
    void testDecryption() {
        assertEquals("CRYPTOGRAPHY", caesar.decrypt("FUBSWRJUDSKB", "3"));
        assertEquals("EXAMPLETEXTTOTRANSLATE", caesar.decrypt("JCFRUQJYJCYYTYWFSXQFYJ", "5"));
        assertEquals("EXAMPLETEXTTOTRANSLATE", caesar.decrypt("ZSVHKGZOZSOOJOMVINGVOZ", "-5"));
        assertEquals("EXAMPLETEXTTOTRANSLATE", caesar.decrypt("PILXAWPEPIEEZECLYDWLEP", "-15"));
        assertEquals("EXAMPLETEXTTOTRANSLATE", caesar.decrypt("EXAMPLE TEXT TO TRANSLATE", "0"));
    }

    @DisplayName("Caesar key parsing test")
    @Test
    void keyParsingTest() {
        assertThrows(NumberFormatException.class, () -> caesar.encrypt("CRYPTOGRAPHY", "AB"));
        assertThrows(NumberFormatException.class, () -> caesar.encrypt("CRYPTOGRAPHY", ":"));
        assertThrows(NumberFormatException.class, () -> caesar.encrypt("CRYPTOGRAPHY", "*"));
        assertThrows(NumberFormatException.class, () -> caesar.encrypt("CRYPTOGRAPHY", "("));
        assertThrows(NumberFormatException.class, () -> caesar.encrypt("CRYPTOGRAPHY", "@"));

        assertThrows(NumberFormatException.class, () -> caesar.decrypt("FUBSWRJUDSKB", "AB"));
        assertThrows(NumberFormatException.class, () -> caesar.decrypt("FUBSWRJUDSKB", ":"));
        assertThrows(NumberFormatException.class, () -> caesar.decrypt("FUBSWRJUDSKB", "*"));
        assertThrows(NumberFormatException.class, () -> caesar.decrypt("FUBSWRJUDSKB", "("));
        assertThrows(NumberFormatException.class, () -> caesar.decrypt("FUBSWRJUDSKB", "@"));
    }
}