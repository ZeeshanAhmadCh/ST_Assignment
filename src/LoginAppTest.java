import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginAppTest {

    private final LoginApp loginApp = new LoginApp();

    @Test
    public void testValidEmailAndPassword() {
        String email = "johndoe@example.com";
        String password = "password123";
        String result = loginApp.authenticateUser(email, password);

        assertNotNull(result, "Result should not be null for valid credentials.");
        assertEquals("John Doe", result, "Expected username 'John Doe' but got: " + result);
    }

    @Test
    public void testInvalidEmailFormat() {
        String email = "invalidemail";
        String password = "password123";
        String result = loginApp.authenticateUser(email, password);

        assertNull(result, "Result should be null for invalid email format.");
    }

    @Test
    public void testEmptyEmailOrPassword() {
        String result1 = loginApp.authenticateUser("", "password123");
        String result2 = loginApp.authenticateUser("johndoe@example.com", "");

        assertNull(result1, "Result should be null for empty email.");
        assertNull(result2, "Result should be null for empty password.");
    }

    @Test
    public void testIncorrectPassword() {
        String email = "johndoe@example.com";
        String password = "wrongpassword";
        String result = loginApp.authenticateUser(email, password);

        assertNull(result, "Result should be null for incorrect password.");
    }

    @Test
    public void testNonExistentEmail() {
        String email = "nonexistent@example.com";
        String password = "password123";
        String result = loginApp.authenticateUser(email, password);

        assertNull(result, "Result should be null for non-existent email.");
    }
}
