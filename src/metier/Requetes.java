package metier;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connection.AccessBD;
import model.Activite;
import model.Apprenant;
import model.Avoir;
import model.Region;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Requetes {

	public static ArrayList<Apprenant> getAllApprenant() throws ClassNotFoundException, SQLException {
		ArrayList<Apprenant>  apprenants = new ArrayList<Apprenant>();
		String requete	= "SELECT * FROM apprenant";
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
		String requete	= "SELECT * FROM region WHERE RE_ID="+id;
		ResultSet resultat = AccessBD.executerQuery(requete);
		resultat.next();
		region.setId(resultat.getInt("RE_ID"));
		region.setNom(resultat.getString("RE_NOM"));
		return region;	
	}
	
	public static Apprenant getApprenantById1(int id) throws ClassNotFoundException, SQLException {
		Apprenant apprenant = new Apprenant();
		String requete	= "SELECT * FROM apprenant WHERE RE_ID="+id;
		ResultSet resultat = AccessBD.executerQuery(requete);
		resultat.next();
		apprenant.setId(resultat.getInt("id"));
		apprenant.setNom(resultat.getString("nom"));
		apprenant.setPrenom(resultat.getString("prenom"));
		return apprenant;	
	}
	
	public static Apprenant getApprenantById(int id) throws ClassNotFoundException, SQLException {
		Apprenant apprenant = new Apprenant();
		String requete	= "SELECT * FROM apprenant WHERE id="+id;
		ResultSet resultat = AccessBD.executerQuery(requete);
		resultat.next();
		apprenant.setId(resultat.getInt("id"));
		apprenant.setNom(resultat.getString("nom"));
		apprenant.setPrenom(resultat.getString("prenom"));
		return apprenant;	
	}
	
	public static Activite getActiviteById(int id) throws ClassNotFoundException, SQLException {
		Activite activite = new Activite();
		String requete	= "SELECT * FROM activite WHERE RE_ID="+id;
		ResultSet resultat = AccessBD.executerQuery(requete);
		resultat.next();
		activite.setId(resultat.getInt("AC_ID"));
		activite.setActivite(resultat.getString("AC_NOM"));;
		return activite;	
	}
	
	public static ArrayList<Apprenant> getApprenantByRegion() throws ClassNotFoundException, SQLException {
		ArrayList<Apprenant>  apprenants = new ArrayList<Apprenant>();
		String requete	= "SELECT * FROM apprenant INNER JOIN region ON apprenant.id_region = region.RE_ID";
		ResultSet resultat = AccessBD.executerQuery(requete);
		while(resultat.next())
		{
			Apprenant a = Mapping.mapperApprenant(resultat);
			apprenants.add(a);
		}
		return apprenants;
	}
	
	public static ArrayList<Region> getAllRegion() throws ClassNotFoundException, SQLException {
		ArrayList<Region>  regions = new ArrayList<Region>();
		String requete = "SELECT * FROM region";
		ResultSet resultat = AccessBD.executerQuery(requete);
		while(resultat.next())
		{
			Region r = Mapping.mapperRegion(resultat);
			regions.add(r);
		}
		return regions;
	}
	
	public static ArrayList<Apprenant> getApprenantByIdRegion(String id) throws ClassNotFoundException, SQLException {
		
		ArrayList<Apprenant> apprenants = new ArrayList<>();
		
		PreparedStatement aPreparedStatement = AccessBD.getConnection().prepareStatement("SELECT * FROM apprenant INNER JOIN region ON apprenant.id_region = region.RE_ID WHERE region.RE_NOM = ?");
		aPreparedStatement.setString(1,id);
		ResultSet resultat = aPreparedStatement.executeQuery();
		while (resultat.next()) {
			Apprenant apprenantss = Mapping.mapperApprenant(resultat);
			apprenants.add(apprenantss);
		}
		return apprenants;	
	}
	
	public static ArrayList<Activite> getActiviteByApprenant(String nom) throws ClassNotFoundException, SQLException {

		ArrayList<Activite> activites = new ArrayList<>();
		PreparedStatement aPreparedStatement = AccessBD.getConnection().prepareStatement("select * from apprenant inner join avoir on apprenant.id = avoir.id_App inner join activite on activite.AC_ID = avoir.id_Act where apprenant.nom = ?");
		aPreparedStatement.setString(1,nom);
		ResultSet resultat = aPreparedStatement.executeQuery();
		while (resultat.next()){
			Activite activitee = Mapping.mapperActivite(resultat);
			activites.add(activitee);
		}
		return activites;
	}
	
	public static ArrayList<Apprenant> getApprenantByActivity(int id) throws ClassNotFoundException, SQLException {

		ArrayList<Apprenant> apprenantAct = new ArrayList<>();
		PreparedStatement aPreparedStatement = AccessBD.getConnection().prepareStatement("select * from apprenant inner join avoir on apprenant.id = avoir.id_App inner join activite on activite.AC_ID = avoir.id_Act where activite.AC_ID = ?");
		aPreparedStatement.setInt(1,id);
		ResultSet resultat = aPreparedStatement.executeQuery();
		while (resultat.next()){
			Apprenant lApprenant = Mapping.mapperApprenant(resultat);
			apprenantAct.add(lApprenant);
		}
		return apprenantAct;
	}
	
	public static void ajouterAppr(Apprenant apprenant) throws SQLException
	{
		PreparedStatement prepareStatement = AccessBD.getConnection().prepareStatement("INSERT INTO `apprenant` VALUES( ? , ? , ? , ? , ? , ? , ?)");
		prepareStatement.setInt(1,apprenant.getId());
		prepareStatement.setString(2,apprenant.getPrenom());
		prepareStatement.setString(3,apprenant.getNom());
		prepareStatement.setString(4, apprenant.getnaissance());
		prepareStatement.setString(5, apprenant.getEmail());
		prepareStatement.setString(6, apprenant.getPhoto());
		prepareStatement.setInt(7, apprenant.getRegion());
		prepareStatement.executeUpdate();
	}
	
	public static int getNombreDApprenant() throws SQLException
	{
		 ResultSet resultat = AccessBD.getConnection().createStatement().executeQuery("SELECT count(*) FROM apprenant");
		 resultat.next();
		 return resultat.getInt(1);
	}
	
	public static void ajouterAct(Avoir avoir) throws SQLException
	{
		PreparedStatement prepareStatement = AccessBD.getConnection().prepareStatement("INSERT INTO `avoir` VALUES( ? , ? )");
		prepareStatement.setInt(1, avoir.getId_Act());
		prepareStatement.setInt(2, avoir.getId_App());
		prepareStatement.executeUpdate();
	}
	
	public static ArrayList<Activite> getNotUseActivite() throws ClassNotFoundException, SQLException {
		
		ArrayList<Activite> notUseActivite = new ArrayList<Activite>();
		String requete = "select * from avoir RIGHT OUTER JOIN activite ON avoir.id_Act = activite.AC_ID WHERE id_Act IS NULL";
		ResultSet resultat = AccessBD.executerQuery(requete);
		while(resultat.next())
		{
			Activite act = Mapping.mapperActivite(resultat);
			notUseActivite.add(act);
		}
		return notUseActivite;
	}
	
	public static void modifierApprenant(Apprenant apprenant) throws SQLException
	{
		try {
			PreparedStatement prepareStatement = AccessBD.getConnection().prepareStatement("UPDATE apprenant SET nom = ? WHERE id = ? ");
			prepareStatement.setString(1,apprenant.getNom());
			prepareStatement.setInt(2, apprenant.getId());
			prepareStatement.executeUpdate();
			System.out.println("Modification effectu�e pour l'apprenant : "+ apprenant);

		}
		catch(SQLException e){
			System.out.println("Erreur lors de la modification !");
		}
	}
	
	public static void supprimerApprenant(Apprenant apprenant) throws SQLException
	{
		Statement statement = null;

		try {
			statement = AccessBD.getConnection().createStatement();
			String sql = "DELETE FROM apprenant WHERE id="+ apprenant.getId();
			statement.executeUpdate(sql);
			System.out.println("Suppression de l'apprenant "+ apprenant + " effectu�e");
		}
		catch(SQLException e){
			System.out.println("Erreur lors de la suppression de l'apprenant !");
		}
	}
}
