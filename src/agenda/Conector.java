    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.sqlite.SQLiteDataSource;

/**
 *
 * @author Francisco
 */

    
    
    
    public class Conector {
    private DataSource ds;
    private Connection conn;
    
    public Conector() {
        ds = SQLDatasource.getSQLLiteDataSource();
        conn = null;
    }
    
    private Connection connectDB(){
        try {
            conn = this.ds.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return conn;
    }
    
    private void disconnectDB(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     //CODIGO QUE CONSULTA CORREOS   
    public String getTablaCalendar(String user){
        
        conn = connectDB();
        String query = " select * from Calendar";
        PreparedStatement consulta = null;
        ResultSet resultadotabla = null;
        String w = "";
        StringBuilder tabla = new StringBuilder(w);
        
        try{
            consulta = conn.prepareStatement(query);
            consulta.setString(1, user);
            resultadotabla = consulta.executeQuery();
            tabla.append("user|\tCorreo\n");
            while (resultadotabla.next()){
                tabla.append(resultadotabla.getInt(1)).append("\t");
                tabla.append(resultadotabla.getString(2)).append("\t");
                tabla.append(resultadotabla.getDouble(3)).append("\n");
            }
            return tabla.toString();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla.toString();
    }
    
    public String getInformacionTablauser(){
        conn = connectDB();
        String query = " select * from user";
        PreparedStatement consulta = null;
        ResultSet resultadotabla = null;
        String w = "";
        StringBuilder tabla = new StringBuilder(w);
        
        try{
            consulta = conn.prepareStatement(query);
            resultadotabla = consulta.executeQuery();
            tabla.append("userId|\tCorreo|\tNombre \n");
            while (resultadotabla.next()){
                tabla.append(resultadotabla.getInt(1)).append("\t");
                tabla.append(resultadotabla.getString(2)).append("\t");
                tabla.append(resultadotabla.getString(3)).append("\t \n");
            }
            return tabla.toString();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla.toString();
    }

    String getInformacionTablauser(String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
    //CODIGO QUE INSERTA CORREO  
    //public void insertar(Usuarios p){
    //public String insertarUsuarios(Usuarios p){  
    public int insertarUsuarios(int userId, String userMail, String userName){
        conn = connectDB();
        String query = " insert into user "
                + "(userId, userEmail, userName)" + 
                " values (?,?,?) ";
        PreparedStatement preStmt =null;
        try {
            preStmt = conn.prepareStatement(query);
            preStmt.setInt(1, userId);
            preStmt.setString(2, userMail);
            preStmt.setString(3, userName);

           
            
            preStmt.executeUpdate();
            /*boolean result = preStmt.execute();
            if(result){
                return 0;
            }
            else{
                return 1;
            }*/
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if (preStmt != null) {
                    preStmt.close();
                }
                if (conn != null) {
                    disconnectDB(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
        //return null;
        
    
    }
}
