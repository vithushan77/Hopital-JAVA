package Model;

public class Chambres {

	private int id;
	private int numeroChambre;
	private String optn;

	public Chambres(int id, int numeroChambre, String optn) {
		this.id = id;
		this.numeroChambre = numeroChambre;
		this.optn= optn;
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
		return optn;
	}

	public void setChoix(String optn) {
		this.optn = optn;
	}
	public String toString() {
		return  this.id+ "N° " + numeroChambre + "  Contient " + optn + "";
	}


}
