package Model;

public class Chambres {
	
	private int id;
	private int numeroChambre;
	
	public Chambres(int id, int numeroChambre) {
		this.id = id;
		this.numeroChambre = numeroChambre;
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
	
	
}
