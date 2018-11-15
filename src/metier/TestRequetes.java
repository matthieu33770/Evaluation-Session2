package metier;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.AccessBD;
import model.Apprenant;

public class TestRequetes {
	
	
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
