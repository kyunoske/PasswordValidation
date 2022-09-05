import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordTest {

    @Test
    void getLengthTest(){
        // GIVEN
        String password = "password1";
        // WHEN
        int actual = Password.getLength(password);

        // THEN
        assertEquals(9, actual);
    }

    @Test
    void checkLengthTestForLonger8(){
        // GIVEN
        String password = "passwordDDD";
        // WHEN
        String actual = Password.checkPassword(password);

        // THEN
        assertEquals("Fehlende Zahl im Passwort.", actual);
    }

    @Test
    void checkLengthTestForLonger81(){
        // GIVEN
        String password = "password";
        // WHEN
        String actual = Password.checkPassword(password);

        // THEN
        assertEquals("Fehlende Zahl/ Groß-, Kleinschreibung im Passwort.", actual);
    }

    @Test
    void checkLengthTestForLonger82(){
        // GIVEN
        String password = "PASsWORD1";
        // WHEN
        String actual = Password.checkPassword(password);

        // THEN
        assertEquals("Passwort akzeptiert.", actual);
    }

    @Test
    void checkLengthTestForShorter8(){
        // GIVEN
        String password = "pass";
        // WHEN
        String actual = Password.checkPassword(password);

        // THEN
        assertEquals("Passwort zu kurz!", actual);
    }

    @Test
    void checkNumberTestFor0() {
        //GIVEN
        String password = "password1";

        //WHEN
        boolean actual = Password.checkNumber(password);

        //THEN
        assertEquals(true, actual);
    }

    @Test
    void checkNumberTestForUpAndLow() {
        //GIVEN
        String password = "pasSword";

        //WHEN
        boolean actual = Password.checkUpperCase(password);

        //THEN
        assertEquals(true, actual);
    }

    @Test
    void checkBadPassword() {
        //Given
        String password = "A12345678";

        //WHEN
        boolean actual = Password.checkBadPasswords(password);

        //THEN
        assertEquals(true, actual);
    }
}


