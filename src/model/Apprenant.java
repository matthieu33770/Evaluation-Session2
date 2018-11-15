package model;

import java.sql.Date;

public class Apprenant {

		private int id;		
		private String prenom;
		private String nom;
		private String naissance;
		private String email;
		private String photo;
		private int region;
		
		public Apprenant() {
			super();
		}

		public Apprenant(int id, String prenom, String nom, String naissance, String email, String photo,
				int region) {
			this.id = id;
			this.prenom = prenom;
			this.nom = nom;
			this.naissance = naissance;
			this.email = email;
			this.photo = photo;
			this.region = region;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getPrenom() {
			return prenom;
		}

		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}

		public String getnaissance() {
			return naissance;
		}

		public void setnaissance(String naissance) {
			this.naissance = naissance;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public int getRegion() {
			return region;
		}

		public void setRegion(int region) {
			this.region = region;
		}

		@Override
		public String toString() {
			return "Apprenant nom : " + nom + ", prenom : " + prenom + ", dateNaissance : " + naissance
					+ ", email : " + email + ", photo : " + photo + ", region : " + region;
		}
		
		public String afficherNomPrenom() {
			return "Apprenant " + nom + " " + prenom;
		}
		
		public String afficheApprenantByRegion() {
			return region + " - " + nom + " " + prenom;
		}
}
