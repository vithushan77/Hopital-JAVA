package Model;

public class RDV {
	private int id;
	private int idPatient;
	private int idAdministratif;
	private String libelle;
	
	RDV(int id, int idPatient, int idAdministratif, String libelle){
		this.id = id;
		this.idPatient = idPatient;
		this.idAdministratif = idAdministratif;
		this.libelle = libelle;
	}
		
		public int getId() {return this.id;}
		public void setId(int id) {this.id = id;}
		public int getIdPatient() {return this.idPatient;}
		public void setIdPatient(int idPatient) {this.idPatient = idPatient;}
		public int idAdministratif() {return this.idAdministratif;}
		public void setIdAdminstratif(int idAdministratif) {this.idAdministratif = idAdministratif;}
		public String libelle() {return this.libelle;}
		public void libelle(String libelle) {this.libelle = libelle;}
}
