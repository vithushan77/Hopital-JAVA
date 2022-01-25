package Model;

public class TraitementPatient {
	private int id;
	private int idInfirmiere;
	private int idPatient;
	private String prescription;
	
	TraitementPatient(int id, int idInfirmiere, int idPatient, String prescription) {
		this.id = id;
		this.idInfirmiere = idInfirmiere;
		this.idPatient = idPatient;
		this.prescription = prescription;
	}
	
	public int getId() {return this.id;}
	public void setId(int id) {this.id = id;}
	public int getIdInfirmiere() {return this.idInfirmiere;}
	public void setIdInfirmiere(int idInfirmiere) {this.idInfirmiere = idInfirmiere;}
	public int idPatient() {return this.idPatient;}
	public void setIdPatient(int idPatient) {this.idPatient = idPatient;}
	public String prescription() {return this.prescription;}
	public void prescription(String prescrition) {this.prescription = prescrition;}
}
