package geolocalisation.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import geolocalisation.beans.Diplome;

public class DiplomeDAO {
	 private DAOFactory factory;
	 
	 public DiplomeDAO(DAOFactory factory) {
			super();
			this.factory=factory;
	 }

	 public void addDiplome(Diplome diplome) {
	        try {
	        	Connection con = factory.getConnection();
	            PreparedStatement statement =con.prepareStatement("INSERT INTO diplome (Intitule, Lieu, DateDebut, DateFin, PseudoDoctorant) values (?,?,?,?,?)");
	            statement.setString(1, diplome.getIntitule()); 
	            statement.setString(2, diplome.getLieu());     
	            statement.setString(3, diplome.getDateDebut()); 
	            statement.setString(4, diplome.getDateFin()); 
	            statement.setString(5, diplome.getIdDoctorant());
	            statement.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }	 
	 }
	 
	 public void deleteDiplome(int diplome) {
	        try {
	        	Connection con = factory.getConnection();
	            PreparedStatement statement = con.prepareStatement("DELETE FROM diplome WHERE Id_Diplome = ?");
	            statement.setInt(1, diplome);                 
	            statement.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }	 
	 }
	 
	 public ArrayList<Diplome> getListeDiplomeDoctorant(String doctorant){
	        ArrayList<Diplome> arrayDip=new ArrayList<Diplome>();
	        PreparedStatement statement;
	        Diplome diplome;
	        try {
	        	Connection con = factory.getConnection();
	            statement= con.prepareStatement("SELECT * FROM diplome where PseudoDoctorant=?");
	            statement.setString(1, doctorant);
	            ResultSet rs = statement.executeQuery();
	            while(rs.next()){
	            	diplome=new Diplome(); 
	            	diplome.setIntitule(rs.getString("Intitule"));
	            	diplome.setIdDiplome(rs.getInt("Id_Diplome"));
	            	diplome.setLieu(rs.getString("Lieu"));
	            	diplome.setDateDebut(rs.getString("DateDebut"));
	            	diplome.setDateFin(rs.getString("DateFin"));	                
	                if (!diplome.equals(null)) {
	                	arrayDip.add(diplome);
	                }
	                diplome=null;
	            }
	        } catch (Exception e) {
		        	arrayDip.clear();
	            e.printStackTrace();
	        }
	        return arrayDip;
	    }
	 
	 
}
