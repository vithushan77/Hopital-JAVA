package Model;

public class Utilisateur {
	private int id;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;
	private String status;
	private Boolean etatCompte;
	
	public Utilisateur(int id, String nom, String prenom, String mail, String mdp, String status, Boolean etatCompte) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.status = status;
		this.etatCompte = etatCompte;
	}

	public int getId() {
		return this.id;
		}
	
	public void setId(int id) {
		this.id = id;
		}
	
	public String getNom() {
		return this.nom;
		}
	
	public void setNom(String nom) {
		this.nom = nom;
		}
	
	public String getPrenom() {
		return this.prenom;
		}
	
	public void setPrenom(String prenom) {
		this.prenom = prenom;
		}
	
	public String getMail() {
		return this.mail;
		}
	
	public void setMail(String mail) {
		this.mail = mail;
		}
	
	public String getMdp() {
		return this.mdp;
		}
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
		}
	
	public String getStatus() {
		return this.status;
		}
	

	public void setStatus(String status) {
		this.status = status;
		}
	
	public Boolean getEtatCompte() {
		
	
		return this.etatCompte;
		}
	
	public void setEtatCompte(Boolean etatCompte) {
		this.etatCompte = etatCompte;
		}
	
}
	
