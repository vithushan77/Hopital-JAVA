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
	public void testConnexionAvecCompteInexistant() throws Exception {
		boolean reponse = manager.VerifyOAuth("h-linda@outlook.fr", "Dubai");
		Assertions.assertFalse(reponse);
	}
	
	@Test
	@Order(3)
	public void testConnexionAvecErreurDeSaisie() throws Exception {
		boolean reponse = manager.VerifyOAuth("m.tan@outloo.fr", "TheOriGinalSlenderman");
		Assertions.assertFalse(reponse);
	}
	
	@Test
	@Order(4)
	public void testConnexionAvecChampsVides() throws Exception {
		String mail = null;
		String mdp = null;
		Assertions.assertNull(mail);
		Assertions.assertNull(mdp);
		boolean reponse = manager.VerifyOAuth(mail, mdp);
		Assertions.assertNotEquals(reponse, "Identifiants vides");
	}

	@Test
	@Order(5)
	public void testConnexionAvecSeulementUnIdentifiantValide() throws Exception {
		String mail = "m.tang@outlook.fr";
		String mdp = "EqMz[Oj9-P]LWn";
		Assertions.assertNotNull(mail, "m.tang@outlook.fr");
		Assertions.assertNotEquals(mdp, "TheOriginalSlenderman");
		boolean reponse = manager.VerifyOAuth(mail, mdp);
		Assertions.assertFalse(reponse);
	}
	
	@Test
	@Order(6)
	public void testConnexionAvecSeulementUnMotDePasseValide() throws Exception {
		String mail = null;
		String mdp = "TheOriginalSlenderman";
		Assertions.assertNull(mail);
		Assertions.assertNotNull(mdp);
		boolean reponse = manager.VerifyOAuth(mail, mdp);
		Assertions.assertFalse(reponse);
	}
	
	@Test
	@Order(7)
	public void testVerificationEtatCompteSiActive() throws Exception {
		boolean reponse = manager.VerifEtatCompte("m.tang@outlook.fr");
		Assertions.assertTrue(reponse);
	}

	@Test
	@Order(8)
	public void testVerificationEtatCompteSiDesactive() throws Exception {
		boolean reponse = manager.VerifEtatCompte("sipraseuth-noah@outlook.fr");
		Assertions.assertFalse(reponse);
	}
}
