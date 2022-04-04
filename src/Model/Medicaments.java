package Model ;

public class Medicaments extends Object{
	private int id;
	private String nomMedicament;
	private int quantite;
	private String toxicite;

	public Medicaments(int id, String nomMedicament, int quantite, String toxicite) {
		this.id = id;
		this.nomMedicament = nomMedicament;
		this.quantite = quantite;
		this.toxicite = toxicite;
	}

	public int getId() {return this.id;}
	public void setId(int id) {this.id = id;}
	public String getNomMedicament() {return this.nomMedicament;}
	public void setNomMedicament(String nomMedicament) {this.nomMedicament = nomMedicament;}
	public int getQuantite() {return this.quantite;}
	public void setQuantite(int quantite) {this.quantite = quantite;}
	public String getToxicite() {return this.toxicite;}
	public void setToxicite(String toxicite) {this.toxicite = toxicite;}

	@Override
	public String toString() {
		return "" + id + " " + nomMedicament + "  " + quantite + "";
	}
	
	
	
	

}
