package cryptography.BSK02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class VigenereTest {

    private Vigenere vigenere;


    @BeforeEach
    void setUp() {
        this.vigenere = new Vigenere();
    }

    @DisplayName("Vigenere encryption test")
    @Test
    void testEncryption() {
        Assertions.assertEquals("DICPDPXVAZIP", vigenere.encrypt("CRYPTOGRAPHY", "BREAKBREAKBR"));
        Assertions.assertEquals("FOEMZMVXEHUKPKVAXTCETO", vigenere.encrypt("EXAMPLE TEXT TO TRANSLATE", "BREAKBREAKBR"));
        Assertions.assertEquals("EYCMQNEUEYVTPVRBNTNAUG", vigenere.encrypt("EXAMPLE TEXT TO TRANSLATE", "ABCABCAB"));
        Assertions.assertEquals("EXAMPLETEXTTOTRANSLATE", vigenere.encrypt("EXAMPLE TEXT TO TRANSLATE", "AAAA"));
        Assertions.assertEquals("EYAOPMEWEXTUOWRBNULBTH", vigenere.encrypt("EXAMPLE TEXT TO TRANSLATE", "ABACABADAAABAD"));
    }

    @DisplayName("Vigenere decryption test")
    @Test
    void testDecryption() {
        Assertions.assertEquals("CRYPTOGRAPHY", vigenere.decrypt("DICPDPXVAZIP", "BREAKBREAKBR"));
        Assertions.assertEquals("EXAMPLETEXTTOTRANSLATE", vigenere.decrypt("FOEMZMV XEHU KP KVAXTCETO", "BREAKBREAKBR"));
        Assertions.assertEquals("EXAMPLETEXTTOTRANSLATE", vigenere.decrypt("EYCMQNE UEYV TP VRBNTNAUG", "ABCABCAB"));
        Assertions.assertEquals("EXAMPLETEXTTOTRANSLATE", vigenere.decrypt("EXAMPLE TEXT TO TRANSLATE", "AAAA"));
        Assertions.assertEquals("EXAMPLETEXTTOTRANSLATE", vigenere.decrypt("EYAOPME WEXT UO WRBNULBTH", "ABACABADAAABAD"));
    }
}