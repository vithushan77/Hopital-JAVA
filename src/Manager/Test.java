package Manager;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Manager manager = new Manager();
		manager.AjouterUtilisateurs("NGUYEN", "Kimmy", "n.kimmy@hotmail.fr", "DeathStr@nDIn0g", "admin", true);
	}

}
