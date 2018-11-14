package metier;

import java.sql.ResultSet;
import java.sql.SQLException;
import model.Apprenant;

public class Mapping {
	
	public static Apprenant mapperApprenant(ResultSet resultat) throws SQLException
	{
		Apprenant apprenant = new Apprenant();
		//apprenant.setId(resultat.getInt("id"));
		apprenant.setNom(resultat.getString("nom"));
		apprenant.setPrenom(resultat.getString("prenom"));
		apprenant.setDateNaissance(resultat.getDate("dateNaissance"));
		apprenant.setEmail(resultat.getString("email"));
		apprenant.setPhoto(resultat.getString("photo"));
		
		return apprenant;
		
	}

}
