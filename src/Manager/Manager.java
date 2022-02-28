


package Manager;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import Model.Patient;
import Model.Medicaments;
import Model.Utilisateur;
import Model.Patient;

public class Manager {
	private int r1;
	private ResultSet Nomfilm;
	private String desc;
	private String desc2;
	private ResultSet r2;
	private ResultSet r3;
	public int exist;
	public int admin;
	private Array tableau;
	boolean co = false;
	private String co2;
	private static final String DELIMITER = ",";
	private static final String SEPARATOR = "\n";
	private static final String HEADER = "Nom, Quantité, Toxicité";
	
	public Connection connexionbdd (){
		Connection cnx = null;
		String url="jdbc:mysql://localhost:3306/hopital_java?serverTimezone=UTC";
		String user="root";
		String password="";
		try {
			cnx = DriverManager.getConnection(url,user, password);
			System.out.println("Etat de la connexion : ");
			System.out.println(cnx.isClosed()?"fermÃ©e":"ouverte");
		}
		catch (SQLException e) {
			System.out.println("Une erreur est survenue lors de la connexion Ã  la base de donnÃ©es");
			e.printStackTrace();
		}

		return cnx;
	}

	public String connexionuser(Utilisateur ut) {
		
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;
		try {
			stm = co_bdd.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		String re2 = "SELECT mdp FROM utilisateur WHERE mail = '" + ut.getMail() + "'";
		System.out.println(re2);
		try {
			ResultSet resultatrecherche = stm.executeQuery(re2);
			while(resultatrecherche.next()){
				// Aﬃchage des lignes qui comporte les caractères de "recherche"
				desc = resultatrecherche.getString("mdp");
				System.out.println(desc);
				System.out.println(ut.getMdp());
			}
				String re3 = "SELECT status FROM utilisateur WHERE mail = '" + ut.getMail() + "'";
				System.out.println(re3);
					ResultSet resultatrecherche2 = stm.executeQuery(re3);
					while(resultatrecherche2.next()){
						// Aﬃchage des lignes qui comporte les caractères de "recherche"
						desc2 = resultatrecherche2.getString("status");
						System.out.println(desc2);
						System.out.println(ut.getMdp());
			}
			if(ut.getMdp().equals(desc)) {
				co2 = desc2;
			}
			else {
				co2 = "";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(co2);
		return co2;
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
		String re3 = "INSERT INTO utilisateur (nom , prenom, mail, mdp, status, etatCompte) VALUES ('" + ajut.getNom() + "','"+ajut.getPrenom() +"','"+ajut.getMail() +"','"+ ajut.getMdp() +"', 'patient','1')";
		System.out.println(re3);

		try {
			r1 = stm1.executeUpdate(re3);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("hello");
			e.printStackTrace();
			}
		}
	
	public void AjouterUtilisateurs(String nom, String prenom, String mail, String mdp, String role, boolean etatCompte) throws SQLException {
		String sql = "SELECT * FROM utilisateur WHERE mail = ? LIMIT 1";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, mail);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			System.out.println("Identifiants déjà existants");
		} else {
			String hashedPwd = BCrypt.hashpw(mdp, BCrypt.gensalt(10));
			sql = "INSERT INTO utilisateur(nom, prenom, mail, mdp, role, etatCompte) VALUES(?,?,?,?,?,?)";
		    pstm = this.connexionbdd().prepareStatement(sql);
			pstm.setString(1, nom);
			pstm.setString(2, prenom);
			pstm.setString(3, mail);
			pstm.setString(4, hashedPwd);
			pstm.setString(5, role);
			pstm.setBoolean(6, etatCompte);
			pstm.execute();
			System.out.println("Un nouvel utilisateur a été ajouté");
		}
	}
	
	/*
	public void VerifyOAuth(String mail, String mdp) throws SQLException {
		String sql = "SELECT * FROM utilisateur WHERE mail = ? AND mdp = ? LIMIT 1";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, mail);
		pstm.setString(2, mdp);
		ResultSet rs = pstm.executeQuery();
	    while(rs.next()) {
	    	if(BCrypt.checkpw(mdp, rs.getString("mdp"))) {
	    		System.out.println("Bienvenue");
	    	} else {
	    		System.out.println("Veuillez réessayer ultérieurement");
	    	}
		}
	}
	*/
	
	public void VerifEtatCompte(boolean etatCompte) {
		if(etatCompte) {
			/*
			 * Si l'ï¿½tat du compte vaut 1 alors on redirige l'utilisateur vers la page d'accueil
			 * en fonction de son rôle/status
			 */
			System.out.println("Bienvenue");
		} else {
			System.out.println("Votre compte est dï¿½sactivï¿½. Veuillez contacter l'administrateur");
		}
	}
	
	public void ModifierProfil(int id, String nom, String prenom, String mail) throws SQLException {
		String sql = "SELECT * FROM utilisateur WHERE id = ? LIMIT 1";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			sql = "UPDATE utilisateur SET nom = ?, prenom = ?, mail = ? WHERE id = ?";
			pstm = this.connexionbdd().prepareStatement(sql);
			pstm.setString(1, nom);
			pstm.setString(2, prenom);
			pstm.setString(3, mail);
			pstm.setInt(4, id);
			pstm.execute();
			System.out.println("Profil mis à jour");
		}
	}
	
