package Model;

public class CommandeMedicaments {
	private int id;
	private int idInfirmiere;
	private String nomMedicament;
	private int nombre;
	private text libelle;
	
	CommandeStock(int id, int idInfirmiere, String nomMedicament, int nombre, text libelle) {
		this.id = id;
		this.idInfirmiere = idInfirmiere;
		this.nomMedicament = nomMedicament;
		this.nombre = nombre;
		this.libelle = libelle;
	}
	
	public int getId() {return this.id;}
	public void setId(int id) {this.id = id;}
	public int idInfirmiere() {return this.idInfirmiere;}
	public void setIdInfirmiere(int idInfirmiere) {this.idInfirmiere = idInfirmiere;}
	public text getNomMedicament() {return this.nomMedicament;}
	public void setNomMedicament(String nomMedicament) {this.nomMedicament = nomMedicament;}
	public int getNombre() {return this.nombre;}
	public void setNombre(int nombre) {this.nombre = nombre;}
	public text getLibelle() {return this.libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}
	
}
