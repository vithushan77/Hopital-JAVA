package Manager;

import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Manager manager = new Manager();
		manager.AjouterPatient("DOMINGUES", "Alexandre", "06 78 98 47 78", "01 Allée de Paris 75001 Paris", "Matmut", "1 00 93 89 38 78 100");
		}
	}