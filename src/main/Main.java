package main;

import java.sql.SQLException;

import model.Apprenant;
import java.util.Scanner;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int ch;
		
		do {
			System.out.println("Menu :");
			System.out.println("1 - Afficher les noms et prenoms des apprenants");
			System.out.println("2 - Afficher la liste des apprenants par région");
			System.out.println("3 - Quitter");
			ch = sc.nextInt();
			
			switch (ch) {
				case 1:
					try {
						// Requêtes nom prénom Apprenants
						System.out.println("=================================================================");
						System.out.println("\nListe des Apprenants avec getAllApprenant");
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
						System.out.println("\nListe des Apprenants avec getAllApprenant");
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
					System.out.println("Au revoir !");
					break;
				default:
					
					break;
			}
		}
		while(ch!=3);			
	}
}
