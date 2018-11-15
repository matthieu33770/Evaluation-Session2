package metier;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Activite;
import model.Apprenant;
import model.Avoir;
import model.Region;

public class Mapping {
	
	public static Apprenant mapperApprenant(ResultSet resultat) throws SQLException, ClassNotFoundException{
		Apprenant apprenant = new Apprenant();
		apprenant.setId(resultat.getInt("id"));
		apprenant.setNom(resultat.getString("nom"));
		apprenant.setPrenom(resultat.getString("prenom"));
		apprenant.setnaissance(resultat.getDate("date"));
		apprenant.setEmail(resultat.getString("email"));
		apprenant.setPhoto(resultat.getString("photo"));
		apprenant.setRegion(Requetes.getRegionById(resultat.getInt("id_region")));
		
		return apprenant;
		
	}
	
	public static Activite mapperActivite(ResultSet resultat) throws SQLException {
		Activite activite = new Activite();
		activite.setId(resultat.getInt("AC_ID"));
		activite.setActivite(resultat.getString("AC_NOM"));
		
		return activite;
	}
	
	public static Region mapperRegion(ResultSet resultat) throws SQLException {
		Region region = new Region();
		region.setId(resultat.getInt("RE_ID"));
		region.setNom(resultat.getString("RE_NOM"));
		
		return region;
	}
	
	public static Avoir mapperAvoir(ResultSet resultat) throws SQLException, ClassNotFoundException{
		Avoir avoir = new Avoir();
		avoir.setId_Act(Requetes.getActiviteById(resultat.getInt("AC_ID")));
		avoir.setId_App(Requetes.getApprenantById1(resultat.getInt("id")));
		
		return avoir;
	}

}
