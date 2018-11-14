package main;

import java.sql.SQLException;

import model.Apprenant;

public class Main {

	public static void main(String[] args) {

		try {
			// Les requêtes SELECT
		
				System.out.println("=================================================================");
				System.out.println("\nListe des Apprenants avec getAllApprenant");
				for (Apprenant apprenant : metier.Requetes.getAllApprenant()) {
					System.out.println(apprenant + "\n");
				}
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
