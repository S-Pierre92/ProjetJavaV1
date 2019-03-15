package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSetMetaData;

import MyException.MyDBException;
import MyException.PropertyException;

public class ConnexionDB {
	
	PropertiesManager prop;
	Connection con = null;
//    Statement sta;
    ResultSet re;
    ResultSetMetaData metaBase;
    
    public ConnexionDB() throws PropertyException {
    	
    	prop = new PropertiesManager();
    }
 
    public void connexionDB( String database) throws MyDBException {
        try {
            String url = "jdbc:mysql://" + prop.getServer() + ":" + prop.getPort() + "/" + database +prop.getSSl();
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, prop.getUser(), prop.getPassword());
            System.out.println("Ouverture de la connection");
//            sta = con.createStatement();
        } catch (ClassNotFoundException ex) {
            System.err.println("Ne peut pas trouver les classes du conducteur de la base de données.");
            System.err.println(ex);
            throw new MyDBException(ex.getMessage(), ex);
            
        } catch (SQLException ex) {
            System.err.println("pas de connection au base de de donnee.");
            System.err.println(ex);
            throw new MyDBException(ex.getMessage(), ex);
        }
    }
    
    public void closeConnexionDB() throws MyDBException {
        try {
//            re.close();
            con.close();
            System.out.println("Connexion à base de donnée fermée");
        } catch (SQLException ex) {
            System.err.println("Problème lors  de fermeture de la Base de données: "+ex.getMessage());
            throw new MyDBException(ex.getMessage(), ex);
        }
        
    }

}
