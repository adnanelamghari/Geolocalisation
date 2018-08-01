package geolocalisation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAOFactory {
    private String url= "jdbc:mysql://localhost:3306/geolocalisation";
    private String username = "root";
    private String password = "";
    
    public DAOFactory() {
    	super();
        url= "jdbc:mysql://localhost:3306/geolocalisation";
        username = "root";
        password = "";
    }
    
    public static DAOFactory getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }
        DAOFactory instance = new DAOFactory();
        return instance;
    }
    
    public Connection getConnection() {
    	try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
}
