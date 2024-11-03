package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String host = "localhost";
    private static final String port = "3306";
    private static final String database = "ventas";
    private static final String user = "root";
    private static final String password = "123456";
    private static String url;
    private static Connection cnn = null;
    
    public static Connection MySQL(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            url = "jdbc:mysql://" + host + ":" + port + "/" + database;
            cnn = DriverManager.getConnection(url, user, password);
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return cnn;
    }
    
    public static void closeConnection(){
        try {
            cnn.close();
        } 
        
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
