# Evaluation-Session2
Projet d’évaluation : Java - JDBC - SQL - MySQL - MCD

## Sujet :

Dans le but de mettre en place une application pour gérer les différentes activités des apprenants de la Promo3 de LaPoste, voici ci-dessous, les informations dont vous disposez :

un(e) apprenant(e) peut avoir aucune ou plusieurs activités
un(e) apprenant(e) est rattaché(e) à une et une seule région
une région a au minimum un, voire plusieurs apprenant(e)s
Notre base de données doit enregistrer les informations suivantes :

Pour chaque apprenant(e) on enregistre son prénom et son nom, sa date de naissance, son email et sa photo. Une région est identifiée par un numéro d’ordre auto-généré et commençant par 1. Un libellé lui est associé.

## Création du MCD :
![alt text](https://github.com/matthieu33770/Evaluation-Session2/blob/master/MCD.JPG)

## MLD généré :

![alt text](https://github.com/matthieu33770/Evaluation-Session2/blob/master/MLD.JPG)

## Création de la base de données :

![alt text](https://github.com/matthieu33770/Evaluation-Session2/blob/master/BDD.JPG)

## Remplissage des tables :

![alt text](https://github.com/matthieu33770/Evaluation-Session2/blob/master/table.JPG)

## Création de l'arorescence des fichiers

![alt text](https://github.com/matthieu33770/Evaluation-Session2/blob/master/arborescenceFichiers.JPG)

## Création d'un modele par table
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
			return "Apprenant " + id + " " + nom + " " + prenom;
		}
		
		public String afficheApprenantByRegion() {
			return region + " - " + nom + " " + prenom;
		}
}


