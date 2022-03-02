package Model;

public class Chambres {
	
	private int id;
	private int numeroChambre;
	private String choix;
	
	public Chambres(int id, int numeroChambre, String choix) {
		this.id = id;
		this.numeroChambre = numeroChambre;
		this.choix= choix;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumeroChambre() {
		return numeroChambre;
	}

	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}

	public String getChoix() {
		return choix;
	}

	public void setChoix(String choix) {
		this.choix = choix;
	}
	public String toString() {
		return "N° " + numeroChambre + "  Contient " + choix + "";
	}
	
	
}
