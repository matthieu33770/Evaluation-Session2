package model;

import javax.xml.crypto.Data;

public class Apprenant {

		private int id;
		private String nom;
		private String prenom;
		private Data dateNaissance;
		private String email;
		private Long photo;
		private Region region;
		
		public Apprenant() {
			super();
		}

		public Apprenant(int id, String nom, String prenom, Data dateNaissance, String email, Long photo,
				Region region) {
			this.id = id;
			this.nom = nom;
			this.prenom = prenom;
			this.dateNaissance = dateNaissance;
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

		public Data getDateNaissance() {
			return dateNaissance;
		}

		public void setDateNaissance(Data dateNaissance) {
			this.dateNaissance = dateNaissance;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Long getPhoto() {
			return photo;
		}

		public void setPhoto(Long photo) {
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
			return "Apprenant nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
					+ ", email=" + email + ", photo=" + photo + ", region=" + region + "]";
		}
		
		
}
