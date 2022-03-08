package Model;

import java.sql.Date;

public class CommandeStock {
	private int id;
	private int idGestionnaire;
	private int id_medicament;
	private int nombreStock;
	private Date dateCommande;
	private String libelle;
	
	public CommandeStock(int id, int idGestionnaire, int id_medicament, int nombreStock, Date dateCommande,
			String libelle) {
		super();
		this.id = id;
		this.idGestionnaire = idGestionnaire;
		this.id_medicament = id_medicament;
		this.nombreStock = nombreStock;
		this.dateCommande = dateCommande;
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdGestionnaire() {
		return idGestionnaire;
	}

	public void setIdGestionnaire(int idGestionnaire) {
		this.idGestionnaire = idGestionnaire;
	}

	public int getId_medicament() {
		return id_medicament;
	}

	public void setId_medicament(int id_medicament) {
		this.id_medicament = id_medicament;
	}

	public int getNombreStock() {
		return nombreStock;
	}

	public void setNombreStock(int nombreStock) {
		this.nombreStock = nombreStock;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
}
