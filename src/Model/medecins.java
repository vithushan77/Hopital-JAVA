package Model;

public class medecins {
	private int id;
	private String nom;
	private String prenom;
	private String specialite;
	
	public medecins(int id, String nom, String prenom, String specialite) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.specialite = specialite;
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

	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}
	
	@Override
	public String toString() {
		return this.id +" Dr." + nom + " " + prenom + "";
	}
	
	
}
