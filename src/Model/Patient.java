package Model;

public class Patient {
	private String Telephone;
	private String mutuelle;
	private String SecuriteSocial;



	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
		}
	public String getPrenomPatient() {
		return this.nomPatient;
		}
	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
		}
	public String getMutuelle() {
		return this.mutuelle;
		}
	public void setMutuelle(String mutuelle) {
		this.mutuelle = mutuelle;
		}
	public int getIdSecuriteSocial() {
		return this.SecuriteSocial;
		}
	public void setId(int idSecuriteSocial) {
		this.SecuriteSocial = SecuriteSocial;
		}

}
