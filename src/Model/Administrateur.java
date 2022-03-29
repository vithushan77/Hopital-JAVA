package Model;

public class Administrateur {

		private int id;
		private String nom;
		private String prenom;
		private String mail;
		private String mdp;
		private String status;
		private boolean etatCompte;

		public Administrateur(int id, String nom, String prenom, String mail, String mdp, String status) {
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.mail = mail;
			this.mdp = mdp;
			this.status = status;
		}


		public int getId() {
			return this.id;
			}

		public void setId(int id) {
			this.id = id;
			}

		public String getNom() {
			return this.nom;
			}

		public void setNom(String nom) {
			this.nom = nom;
			}

		public String getPrenom() {
			return this.prenom;
			}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
			}

		public String getMail() {
			return this.mail;
			}

		public void setMail(String mail) {
			this.mail = mail;
			}

		public String getMdp() {
			return this.mdp;
			}

		public void setMdp(String mdp) {
			this.mdp = mdp;
			}

		public String getStatus() {
			return this.status;
			}


		public void setStatus(String status) {
			this.status = status;
			}


	}