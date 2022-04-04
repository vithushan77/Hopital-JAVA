


package Manager;

import java.awt.Container;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import org.springframework.security.crypto.bcrypt.BCrypt;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import Model.Patient;
import Model.Chambres;
import Model.Medicaments;
import Model.Utilisateur;
import Model.Administrateur;
import Vue.Affiche_medecins;
import Model.Patient;

public class Manager {
	private int r1;
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
	private static final String HEADER = "Id, Nom, Quantite, Toxicite";

	public Connection connexionbdd (){
		Connection cnx = null;
		String url="jdbc:mysql://localhost:8889/hopital_java?serverTimezone=UTC";
		String user="root";
		String password="root";
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

	public boolean VerifyOAuth(String mail, String mdp) throws SQLException {
		String sql = "SELECT mdp FROM utilisateur WHERE mail = ? LIMIT 1";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, mail);
		ResultSet rs = pstm.executeQuery();
		boolean match = false;
	    while(rs.next()) {
	    	match = BCrypt.checkpw(mdp, rs.getString("mdp"));
		}
	    return match;
	}

	public boolean VerifEtatCompte(String mail) throws SQLException{
		String sql = "SELECT etatCompte FROM utilisateur WHERE mail = ? LIMIT 1";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, mail);
		ResultSet rs = pstm.executeQuery();
		boolean accountStatus = false;
		while(rs.next()) {
			/*Comme l'attribut etatCompte est de type booléen
			 * On vérifie si le compte  de l'utilisateur est activé ou non*/
			accountStatus = rs.getBoolean("etatCompte");
		}
		return accountStatus;
	}
	
	public void SupprimerProfil(int id) throws SQLException {
		/*La suppression du profil ne peut être effectuée si, et seulement si, un salarié licencié ou un patient en fait la demande*/
		String sql = "DELETE FROM utilisateur WHERE id = ?";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setInt(1, id);
		pstm.execute();
		System.out.println("Compte supprimé");
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

	public void ModifierMdp(String mdp, String mail) throws SQLException {
		try {
			String hashedPwd = BCrypt.hashpw(mdp, BCrypt.gensalt(10));
			String sql = "UPDATE utilisateur SET mdp = ? WHERE mail = ? LIMIT 1";
			PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
			pstm.setString(1, hashedPwd);
			pstm.setString(2, mail);
			int rowUpdated = pstm.executeUpdate();
			System.out.println("Mot de passe modifié avec succès");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void getModification(int id) throws SQLException {
		String sql = "SELECT nom, prenom, mdp, mail, role FROM utilisateur WHERE id = ?";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			ArrayList<Object> profilModifie = new ArrayList<Object>();
			profilModifie.add(rs.getString("nom"));
			profilModifie.add(rs.getString("prenom"));
			profilModifie.add(rs.getString("mail"));
			profilModifie.add(rs.getString("mdp"));
			profilModifie.add(rs.getString("role"));

			for(int i = 0; i < profilModifie.size(); i++) {
				System.out.println(profilModifie.get(i));
			}
		}
	}

	public void DesactiverCompte(String mail) throws SQLException {
		String sql = "UPDATE utilisateur SET etatCompte = 0 WHERE mail = ?";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, mail);
		int rowUpdated = pstm.executeUpdate();
		System.out.println("Compte désactivé");
	}

	public void ReactiverCompte(String mail) throws SQLException {
		String sql = "UPDATE utilisateur SET etatCompte = 1 WHERE mail = ?";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, mail);
		int rowUpdated = pstm.executeUpdate();
		System.out.println("Le compte a été réactivé");
	}

	public void CommandeStock(int idGestionnaire, int id_medicament, int nombreStock, String libelle) throws SQLException {
		String sql = "INSERT INTO commande_stock(idGestionnaire, id_medicament, nombreStock, dateCommande, libelle) VALUES(?,?,?,CURDATE(),?)";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setInt(1, idGestionnaire);
		pstm.setInt(2, id_medicament);
		pstm.setInt(3,  nombreStock);
		pstm.setString(4, libelle);
		pstm.execute();
		System.out.println("Commande enregistrée");
	}

	public ArrayList<ArrayList> LesMedicaments() throws SQLException {
		String sql = "SELECT * FROM medicaments";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		ArrayList<ArrayList> laListeMedic = new ArrayList<ArrayList>();
		while(rs.next()) {
			ArrayList<Object> listeMedicaments = new ArrayList<Object>();
			listeMedicaments.add(rs.getInt("id"));
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

	public void CommandeMedicaments(String nomMedicament, int quantite) throws SQLException {
		/*
		 * Gestion de commande de stock de médicaments pour les infirmières
		 */
		String sql = "SELECT * FROM medicaments WHERE nomMedicament = ?";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, nomMedicament);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			int total = rs.getInt("quantite");
			sql = "UPDATE medicaments SET quantite = ? WHERE nomMedicament = ?";
			pstm = this.connexionbdd().prepareStatement(sql);
			pstm.setInt(1, total - quantite);
			pstm.setString(2, nomMedicament);
			pstm.execute();
			System.out.println("Commande effectuée");
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
			file = new FileWriter("Liste des médicaments.txt");
			file.append(HEADER);
			file.append(SEPARATOR);

			for(Medicaments m : listeMedicaments) {
				file.append(String.valueOf((m.getId())));
				file.append(DELIMITER);
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
		return listeMedicaments;
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

	public void AjouterPatient(int id_patient, String nomPatient, String prenomPatient, String telephone, String adresse, String mutuelle, String SecuriteSocial) throws SQLException {
		String sql = "SELECT * FROM patient WHERE id_patient = ? LIMIT 1";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setInt(1, id_patient);
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
			pstm.setString(6, SecuriteSocial);
			int addedRow = pstm.executeUpdate();
			System.out.println("Les informations du patient ont bien été enregistrées");
		}
	}

	public void AjouterMedecins(String nom, String prenom, String specialite) throws SQLException {
		String sql = "SELECT * FROM medecins WHERE prenom = ? LIMIT 1";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, prenom);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			System.out.println("Le médecin que vous voulez ajouter a déjà été enregistré");
		} else {
			sql = "INSERT INTO medecins(nom, prenom, specialite) VALUES(?,?,?)";
			pstm = this.connexionbdd().prepareStatement(sql);
			pstm.setString(1, nom);
			pstm.setString(2, prenom);
			pstm.setString(3, specialite);
			int addedRow = pstm.executeUpdate();
			System.out.println("Les informations ont bien été enregistrées");
		}
	}

	public ArrayList<ArrayList>LesMedecins() throws SQLException {
		ArrayList<ArrayList> listeMedecins = new ArrayList<ArrayList>();
		String sql = "SELECT * FROM medecins";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while(rs.next()) {
			ArrayList<Object> leMedecin = new ArrayList<Object>();
			leMedecin.add(rs.getInt("id"));
			leMedecin.add(rs.getString("nom"));
			leMedecin.add(rs.getString("prenom"));
			leMedecin.add(rs.getString("specialite"));
			listeMedecins.add(leMedecin);
		}
		return listeMedecins;
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


	public ArrayList<Medicaments> recumpmed(){
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;
		try {
			stm = co_bdd.createStatement();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql= "SELECT * From medicaments";
		System.out.println(sql);
		ArrayList<Medicaments>listemedocs = new ArrayList<>();
		try {
			ResultSet resultatrecherchemedoc = stm.executeQuery(sql);
			while(resultatrecherchemedoc.next()){
				listemedocs.add(new Medicaments(
						resultatrecherchemedoc.getInt("id"),
						resultatrecherchemedoc.getString("nomMedicament"),
						resultatrecherchemedoc.getInt("quantite"),
						resultatrecherchemedoc.getString("toxicite")));
				//listepati.add(resultatrecherchepati.getString("Nom"));

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listemedocs;
	}

	public ArrayList<String>recupcham(){
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

	public ArrayList<String>medecins(){
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;
		try {
			stm = co_bdd.createStatement();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql= "SELECT id, nom FROM medecin";
		System.out.println(sql);
		ArrayList<String>listemed = new ArrayList<>();
		try {
			ResultSet resultatrecherchemed = stm.executeQuery(sql);
			while(resultatrecherchemed.next()){
				listemed.add(resultatrecherchemed.getString("nom"));

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return listemed;
	}

	public ArrayList<String>heure(){
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;
		try {
			stm = co_bdd.createStatement();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql= "SELECT id, libelle FROM heure";
		System.out.println(sql);
		ArrayList<String>listeheure = new ArrayList<>();
		try {
			ResultSet resultatrechercheheure = stm.executeQuery(sql);
			while(resultatrechercheheure.next()){
				listeheure.add(resultatrechercheheure.getString("libelle"));

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return listeheure;
	}

	public ArrayList<Object[]> hospitalisation(){
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;

		ArrayList<Object[]> hospitalisations = new ArrayList<>();
		try {
			stm = co_bdd.createStatement();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql= "SELECT * FROM hospitalisation \n"
				+ "INNER JOIN chambres on hospitalisation.id_chambre = chambres.id "
				+ "INNER JOIN patient on hospitalisation.id_patient = patient.id INNER JOIN medicaments on hospitalisation.id_medicament = medicaments.id";


		ResultSet res;
		try {
			res = stm.executeQuery(sql);
			while(res.next()) {
				int id = res.getInt("id");
				String Nom = res.getString("Nom");
				String Prenom = res.getString("Prenom");
				int numeroChambre = res.getInt("numeroChambre");
				String choix = res.getString("choix");
				String nomMedicament = res.getString("nomMedicament");


				Object[] data = {id, Nom, Prenom,numeroChambre,choix,nomMedicament};
				Object hospitalisation;
				hospitalisations.add(data);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		return hospitalisations;

	}


	public ArrayList<Patient> recupatients(){
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;
		try {
			stm = co_bdd.createStatement();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql= "SELECT * From patient";
		System.out.println(sql);
		
		ArrayList<Patient>listepati = new ArrayList<>();
		try {
			ResultSet resultatrecherchepati = stm.executeQuery(sql);
			while(resultatrecherchepati.next()){
				listepati.add(new Patient(
						resultatrecherchepati.getInt("id"),
						resultatrecherchepati.getString("Nom"),
						resultatrecherchepati.getString("Prenom"),
						resultatrecherchepati.getString("Nom"),
						resultatrecherchepati.getString("Nom"),
						sql,
						sql));
				//listepati.add(resultatrecherchepati.getString("Nom"));

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return listepati;
	}

	public ArrayList<Chambres> recuchambres(){
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;
		try {
			stm = co_bdd.createStatement();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql= "SELECT * From chambres";
		System.out.println(sql);
		ArrayList<Chambres>listecham = new ArrayList<>();
		try {
			ResultSet resultatrecherchechamb = stm.executeQuery(sql);
			while(resultatrecherchechamb.next()){
				listecham.add(new Chambres(
						resultatrecherchechamb.getInt("id"),
						resultatrecherchechamb.getInt("numeroChambre"),
						resultatrecherchechamb.getString("choix")
						));
				//listepati.add(resultatrecherchepati.getString("Nom"));

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}

		return listecham;
	}


	public void ajouthospit(int i, int j, int l) throws SQLException {
		// TODO Auto-generated method stub
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm1 = null;
		try {
			stm1 = co_bdd.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql1 = "SELECT * FROM hospitalisation WHERE id_patient = ? LIMIT 1";
		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql1);
		pstm.setInt(1, i);
		ResultSet rs = pstm.executeQuery();
		if(rs.next()) {
			System.out.println("Le Patient séléctionner est deja assigner dans une chambre");
		} else {

			String sql= "INSERT INTO hospitalisation (id, id_patient, id_chambre, id_medicament) VALUES (null,"+i+ ", "+j +","+l+")";
			System.out.println(sql);
			try {
				r1 = stm1.executeUpdate(sql);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//System.out.println("hello");
				e.printStackTrace();
			}

		}
	}


	public ArrayList<Object[]> utilisateurs(){
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;

		ArrayList<Object[]> utilisateurs = new ArrayList<>();
		try {
			stm = co_bdd.createStatement();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql= "SELECT * FROM utilisateur";
		ResultSet res;
		try {
			res = stm.executeQuery(sql);
			while(res.next()) {

				String Nom = res.getString("Nom");
				String Prenom = res.getString("Prenom");
				String Mail = res.getString("mail");
				int etatCompte = res.getInt("etatCompte");
				String Status = res.getString("status");

				Object[] data = {Nom, Prenom,Mail,Status};
				Object utilisateur;
				utilisateurs.add(data);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	return utilisateurs;

	}

	public void inscriptionadmin(Administrateur adm){
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm1 = null;
		try {
			stm1 = co_bdd.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String re3 = "INSERT INTO utilisateur (nom , prenom, mail, mdp, status, etatCompte) VALUES ('" + adm.getNom() + "','"+adm.getPrenom() +"','"+adm.getMail() +"','"+ adm.getMdp() +"', 'administrateur','1')";
		System.out.println(re3);

		try {
			r1 = stm1.executeUpdate(re3);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("hello");
			e.printStackTrace();
			}
		}

	public void inscriptionutilisateur(Administrateur adm, Object data){
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm1 = null;
		try {
			stm1 = co_bdd.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String re3 = "INSERT INTO utilisateur (nom , prenom, mail, mdp, status, etatCompte) VALUES ('" + adm.getNom() + "','"+adm.getPrenom() +"','"+adm.getMail() +"','"+ adm.getMdp() +"', '"+ data +"','1')";
		System.out.println(re3);

		try {
			r1 = stm1.executeUpdate(re3);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//System.out.println("hello");
			e.printStackTrace();
			}
		}


	public  Utilisateur getUtilisateurInfo(Object data){
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;
		Utilisateur ut = null;
		String aze = "aze";
		try {
			stm = co_bdd.createStatement();
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		String sql= "SELECT * FROM utilisateur WHERE mail = '" + data + "'";
		ResultSet res;
		try {
			res = stm.executeQuery(sql);
			while(res.next()) {
				int id = res.getInt("id");
				String Nom = res.getString("Nom");
				String Prenom = res.getString("Prenom");
				String Mail = res.getString("mail");
				String Mdp = res.getString("mdp");
				int etatCompte = res.getInt("etatCompte");
				String Status = res.getString("status");

				ut = new Utilisateur(id, Nom, Prenom, Mdp, Mail, Status);
				ut.setId(id);
				ut.setNom(Nom);
				ut.setPrenom(Prenom);
				ut.setMdp(Mdp);
				ut.setMail(Mail);
				ut.setStatus(Status);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return ut;

	}

	public ArrayList<String> alluser() {
		Connection co_bdd = this.connexionbdd();
		java.sql.Statement stm = null;
		try {
			stm = co_bdd.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql ="SELECT id, mail From utilisateur";
		System.out.println(sql);
		ArrayList<String> liste = new ArrayList<>();
		try{
			ResultSet resultatrecherche = stm.executeQuery(sql);
			while(resultatrecherche.next()) {
				liste.add(resultatrecherche.getString("mail"));
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		return liste;

	}

	public void updateActiver(String mail) throws SQLException {

			String sql = "UPDATE utilisateur SET etatCompte = ? WHERE mail = ?";
			Object pstm = this.connexionbdd().prepareStatement(sql);
			((PreparedStatement) pstm).setInt(1, 1);
			((PreparedStatement) pstm).setString(2, mail);
			((PreparedStatement) pstm).execute();
			System.out.println("ACTIVER");
		}

	public void updateDesactiver(String mail) throws SQLException {

		String sql = "UPDATE utilisateur SET etatCompte = ? WHERE mail = ?";
		Object pstm = this.connexionbdd().prepareStatement(sql);
		((PreparedStatement) pstm).setInt(1, 0);
		((PreparedStatement) pstm).setString(2, mail);
		((PreparedStatement) pstm).execute();
		System.out.println("DESACTIVER");
	}

public void updateProfil(String mail, String motdepasse, String nom, String prenom, Object status) throws SQLException {

		String sql = "UPDATE utilisateur SET nom = ?, mail = ?, prenom = ?, mdp = ?, status = ? WHERE mail = ?";
		System.out.println(sql);
		System.out.println(mail);
		System.out.println(prenom);
		System.out.println(nom);
		System.out.println(status);
		System.out.println(motdepasse);

		PreparedStatement pstm = this.connexionbdd().prepareStatement(sql);
		pstm.setString(1, nom);
		pstm.setString(2, mail);
		pstm.setString(3, prenom);
		pstm.setString(4, motdepasse);
		pstm.setObject(5, status);
		pstm.setString(6, mail);
		pstm.execute();
		System.out.println("MODIFIER");
	}

public ArrayList<Object[]> doctor(){
	Connection co_bdd = this.connexionbdd();
	java.sql.Statement stm = null;

	ArrayList<Object[]> doctors = new ArrayList<>();
	try {
		stm = co_bdd.createStatement();
	}
	catch (SQLException e1) {
		e1.printStackTrace();
	}
	String sql= "SELECT * FROM medecin";
	ResultSet res;
	try {
		res = stm.executeQuery(sql);
		while(res.next()) {
			int id = res.getInt("id");
			String nom = res.getString("nom");
			String specialité = res.getString("specialité");


			Object[] data = {id, nom, specialité};
			Object doctor;
			doctors.add(data);
		}

	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}



	return doctors;

}
	}
