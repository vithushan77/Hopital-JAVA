package Manager;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Manager manager = new Manager();
		manager.AjouterUtilisateurs("LEVAN", "J�r�my", "l.jeremy@outlook.fr", "Cloud", "admin", true);
		}
	}