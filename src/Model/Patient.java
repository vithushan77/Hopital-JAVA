package Model;

public class Patient {
	private int id;
	private String nomPatient;
	private String prenomPatient;
	private String telephone;
	private String adresse;
	private String mutuelle;
	private String idSecuriteSocial;

	public Patient(int id, String nomPatient, String prenomPatient, String telephone, String adresse, String mutuelle,
			String idSecuriteSocial) {
		this.id = id;
		this.nomPatient = nomPatient;
		this.prenomPatient = prenomPatient;
		this.telephone = telephone;
		this.adresse = adresse;
		this.mutuelle = mutuelle;
		this.SecuriteSocial = securiteSocial;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomPatient() {
		return this.nomPatient;
	}

	public void setNomPatient(String nomPatient) {
		this.nomPatient = nomPatient;
	}

	public String getPrenomPatient() {
		return this.prenomPatient;
	}

	public void setPrenomPatient(String prenomPatient) {
		this.prenomPatient = prenomPatient;
	}

	public String getTelephone() {
		return this.telephone;
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

	public void setString(String SecuriteSocial) {
		this.SecuriteSocial = SecuriteSocial;
		}



	public void setSecuriteSocial(String securiteSocial) {
		SecuriteSocial = securiteSocial;
	}


}
