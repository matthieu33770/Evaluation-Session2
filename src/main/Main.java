package main;

import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Apprenant;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int ch;
		
		do {
			System.out.println("Menu :");
			System.out.println("1 - Afficher les noms et prenoms des apprenants");
			System.out.println("2 - Afficher la liste des apprenants par r�gion");
			System.out.println("3 - Afficher la liste des apprenants par r�gion by id");
			System.out.println("4 - Quitter");
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
						System.out.println(metier.Requetes.getApprenantById(Integer.parseInt(JOptionPane.showInputDialog("Saisissez un num�ro de r�gion (entre 1 et 3) pour afficher les �tudiants concern�s"))));
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (SQLException e) {	
						e.printStackTrace();
					}
					break;
				case 4:
					System.out.println("Au revoir & merci !");
					break;
				default:
					break;
			}
		}
		while(ch!=4);			
	}
}
