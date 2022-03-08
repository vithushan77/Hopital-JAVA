import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;

import Manager.Manager;

class HopitalTest {
	
	private static Manager manager;

	@BeforeAll
	static void init() {
		manager = new Manager();
	}

	@Test
	void testConnexionBDD() throws Exception {
		manager.connexionbdd();
		assertTrue("Test connexion bdd réussie");
	}

}
