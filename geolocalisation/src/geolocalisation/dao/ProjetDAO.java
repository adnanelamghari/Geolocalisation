package geolocalisation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import geolocalisation.Classes.Country;
import geolocalisation.beans.Projet;

public class ProjetDAO {
	private DAOFactory factory;
	public ProjetDAO(DAOFactory factory) {
		super();
		this.factory=factory;
	}
	 public void deleteProjet(int projet) {
	        try {
	        	Connection con = factory.getConnection();
	            PreparedStatement statement = con.prepareStatement("DELETE FROM projet WHERE Id_projet = ?");
	            statement.setInt(1, projet);                 
	            statement.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }	 
	 }
	 
	 public void addProjet(Projet projet) {
	        try {
	        	Connection con = factory.getConnection();
	            PreparedStatement statement = con.prepareStatement("INSERT INTO projet ( Titre, Description, Id_doc, Ecole, Discipline, Laboratoire, latitude, longitude) values (?,?,?,?,?,?,?,?)");
	            statement.setString(1, projet.getTitre()); 
	            statement.setString(2, projet.getDescription()); 
	            statement.setString(3, projet.getId_doc()); 
	            statement.setString(4, projet.getEcole()); 
	            statement.setString(5, projet.getDiscipline());
	            statement.setString(6, projet.getLaboratoire());
	            statement.setDouble(7, projet.getLatitude());
	            statement.setDouble(8, projet.getLongitude());
	            statement.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }	 
	 }
	 
	 public ArrayList<Projet> getListeProjetDoctorant(String doctorant){
	        ArrayList<Projet> arrayProj=new ArrayList<Projet>();
	        PreparedStatement statement;
	        Projet projet; 
	        try {
	        	Connection con = factory.getConnection();
	            statement= con.prepareStatement("SELECT * FROM projet where Id_doc=?");  
	            statement.setString(1, doctorant);
	            ResultSet rs = statement.executeQuery();
	            while(rs.next()){
	            	projet=new Projet();
	                projet.setTitre(rs.getString("Titre"));
	                projet.setDescription(rs.getString("Description"));
	                projet.setLatitude(rs.getDouble("latitude"));
	                projet.setLongitude(rs.getDouble("longitude"));
	                projet.setId_projet(rs.getInt("Id_projet"));
	                projet.setId_doc(rs.getString("Id_doc"));
	                projet.setEcole(rs.getString("Ecole"));
	                projet.setDiscipline(rs.getString("Discipline"));
	                projet.setLaboratoire(rs.getString("Laboratoire"));
	                projet.setFileName(rs.getString("Fichier"));
	                if (!projet.equals(null)) {
	                	arrayProj.add(projet);
	                }
	                projet=null;
	            }
	        } catch (Exception e) {
		        	arrayProj.clear();
	            e.printStackTrace();
	        }
	        return arrayProj;
	    }
	 
	 public ArrayList<Projet> dbProjet(){
	        ArrayList<Projet> arrayProj=new ArrayList<Projet>();
	        PreparedStatement statement;
	        Projet projet; 
	        try {
	        	Connection con = factory.getConnection();
	            statement= con.prepareStatement("SELECT * FROM projet");     
	            ResultSet rs = statement.executeQuery();
	            while(rs.next()){
	            	projet=new Projet();
	                projet.setTitre(rs.getString("Titre"));
	                projet.setDescription(rs.getString("Description"));
	                projet.setLatitude(rs.getDouble("latitude"));
	                projet.setLongitude(rs.getDouble("longitude"));
	                projet.setId_projet(rs.getInt("Id_projet"));
	                projet.setId_doc(rs.getString("Id_doc"));
	                projet.setEcole(rs.getString("Ecole"));
	                projet.setDiscipline(rs.getString("Discipline"));
	                //projet.setPays((new Country()).findCountry(rs.getDouble("latitude"), rs.getDouble("longitude"))); 
	                //cette fontion (findCountry) retourne le nom du payé selon la longitude et la latitude, generalement elle  utilise la connexion et dans le cas de perte de cnx elle declanche une exception
	                projet.setLaboratoire(rs.getString("Laboratoire"));
	                projet.setFileName(rs.getString("Fichier"));
	                if (!projet.equals(null)) {
	                	arrayProj.add(projet);
	                }
	                projet=null;
	            }
	        } catch (Exception e) {
		        	arrayProj.clear();
	            e.printStackTrace();
	        }
	        return arrayProj;
	    }
}
