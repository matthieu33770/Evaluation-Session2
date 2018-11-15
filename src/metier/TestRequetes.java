package metier;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.AccessBD;
import model.Apprenant;

public class TestRequetes {
	
	public static void ajouterAppr(Apprenant apprenant) throws SQLException
	{
		PreparedStatement prepareStatement = AccessBD.getConnection().prepareStatement("INSERT INTO `apprenant` VALUES( ? , ? , ? , ? , ? , ? , ?)");
		prepareStatement.setInt(1,apprenant.getId());
		prepareStatement.setString(2,apprenant.getPrenom());
		prepareStatement.setString(3,apprenant.getNom());
		prepareStatement.setDate(4, apprenant.getnaissance());
		prepareStatement.setString(5, apprenant.getEmail());
		prepareStatement.setString(6, apprenant.getPhoto());
		//prepareStatement.setInt(7, apprenant.getRegion());
		prepareStatement.executeUpdate();
	}
	/**
	public static void modifierApprenant(Apprenant apprenant) throws SQLException
	{
		try {
			PreparedStatement prepareStatement = AccessBD.getConnection().prepareStatement("UPDATE pilote SET PI_NOM = ? , PI_SITE = ? WHERE PI_ID = ? ");
			prepareStatement.setString(1,pilote.getNom());
			prepareStatement.setString(2,pilote.getSite());
			prepareStatement.setInt(3,pilote.getId());
			prepareStatement.executeUpdate();
			System.out.println("Modification effectuée pour le pilote : "+pilote);

		}
		catch(SQLException e){
			System.out.println("Erreur lors de la modification !");
		}
	}
*/
}
