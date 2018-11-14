package metier;

import java.sql.SQLException;
import java.util.ArrayList;

import connection.AccessBD;
import fr.bouget.connection.AccesBD;
import fr.bouget.metier.Mapping;
import fr.bouget.model.Pilote;
import model.Apprenant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;

public class Requetes {

	public static ArrayList<Apprenant> getAllApprenant() throws ClassNotFoundException, SQLException

	{
		ArrayList<Apprenant>  apprenants = new ArrayList<Apprenant>();
		String requete	= "SELECT nom, prenom FROM apprenant ";
		ResultSet resultat = AccessBD.executerQuery(requete);
		while(resultat.next())
		{
			Apprenant p = Mapping.mapperApprenant(resultat);
			apprenants.add(p);
		}
		return apprenants;
	}
	  
	
}
