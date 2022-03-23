package Model;

public class medecins {
	
	private int id;
	private String nom;
	private String specialité;
	
	
	
	public medecins(int id, String nom, String specialité) {
		super();
		this.id = id;
		this.nom = nom;
		this.specialité = specialité;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getSpecialité() {
		return specialité;
	}
	public void setSpecialité(String specialité) {
		this.specialité = specialité;
	}
	
	
	@Override
	public String toString() {
		return this.id +" " + nom + " " + specialité + "";
	}

	
}
