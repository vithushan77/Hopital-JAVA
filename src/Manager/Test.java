package Manager;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Manager manager = new Manager();
		manager.AjouterUtilisateurs("KARER", "Erdal", "k.erdal@outlook.fr", "FirstAdmin1", "admin", true);
		}
	}
