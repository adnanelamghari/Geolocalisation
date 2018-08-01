package geolocalisation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import geolocalisation.beans.Doctorant;

public class DoctorantDAO {
	private DAOFactory factory;
	public DoctorantDAO(DAOFactory factory) {
		super();
		this.factory=factory;
	}
	public void addDoctorant(Doctorant doctorant, String userPassWord) {
	    try { 
	    	Connection con = factory.getConnection();
	        PreparedStatement statement = con.prepareStatement("INSERT INTO doctorant (UserName, Nom, Prenom, UserPassWord) values( ?, ?, ?, ? ) ");
	        statement.setString(1, doctorant.getUserName());
	        statement.setString(2, doctorant.getNom());           
	        statement.setString(3, doctorant.getPrenom());   
	        statement.setString(4, userPassWord);
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

    public String doLogin(String username){
        String motDePasse;
        try {
        	Connection con = factory.getConnection();
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Doctorant WHERE UserName = ?");
            statement.setString(1, username);         
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                motDePasse=rs.getString("UserPassWord");                
                return motDePasse;
            }else{
            	motDePasse=null;
            }
        } catch (Exception e) {
        	motDePasse=null;
            e.printStackTrace();
        }
        return motDePasse;
    }
    
	public void updateDoctorant(Doctorant doctorant) {
	    try {
	    	Connection con = factory.getConnection();
	        PreparedStatement statement = con.prepareStatement("UPDATE doctorant set Nom=?, Prenom=?, Mail=?, Profil=?, Message=?, Recherche=?, Facebook=?, LinkedIn=?, Biographie=?, Telephone=?, DateNaissance=? WHERE UserName = ?");
	        statement.setString(1, doctorant.getNom());           
	        statement.setString(2, doctorant.getPrenom());  
	        statement.setString(3, doctorant.getMail());  
	        
	        if (doctorant.getEnumProfile().equals("ALL")){
	        	statement.setString(4, "1");
	        }else if(doctorant.getEnumProfile().equals("PORTEUR")){
	        	statement.setString(4, "0");
	        }else {statement.setString(4, "-1");}

	        if (doctorant.getEnumMessage().equals("ALL")){
	        	statement.setString(5, "1");
	        }else if(doctorant.getEnumMessage().equals("PORTEUR")){
	        	statement.setString(5, "0");
	        }else {statement.setString(5, "-1");}

	        if (doctorant.getEnumProjet().equals("ALL")){
	        	statement.setString(6, "1");
	        }else if(doctorant.getEnumProjet().equals("PORTEUR")){
	        	statement.setString(6, "0");
	        }else {statement.setString(6, "-1");}

	        statement.setString(7, doctorant.getFacebookUrl());  
	        statement.setString(8, doctorant.getLinkedInUrl());  
	        statement.setString(9, doctorant.getBiographie());  
	        statement.setString(10, doctorant.getTelephone());  
	        statement.setDate(11, doctorant.getDateNaissance());
	        statement.setString(12, doctorant.getUserName());
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public void updatePassWordDoctorant(Doctorant doctorant, String newPassWord) {
	    try {
	    	Connection con = factory.getConnection();
	        PreparedStatement statement =con.prepareStatement("UPDATE doctorant set UserPassWord=? WHERE UserName = ?");           
	        statement.setString(1, newPassWord);  
	        statement.setString(2, doctorant.getUserName());
	        statement.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}	
	
	 public void deleteDoctorant(Doctorant doctorant) {
	        try {
	        	Connection con = factory.getConnection();
	            PreparedStatement statement = con.prepareStatement("DELETE FROM doctorant WHERE UserName = ?");
	            statement.setString(1, doctorant.getUserName());           
	            statement.executeUpdate();
	            statement = con.prepareStatement("DELETE FROM diplome WHERE PseudoDoctorant = ?");
	            statement.setString(1, doctorant.getUserName());           
	            statement.executeUpdate();
	            statement = con.prepareStatement("DELETE FROM projet WHERE Id_doc = ?");
	            statement.setString(1, doctorant.getUserName());           
	            statement.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }	 
	 }
	 
	 public Doctorant getDoctorantByUserName(String doctorantUserName) {
	        Doctorant doctorant=null;
	        try {
	        	Connection con = factory.getConnection();
	            PreparedStatement statement = con.prepareStatement("SELECT * FROM Doctorant WHERE UserName = ?");
	            statement.setString(1, doctorantUserName);           
	            ResultSet rs = statement.executeQuery();
	            if(rs.next()){
	                doctorant=new Doctorant();
	                doctorant.setUserName(rs.getString("UserName"));
	                doctorant.setNom(rs.getString("Nom"));
	                doctorant.setMail(rs.getString("Mail"));
	                doctorant.setPrenom(rs.getString("Prenom"));
	                doctorant.setEnumProfile(rs.getString("Profil"));
	                doctorant.setEnumMessage(rs.getString("Message"));
	                doctorant.setEnumProjet(rs.getString("Recherche"));
	                doctorant.setFacebookUrl(rs.getString("Facebook"));
	                doctorant.setLinkedInUrl(rs.getString("LinkedIn"));
	                doctorant.setDateNaissance(rs.getDate("DateNaissance"));	                
	                doctorant.setBiographie(rs.getString("Biographie")); 
	                doctorant.setTelephone(rs.getString("Telephone"));
	                doctorant.setPictureName(rs.getString("photo"));
	                return doctorant;
	            }else{
	            	doctorant=null;
	            }
	        } catch (Exception e) {
	        	doctorant=null;
	            e.printStackTrace();
	        }
	        return doctorant;
	 }
	 
	 public ArrayList<Doctorant> dbDoctorant(boolean profil){
	        ArrayList<Doctorant> arrayDoc=new ArrayList<Doctorant>();
	        PreparedStatement statement;
	        Doctorant doctorant;
	        try {
	        	Connection con = factory.getConnection();
	            if (profil) {
	            	statement= con.prepareStatement("SELECT * FROM Doctorant where profil !=-1");
	            }
	            else {
	            	statement= con.prepareStatement("SELECT * FROM Doctorant where profil=1");
	            }
	            ResultSet rs = statement.executeQuery();
	            while(rs.next()){
	            	doctorant=new Doctorant(); 
	                doctorant.setUserName(rs.getString("UserName"));
	                doctorant.setNom(rs.getString("Nom"));
	                doctorant.setMail(rs.getString("Mail"));
	                doctorant.setPrenom(rs.getString("Prenom"));
	                doctorant.setEnumProfile(rs.getString("Profil"));
	                doctorant.setEnumMessage(rs.getString("Message"));
	                doctorant.setEnumProjet(rs.getString("Recherche"));
	                doctorant.setFacebookUrl(rs.getString("Facebook"));
	                doctorant.setLinkedInUrl(rs.getString("LinkedIn"));
	                doctorant.setDateNaissance(rs.getDate("DateNaissance"));	                
	                doctorant.setBiographie(rs.getString("Biographie"));
	                doctorant.setTelephone(rs.getString("Telephone"));	
	                doctorant.setPictureName(rs.getString("photo"));
	                if (!doctorant.equals(null)) {
	                	arrayDoc.add(doctorant);
	                }
	                doctorant=null;
	            }
	        } catch (Exception e) {
		        	arrayDoc.clear();
	            e.printStackTrace();
	        }
	        return arrayDoc;
	    }
}
