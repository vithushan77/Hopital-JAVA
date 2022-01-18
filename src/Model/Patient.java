package Model;

public class Patient {
	private int id_patient;
	private String nomPatient;
	private String prenomPatient;
	private String mutuelle;
	private int idSecuriteSocial;
	
	Patient(int id_patient, String nomPatient, String prenomPatient, String mutuelle, int idSecuriteSocial) {
		this.id_patient = id_patient;
		this.nomPatient = nomPatient;
		this.prenomPatient = prenomPatient;
		this.mutuelle = mutuelle;
		this.idSecuriteSocial = idSecuriteSocial;
	}
	
	public int getId() {return this.id_patient;}
	public void setId(int id) {this.id_patient = id_patient;} 
	public String getNomPatient() {return this.nomPatient;}
	public void setNomPatient(String nomPatient) {this.nomPatient = nomPatient;}
	public String getPrenomPatient() {return this.nomPatient;}
	public void setPrenomPatient(String prenomPatient) {this.prenomPatient = prenomPatient;}
	public String getMutuelle() {return this.mutuelle;}
	public void setMutuelle(String mutuelle) {this.mutuelle = mutuelle;}
	public int getIdSecuriteSocial() {return this.idSecuriteSocial;}
	public void setId(int idSecuriteSocial) {this.idSecuriteSocial = idSecuriteSocial;}
	
}
