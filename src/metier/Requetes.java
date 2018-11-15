package metier;

import java.sql.SQLException;
import java.util.ArrayList;

import connection.AccessBD;
import model.Activite;
import model.Apprenant;
import model.Region;

import java.sql.PreparedStatement;
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
	
	public static Apprenant getApprenantByIdRegion(int id) throws ClassNotFoundException, SQLException {
		
		Apprenant apprenant = new Apprenant();
		
		PreparedStatement aPreparedStatement = AccessBD.getConnection().prepareStatement("SELECT * FROM apprenant WHERE id_Region = ?");
		aPreparedStatement.setInt(1,id);
		ResultSet resultat = aPreparedStatement.executeQuery();
		resultat.next();
		apprenant.setRegion(Requetes.getRegionById(resultat.getInt("id_region")));
		apprenant.setNom(resultat.getString("nom"));
		apprenant.setPrenom(resultat.getString("prenom"));
		apprenant.afficheApprenantByRegion();
		return apprenant;	
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
	
	public static ArrayList<Activite> getActiviteByApprenant(String nom) throws ClassNotFoundException, SQLException {

		ArrayList<Activite> activites = new ArrayList<>();
		PreparedStatement aPreparedStatement = AccessBD.getConnection().prepareStatement("select apprenant.nom, apprenant.prenom, activite.AC_NOM, activite.AC_ID from apprenant inner join avoir on apprenant.id = avoir.id_App inner join activite on activite.AC_ID = avoir.id_Act where apprenant.nom = ?");
		aPreparedStatement.setString(1,nom);
		ResultSet resultat = aPreparedStatement.executeQuery();
		while (resultat.next()){
			Activite activitee = Mapping.mapperActivite(resultat);
			activites.add(activitee);
		}
		return activites;
	}
}
