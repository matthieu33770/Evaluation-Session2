package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metier.Requetes;
import model.Activite;
import model.Apprenant;
import model.Avoir;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		int ch;
		int sc1, sc2, sc3, sc4;
		String saisie1, saisie2, saisie3, saisie4, saisie5, saisie6;
		
		do {
			System.out.println("Menu :");
			System.out.println("1 - Afficher les noms et prenoms des apprenants");
			System.out.println("2 - Afficher la liste des apprenants par r�gion");
			System.out.println("3 - Afficher la liste des apprenants selon une r�gion");
			System.out.println("4 - Afficher la liste des activit�s selon un apprenant");
			System.out.println("5 - Afficher la liste des apprenant pour une activit�");
			System.out.println("6 - Ajouter un apprenant");
			System.out.println("7 - Ajouter deux activites aux dernier apprenant ajoute");
			System.out.println("8 - Afficher la liste des activit� non utilis�e");
			System.out.println("9 - Modifier le nom d'un apprenant");
			System.out.println("10 - Suppression d'un apprenant");
			System.out.println("11 - Quitter");
			ch = sc.nextInt();
			
			switch (ch) {
				case 1:
					try {
						// Requ�tes nom pr�nom Apprenants
						System.out.println("=================================================================");
						System.out.println("\nListe des Apprenants");
						for (Apprenant apprenant : metier.Requetes.getAllApprenant()) {
							System.out.println(apprenant.afficherNomPrenom());
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {	
						e.printStackTrace();
					}
					break;
				case 2:
					try {
						// Requ�tes Apprenants par Region
						System.out.println("=================================================================");
						System.out.println("\nListe des Apprenants par R�gion");

						for (Apprenant apprenant : metier.Requetes.getApprenantByRegion()) {
							System.out.println(apprenant.afficheApprenantByRegion());
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {	
						e.printStackTrace();
					}
					break;
				case 3:
					try {
						ArrayList<Apprenant> appByReg = new ArrayList<>();
						String reg = JOptionPane.showInputDialog("Saisissez la r�gion (en toutes lettres) pour afficher les �tudiants concern�s");
						appByReg = (metier.Requetes.getApprenantByIdRegion(reg));
						System.out.println("Les apprenants pour la r�gion " + reg + " sont :");
						for ( Apprenant apprenant : appByReg) {
							System.out.println(apprenant.afficheApprenantByRegion());
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {	
						e.printStackTrace();
						
					}
					break;
				case 4:
					try {
						ArrayList<Activite> actByApp = new ArrayList<>();
						String nom = JOptionPane.showInputDialog("Choisir le nom d'un �tudiant (commencant par un maj) :");
						actByApp = (metier.Requetes.getActiviteByApprenant(nom));
						System.out.println("Les activit�s de "+ nom + " sont :");
						for (Activite activite : actByApp) {
							System.out.println(activite);
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {	
						e.printStackTrace();
					}
					break;
				case 5:
					try {
						ArrayList<Apprenant> appByAct = new ArrayList<>();
						int id = Integer.parseInt(JOptionPane.showInputDialog("Choisir le num�ro d'une activit� :"));
						appByAct = (metier.Requetes.getApprenantByActivity(id));
						System.out.println("L'activit� "+ id + " est faite par :");
						for (Apprenant apprenant : appByAct) {
							System.out.println(apprenant.afficherNomPrenom());
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {	
						e.printStackTrace();
					};
					break;
				case 6:
					try {
						Apprenant app = new Apprenant();
						app.setId(Requetes.getNombreDApprenant()+1);
						
						System.out.println("Quel est son pr�nom ?");
						saisie1 = sc.next();
						app.setPrenom(saisie1);
						
						System.out.println("Quel est son nom ?");
						saisie2 = sc.next();
						app.setNom(saisie2);
						
						System.out.println("Quel est sa date de naissance ? (format aaaa-mm-jj)");
						saisie3 = sc.next();
						app.setnaissance(saisie3);
						
						System.out.println("Quel est son email ?");
						saisie4 = sc.next();
						app.setEmail(saisie4);
						
						System.out.println("Joindre une photo ?");
						saisie5 = sc.next();
						app.setPhoto(saisie5);
						
						System.out.println("Pour quel d�partement ?");
						sc1 = sc.nextInt();
						app.setRegion(sc1);
						
						Requetes.ajouterAppr(app);
						
						System.out.println("Apprenant " + saisie1 + " " + saisie2 + " ajoute");
					} catch (SQLException e) {	
							e.printStackTrace();
					};
					break;
				case 7:
					try {
					Avoir avoir = new Avoir();
					
					System.out.println("Quel est l'activite a ajouter ?");
					sc2 = sc.nextInt();
					avoir.setId_Act(sc2);					
					
					avoir.setId_App(Requetes.getNombreDApprenant());
					
					Requetes.ajouterAct(avoir);
					System.out.println("L'activite " + sc2 + " est ajoute a " + Requetes.getNombreDApprenant());
					} catch (SQLException e) {	
						e.printStackTrace();
					};
					break;
				case 8:
					try {
						System.out.println("Voici la liste des activit�s qui ne sont pas utilis�es par un / des apprenant(s)");

						for (Activite activite : metier.Requetes.getNotUseActivite()) {
							System.out.println(activite);
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {	
						e.printStackTrace();
					}
					break;
				case 9:
					try {
						for (Apprenant apprenant : metier.Requetes.getAllApprenant()) {
							System.out.println(apprenant.afficherNomPrenom());
						}
						
						System.out.println("Quel est lidentifiant de l'apprenant � modifier ?");
						sc3 = sc.nextInt();
						//apprenantMod.setId(sc3);
						
						Apprenant apprenantMod = Requetes.getApprenantById(sc3);
								
						System.out.println("Quel est son nouveau nom ?");
						saisie6 = sc.next();
						apprenantMod.setNom(saisie6);
						
						Requetes.modifierApprenant(apprenantMod);
					
					} catch (SQLException e) {	
						e.printStackTrace();
					};
					break;
				case 10:
					try {
						for (Apprenant apprenant : metier.Requetes.getAllApprenant()) {
							System.out.println(apprenant.afficherNomPrenom());
						}
						
						System.out.println("Quel est lidentifiant de l'apprenant � supprimer ?");
						sc4 = sc.nextInt();
					
						Apprenant apprenantSup = Requetes.getApprenantById(sc4);
						if (apprenantSup!=null) {
							// je l'affiche
							System.out.println(apprenantSup.afficherNomPrenom());
							
							// je le supprime (pan !! pan !! il est mort... dans la base de donn�es uniquement ;) nous ne sommes pas une organisation criminelle !! 
							Requetes.supprimerApprenant(apprenantSup);
						}
					} catch (SQLException e) {	
						e.printStackTrace();
					};
					break;
				case 11:
					System.out.println("Merci et au revoir ! :)");
					break;
				default:
					break;
			}
		}
		while(ch!=11);	
	}
}
