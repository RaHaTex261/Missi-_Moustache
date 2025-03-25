package userTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SignupUserTest {
    
    private SignupUserTest signupUser;
    
    @BeforeEach
    void setUp() {
        signupUser = new SignupUserTest(); // Initialiser l'objet avant chaque test
    }

    @Test
    void testValidEmail() {
        assertTrue(signupUser.isValidEmail("test@example.com"), "L'email devrait être valide");
        assertFalse(signupUser.isValidEmail("invalid-email"), "L'email ne devrait pas être valide");
    }

    private BooleanSupplier isValidEmail(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
    void testValidStrongPassword() {
        assertTrue(signupUser.isValidStrongPassword("Abcdef1@"), "Le mot de passe doit être valide");
        assertFalse(signupUser.isValidStrongPassword("weakpass"), "Le mot de passe est trop faible");
    }

	private BooleanSupplier isValidStrongPassword(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
