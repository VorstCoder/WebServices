/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloPortal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Alex
 */
public class Conexion {
    
   public static Conexion instancia;
    public Connection con;
    
    public Conexion() throws ClassNotFoundException, SQLException{
    
    

    Class.forName("oracle.jdbc.OracleDriver");
   
    con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","prueba","prueba");
    
   
    
    
    }
    
    
    public static Conexion getInstancia() throws ClassNotFoundException, SQLException{
    
    if(instancia == null){
    
    instancia = new Conexion();
    }
        
        return instancia;
    }
    
    public Connection getConnection(){
    
    return con;
    }
    
    public void Desconexion(){
    
    con = null;
    }
    
    
}
