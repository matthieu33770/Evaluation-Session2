package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import metier.Requetes;
import model.Activite;
import model.Apprenant;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int ch;
		int sc1;
		String saisie1, saisie2, saisie3, saisie4, saisie5, saisie6;
		
		do {
			System.out.println("Menu :");
			System.out.println("1 - Afficher les noms et prenoms des apprenants");
			System.out.println("2 - Afficher la liste des apprenants par région");
			System.out.println("3 - Afficher la liste des apprenants selon une région");
			System.out.println("4 - Afficher la liste des activités selon un apprenant");
			System.out.println("5 - Afficher la liste des apprenant pour une activité");
			System.out.println("6 - Ajouter un apprenant");
			System.out.println("7 - Quitter");
			ch = sc.nextInt();
			
			switch (ch) {
				case 1:
					try {
						// Requêtes nom prénom Apprenants
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
						// Requêtes Apprenants par Region
						System.out.println("=================================================================");
						System.out.println("\nListe des Apprenants par Région");

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
						String reg = JOptionPane.showInputDialog("Saisissez la région (en toutes lettres) pour afficher les étudiants concernés");
						appByReg = (metier.Requetes.getApprenantByIdRegion(reg));
						System.out.println("Les apprenants pour la région " + reg + " sont :");
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
						String nom = JOptionPane.showInputDialog("Choisir le nom d'un étudiant (commencant par un maj) :");
						actByApp = (metier.Requetes.getActiviteByApprenant(nom));
						System.out.println("Les activités de "+ nom + " sont :");
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
						int id = Integer.parseInt(JOptionPane.showInputDialog("Choisir le numéro d'une activité :"));
						appByAct = (metier.Requetes.getApprenantByActivity(id));
						System.out.println("L'activité "+ id + " est faite par :");
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
						
						System.out.println("Quel est son prénom ?");
						saisie1 = sc.nextLine();
						app.setPrenom(saisie1);
						
						System.out.println("Quel est son nom ?");
						saisie2 = sc.nextLine();
						app.setNom(saisie2);
						
						System.out.println("Quel est sa date de naissance ? (format aaaa-mm-jj)");
						saisie3 = sc.nextLine();
						app.setnaissance(saisie3);
						
						System.out.println("Quel est son email ?");
						saisie4 = sc.nextLine();
						app.setEmail(saisie4);
						
						System.out.println("Joindre une photo ?");
						saisie5 = sc.nextLine();
						app.setPhoto(saisie5);
						
						System.out.println("Pour quel département ?");
						sc1 = sc.nextInt();
						app.setRegion(sc1);
						
						Requetes.ajouterAppr(app);
						
						System.out.println("Apprenant " + saisie1 + "ajoute");
					} catch (SQLException e) {	
							e.printStackTrace();
					};
					break;
				case 7:
					System.out.println("Merci & au revoir !");
					break;
				default:
					break;
			}
		}
		while(ch!=7);	
		//essai
	}
}
