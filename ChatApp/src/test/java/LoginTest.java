package test;

import model.Login;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    Login login = new Login();

    @Test
    public void testValidUsername() {
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(login.checkUserName("kyle"));
    }

    @Test
    public void testValidPassword() {
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testValidCellPhone() {
        assertTrue(login.checkCellPhoneNumber("+27605838016"));
    }

    @Test
    public void testInvalidCellPhone() {
        assertFalse(login.checkCellPhoneNumber("0605391683"));
    }

    @Test
    public void testSuccessfulLogin() {
        login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27605838016");
        assertTrue(login.logInUser("kyl_1", "Ch&&sec@ke99!"));
        assertEquals("welcome Kyle, Smith it is great to see you again.", login.returnLoginStatus());
    }

    @Test
    public void testFailedLogin() {
        login.registerUser("Kyle", "Smith", "kyl_1", "Ch&&sec@ke99!", "+27605838016");
        assertFalse(login.logInUser("wrong", "user"));
        assertEquals("username or password incorrect, please try again.", login.returnLoginStatus());
    }
}
