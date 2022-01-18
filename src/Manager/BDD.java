package Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD {
	public static void main(String[] args) {
				

			 	 // On stock dans des variables l'URL de connexion à la base de donnée avec les identifiants
			 	
		String url="jdbc:mysql://localhost/hopital_java?serverTimezone=UTC";
		String user="root:8889";
		String password="root";
		try {
		 // On créé une variable cnx de type Connection
		 // cnx contiendra la connexion � la base de données
		 Connection cnx = DriverManager.getConnection(url,user, password);
		 System.out.println("Etat de la connexion :");
		 // Forme ternaire du if. Si la condition à échoué alors on affiche « fermé  sinon on affiche « ouverte »
		 
		 System.out.println(cnx.isClosed()?"fermée":"ouverte");

		 }
		 // Si on arrive pas à se connetcer on attrape l'erreur pour l'afficher ensuite
		 catch (SQLException e) {
		 System.out.println("Une erreur est survenue lors de la connexion à la base de données");
		 e.printStackTrace();
		 }
		}
}