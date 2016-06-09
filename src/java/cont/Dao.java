package cont;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Omar
 */
import java.sql.*;
 
public class Dao {
    public Connection conexion;
    public final static String userDb = "root";
    public final static String passDb = "isacx92";
    
    
    //Conectar a la Base de datos
    private Connection conectar() throws SQLException,ClassNotFoundException{
        
         Class.forName("com.mysql.jdbc.Driver");
         conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/sigre",userDb, passDb);
         return conexion;
    }
 
    public ResultSet consulta(String query) throws SQLException, ClassNotFoundException{
    
        Connection con = conectar();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        return rs;
    
    }  
      
    
    
}