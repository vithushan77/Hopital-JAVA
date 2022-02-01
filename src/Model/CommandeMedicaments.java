package Model;

public class CommandeMedicaments {
	private int id;
	private int idInfirmiere;
	private String nomMedicament;
	private int nombre;
	private String libelle;
	

	public CommandeMedicaments(int id, int idInfirmiere, String nomMedicament, int nombre, String libelle) {
		super();
		this.id = id;
		this.idInfirmiere = idInfirmiere;
		this.nomMedicament = nomMedicament;
		this.nombre = nombre;
		this.libelle = libelle;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdInfirmiere() {
		return idInfirmiere;
	}


	public void setIdInfirmiere(int idInfirmiere) {
		this.idInfirmiere = idInfirmiere;
	}


	public String getNomMedicament() {
		return nomMedicament;
	}


	public void setNomMedicament(String nomMedicament) {
		this.nomMedicament = nomMedicament;
	}


	public int getNombre() {
		return nombre;
	}


	public void setNombre(int nombre) {
		this.nombre = nombre;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	
}