	public void DesactiverCompte(String mail) throws SQLException {
		String sql = "UPDATE utilisateur SET etatCompte = 0 WHERE mail = ?";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, mail);
		
		int rowUpdated = pstm.executeUpdate();
		if(rowUpdated > 0) {
			System.out.println("Compte désactivé");
		} else {
			System.out.println("Erreur");
		}
	}
	
	public void ReactiverCompte(String mail) throws SQLException {
		String sql = "UPDATE utilisateur SET etatCompte = 1 WHERE mail = ?";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, mail);
		
		int rowUpdated = pstm.executeUpdate();
		if(rowUpdated > 0) {
			System.out.println("Le compte a été réactivé");
		} else {
			System.out.println("Une erreur est survenue lors de la requête de réactivation");
		}
	}
	
	public ArrayList<ArrayList> LesMedicaments() throws SQLException {
		String sql = "SELECT * FROM medicaments";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		ArrayList<ArrayList> laListeMedic = new ArrayList<ArrayList>();
		while(rs.next()) {
			ArrayList<Object> listeMedicaments = new ArrayList<Object>();
			listeMedicaments.add(rs.getString("nomMedicament"));
			listeMedicaments.add(rs.getInt("quantite"));
			listeMedicaments.add(rs.getString("toxicite"));
			laListeMedic.add(listeMedicaments);
		}
		return laListeMedic;
	}
	
	public void AjouterMedicaments(String nomMedicament, int quantite, String toxicite) throws SQLException {
		String sql = "SELECT nomMedicament FROM medicaments WHERE nomMedicament = ?";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, nomMedicament);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			System.out.println("Le produit de ce nom a déjà été ajouté dans la base de données");
		} else {
			sql = "INSERT INTO medicaments(nomMedicament, quantite, toxicite) VALUES(?,?,?)";
			pstm = this.connexionbdd().prepareStatement(sql);
			pstm.setString(1, nomMedicament);
			pstm.setInt(2, quantite);
			pstm.setString(3, toxicite);
			pstm.execute();
			System.out.println("Ajout du médicament effectué avec succès");
		}
	}
	
	public void MajMedicaments(String nomMedicament, int quantite) throws SQLException {
		String sql = "SELECT * FROM medicaments WHERE nomMedicament = ?";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, nomMedicament);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			int total = rs.getInt("quantite");
			sql = "UPDATE medicaments SET quantite = ? WHERE nomMedicament = ?";
			pstm = this.connexionbdd().prepareStatement(sql);
			pstm.setInt(1, total + quantite);
			pstm.setString(2, nomMedicament);
			pstm.execute();
			System.out.println("Mise à jour du produit effectuée avec succès");
		}
	}
	
	public void SupprimerMedicaments(String nomMedicament) throws SQLException {
		String sql = "DELETE FROM medicaments WHERE nomMedicament = ?";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, nomMedicament);
		
		int rowExpunged = pstm.executeUpdate();
		System.out.println("Le produit a bel et bien été supprimé");
	}
	
	/*
	public void ExporterMedicaments() throws SQLException {
		ArrayList<Medicaments> listeMedicaments = new ArrayList<Medicaments>();
		String sql = "SELECT * FROM medicaments";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			Medicaments medic = new Medicaments(rs.getInt("id"), rs.getString("nomMedicament"), rs.getInt("quantite"), rs.getString("toxicite"));
		}
		FileWriter file = null;
		try {
			file = new FileWriter("Liste des médicaments.csv");
			file.append(HEADER);
			file.append(SEPARATOR);
			
			for(Medicaments m : listeMedicaments) {
				file.append(m.getNomMedicament());
				file.append(DELIMITER);
				file.append(String.valueOf(m.getQuantite()));
				file.append(DELIMITER);
				file.append(m.getToxicite());
				file.append(SEPARATOR);
			}
			file.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	public void LesUtilisateurs() throws SQLException {
		String sql = "SELECT nom, prenom, mail, role FROM utilisateur";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			ArrayList<Object> listeUtilisateurs = new ArrayList<Object>();
			listeUtilisateurs.add(rs.getString("nom"));
			listeUtilisateurs.add(rs.getString("prenom"));
			listeUtilisateurs.add(rs.getString("mail"));
			listeUtilisateurs.add(rs.getString("role"));
			
			for(int i = 0; i < listeUtilisateurs.size(); i++) {
				System.out.println(listeUtilisateurs.get(i));
			}
		}
	}
	
	public void informationsupp(Patient dopt) {
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm1 = null;
		try {
			stm1 = co_bdd.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		String re4 = "INSERT INTO patient (mutuelle, telephone, securitesocial) VALUES ('" + dopt.getMutuelle() + "','"+dopt.getTelephone() +"','"+dopt.getSecuriteSocial() +"')";
		System.out.println(re4);

		try {
			r1 = stm1.executeUpdate(re4);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("hello");
			e.printStackTrace();
			}
		
	}

	public void AjouterPatient(String nomPatient, String prenomPatient, String telephone, String adresse, String mutuelle, String idSecuriteSocial) throws SQLException {
		String sql = "SELECT * FROM patient WHERE id_patient = ? LIMIT 1";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, idSecuriteSocial);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			System.out.println("Les informations du patient que vous avez saisies ont déjà été enregistrées");
		} else {
			sql = "INSERT INTO patient(nomPatient, prenomPatient, telephone, adresse, mutuelle, idSecuriteSocial) VALUES(?,?,?,?,?,?)";
			pstm = this.connexionbdd().prepareStatement(sql);
			pstm.setString(1, nomPatient);
			pstm.setString(2, prenomPatient);
			pstm.setString(3, telephone);
			pstm.setString(4, adresse);
			pstm.setString(5, mutuelle);
			pstm.setString(6, idSecuriteSocial);
			int addedRow = pstm.executeUpdate();
			System.out.println("Les informations du patient ont bien été enregistrées");
		}
	}
	
	public ArrayList<String> recupuser() {
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;
		try {
			stm = co_bdd.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql ="SELECT id, nom From utilisateur where status = 'patient' ";
		System.out.println(sql);
		ArrayList<String> liste = new ArrayList<>();
		try{
			ResultSet resultatrecherche = stm.executeQuery(sql);
			while(resultatrecherche.next()) {
				liste.add(resultatrecherche.getString("nom"));
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return liste;

	}
	
	public ArrayList<String> recupmedecin() {
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;
		try {
			stm = co_bdd.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql ="SELECT id, nom From medecin";
		System.out.println(sql);
		ArrayList<String> liste = new ArrayList<>();
		try{
			ResultSet resultatrecherche = stm.executeQuery(sql);
			while(resultatrecherche.next()) {
				liste.add(resultatrecherche.getString("nom"));
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return liste;

	}
	
	public ArrayList<String> recupheure() {
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;
		try {
			stm = co_bdd.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql ="SELECT id, libelle From heure";
		System.out.println(sql);
		ArrayList<String> liste = new ArrayList<>();
		try{
			ResultSet resultatrecherche = stm.executeQuery(sql);
			while(resultatrecherche.next()) {
				liste.add(resultatrecherche.getString("libelle"));
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return liste;

	}
	public void UpdateVerifMdp(String mail, int verifmdp) throws SQLException {
		String sql = "UPDATE utilisateur SET verificationmdp = ? WHERE mail = ?";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setInt(1, verifmdp);
		pstm.setString(2, mail);
		
		int rowExpunged = pstm.executeUpdate();
		System.out.println("Le produit a bel et bien été supprimé");
	}
	
	
public String getMdpVerif(String mail, String nombre, String nouveauMdp) {
		
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;
		try {
			stm = co_bdd.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		String re2 = "SELECT verificationmdp FROM utilisateur WHERE mail = '" + mail + "'";
		System.out.println(re2);
		try {
			ResultSet resultatrecherche = stm.executeQuery(re2);
			while(resultatrecherche.next()){
				// Aﬃchage des lignes qui comporte les caractères de "recherche"
				desc = resultatrecherche.getString("verificationmdp");
				System.out.println(desc);
				System.out.println(nombre);
				System.out.println(nouveauMdp);
				System.out.println(mail);
			}
			if(nombre.equals(desc)) {
				String sql = "UPDATE utilisateur SET mdp = ? WHERE mail = ?";
				PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
				pstm.setString(1, nouveauMdp);
				pstm.setString(2, mail);
				int rowExpunged = pstm.executeUpdate();
				co2 = "1";
			}
			else {
				co2 = "0";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(co2);
		return co2;
	}
	
}






