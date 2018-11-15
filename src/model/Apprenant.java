package model;

import java.sql.Date;

public class Apprenant {

		private int id;
		private String nom;
		private String prenom;
		private String naissance;
		private String email;
		private String photo;
		private Region region;
		
		public Apprenant() {
			super();
		}

		public Apprenant(int id, String nom, String prenom, String naissance, String email, String photo,
				Region region) {
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
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

		public Region getRegion() {
			return region;
		}

		public void setRegion(Region region) {
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
