


package Manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Model.Utilisateur;

public class Manager {
	private int r1;
	private ResultSet Nomfilm;
	private String desc;
	private ResultSet r2;
	private ResultSet r3;
	public int exist;
	public int admin;
	
	public Connection connexionbdd (){
		Connection cnx = null;
		String url="jdbc:mysql://localhost:8889/hopital_java?serverTimezone=UTC";
		String user="root";
		String password="root";
		try {
			cnx = DriverManager.getConnection(url,user, password);
			System.out.println("Etat de la connexion : ");
			System.out.println(cnx.isClosed()?"fermée":"ouverte");
		}
		catch (SQLException e) {
			System.out.println("Une erreur est survenue lors de la connexion à la base de données");
			e.printStackTrace();
		}

		return cnx;
	}

	public boolean connexionuser(Utilisateur ut) {
		
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;
		try {
			stm = co_bdd.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		String re2 = "SELECT * FROM utilisateur WHERE mail = '" + ut.getMail() + "'AND mdp = '" + ut.getMdp() + '"';
		System.out.println(re2);

		try {
			r2 = stm.executeQuery(re2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(ut.getMdp().equals(re2)) {
			
			return true;
			
		}
		else {
			return false;
		}
		

	
		

	}
	
	
	public void inscription(Utilisateur ajut){
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm1 = null;
		try {
			stm1 = co_bdd.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		String re3 = "INSERT INTO utilisateur (nom , prenom, mail, mdp, status, etatCompte) VALUES ('" + ajut.getNom() + "','"+ajut.getPrenom() +"','"+ajut.getMail() +"','"+ ajut.getMdp() +"', 'patient,'1')";
		System.out.println(re3);

		try {
			r1 = stm1.executeUpdate(re3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("hello");
		//	e.printStackTrace();
		}
		
	}
	}






