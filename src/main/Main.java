package main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import model.Activite;
import model.Apprenant;

public class Main {

	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int ch;
		
		do {
			System.out.println("Menu :");
			System.out.println("1 - Afficher les noms et prenoms des apprenants");
			System.out.println("2 - Afficher la liste des apprenants par r�gion");
			System.out.println("3 - Afficher la liste des apprenants selon une r�gion");
			System.out.println("4 - Afficher la liste des activit�s selon un apprenant");
			System.out.println("5 - Quitter");
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
					System.out.println("Merci & au revoir !");
					break;
				default:
					break;
			}
		}
		while(ch!=5);	
		//essai
	}
}
