package metier;

import java.sql.SQLException;
import java.util.ArrayList;

import connection.AccessBD;
import model.Apprenant;
import model.Region;

import java.sql.ResultSet;


public class Requetes {

	public static ArrayList<Apprenant> getAllApprenant() throws ClassNotFoundException, SQLException {
		ArrayList<Apprenant>  apprenants = new ArrayList<Apprenant>();
		String requete	= "SELECT * FROM apprenant ";
		ResultSet resultat = AccessBD.executerQuery(requete);
		while(resultat.next())
		{
			Apprenant a = Mapping.mapperApprenant(resultat);
			apprenants.add(a);
		}
		return apprenants;
	}
	  
	public static Region getRegionById(int id) throws ClassNotFoundException, SQLException {
		Region region = new Region();
		String requete	= "SELECT * FROM region WHERE id="+id;
		ResultSet resultat = AccessBD.executerQuery(requete);
		resultat.next();
		region.setId(resultat.getInt("id"));
		region.setNom(resultat.getString("nom"));
		return region;	
	}
}
