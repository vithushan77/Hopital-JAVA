


package Manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Manager {

	public void connexion() {


		BDD bdd = new BDD();
		Connection co_bdd = bdd.connection();
		try {
			java.sql.Statement stm = co_bdd.createStatement();
			ResultSet resultat = stm.executeQuery("SELECT * FROM utilisateurs WHERE nom = '" + textField.getText() + "' AND prenom = '" + textField_1.getText() +"'");
			if(resultat.next()){


				JOptionPane.showMessageDialog(null, " ! !");
			}
			else {
				JOptionPane.showMessageDialog(null, "Mauvais login ou mot de passe!");					 
			}


		}
		catch (SQLException e2) {

			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

}




