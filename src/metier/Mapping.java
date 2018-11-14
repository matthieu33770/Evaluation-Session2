package metier;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Activite;
import model.Apprenant;
import model.Region;

public class Mapping {
	
	public static Apprenant mapperApprenant(ResultSet resultat) throws SQLException, ClassNotFoundException{
		Apprenant apprenant = new Apprenant();
		//apprenant.setId(resultat.getInt("id"));
		apprenant.setNom(resultat.getString("nom"));
		apprenant.setPrenom(resultat.getString("prenom"));
		apprenant.setDateNaissance(resultat.getDate("dateNaissance"));
		apprenant.setEmail(resultat.getString("email"));
		apprenant.setPhoto(resultat.getString("photo"));
		apprenant.setRegion(Requetes.getRegionById(resultat.getInt("RE_NOM")));
		
		return apprenant;
		
	}
	
	public static Activite mapperActivite(ResultSet resultat) throws SQLException {
		Activite activite = new Activite();
		activite.setId(resultat.getInt("id"));
		activite.setActivite(resultat.getString("nom"));
		
		return activite;
	}
	
	public static Region mapperRegion(ResultSet resultat) throws SQLException {
		Region region = new Region();
		region.setId(resultat.getInt("RE_ID"));
		region.setNom(resultat.getString("RE_NOM"));
		
		return region;
	}

}
