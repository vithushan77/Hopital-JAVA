package Model;

public class Utilisateur {
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private String status;
	private boolean etatCompte;
	
	Utilisateur(int id, String nom, String prenom, String mail, String mdp, String status, boolean etatCompte) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.status = status;
		this.etatCompte = etatCompte;
	}
	
	public int getId() {return this.id;}
	public void setId(int id) {this.id = id;} 
	public String getNom() {return this.nom;}
	public void setNom(String nom) {this.nom = nom;}
	public String getPrenom() {return this.nom;}
	public void setPrenom(String prenom) {this.nom = prenom;}
	public String getMail() {return this.mail;}
	public void setMail(String mail) {this.mail = mail;}
	public String getMdp() {return this.mdp;}
	public void setMdp(String mdp) {this.mdp = mdp;}
	public String getStatus() {return this.status;}
	public void setMail(String status) {this.status = status;}
	public String getEtatCompte() {return this.etatCompte;}
	public void setEtatCompte(String etatCompte) {this.etatCompte = etatCompte;}
	
}
	
