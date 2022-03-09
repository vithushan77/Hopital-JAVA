package Model;

public class hopital {


	private int id;
	private String nomPatient;
	private int numeroChambre;

	public hopital(int id, String nomPatient, int numeroChambre) {
		this.id = id;
		this.numeroChambre = numeroChambre;
		this.nomPatient= nomPatient;
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

	public int getNumeroChambre() {
		return numeroChambre;
	}

	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}




}



