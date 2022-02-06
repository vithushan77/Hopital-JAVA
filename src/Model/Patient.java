package Model;

public class Patient {
	private int id;
	private String nomPatient;
	private String prenomPatient;
	private String telephone;
	private String adresse;
	private String mutuelle;
	private String SecuriteSocial;
	
	public Patient(int id, String nomPatient, String prenomPatient, String telephone, String adresse, String mutuelle,
			String securiteSocial) {
		this.id = id;
		this.nomPatient = nomPatient;
		this.prenomPatient = prenomPatient;
		this.telephone = telephone;
		this.adresse = adresse;
		this.mutuelle = mutuelle;
		SecuriteSocial = securiteSocial;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomPatient() {
		return nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}

	public String getPrenomPatient() {
		return prenomPatient;
	}

	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMutuelle() {
		return mutuelle;
	}

	public void setMutuelle(String mutuelle) {
		this.mutuelle = mutuelle;
	}

	public String getSecuriteSocial() {
		return SecuriteSocial;
	}

	public void setSecuriteSocial(String securiteSocial) {
		SecuriteSocial = securiteSocial;
	}
	

}
