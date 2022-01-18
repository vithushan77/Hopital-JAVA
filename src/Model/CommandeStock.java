package Model;

public class CommandeStock {
	private int id;
	private int idGestionnaire;
	private int nombreStock;
	private text libelle;
	
	CommandeStock(int id, int idGestionnaire, int nombreStock, text libelle) {
		this.id = id;
		this.idGestionnaire = idGestionnaire;
		this.nombreStock = nombreStock;
		this.libelle = libelle;
	}
	
	public int getId() {return this.id;}
	public void setId(int id) {this.id = id;}
	public int idGestionnaire() {return this.idGestionnaire;}
	public void setIdGestionnaire(int idGestionnaire) {this.idGestionnaire = idGestionnaire;}
	public int getNombreStock() {return this.nombreStock;}
	public void setNombreStock(int nombreStock) {this.nombreStock = nombreStock;}
	public text getLibelle() {return this.libelle;}
	public void setLibelle(String libelle) {this.libelle = libelle;}
	
}
