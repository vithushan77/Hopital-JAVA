import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.PreparedStatement;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.springframework.security.crypto.bcrypt.BCrypt;

import Manager.Manager;
import Model.Utilisateur;

public class HopitalTest {
	
	private static Manager manager = new Manager();

	@BeforeAll
	static void init() {
		//manager = new Manager();
	}
	
	@Test
	@Order(1)
	public void testConnexionAvecCompteExistant() throws Exception {
		boolean reponse = manager.VerifyOAuth("m.tang@outlook.fr", "TheOriginalSlenderman");
		Assertions.assertTrue(reponse);
	}
	
	@Test
	@Order(2)
	public void testVerificationEtatDuCompte() throws Exception {
		boolean reponse = manager.VerifEtatCompte("m.tang@outlook.fr");
		Assertions.assertTrue(reponse);
	}
	
	@Test
	@Order(3)
	public void testModifierInfoCompteExistant() throws Exception {
		manager.ModifierProfil(21, "TRAN", "Pierre", "d.pierre@outlook.fr");
	}

}
