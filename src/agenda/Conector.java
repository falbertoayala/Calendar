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
    
    //COnsulta existencia de correo
    
    public boolean getCorreoTablauser(String user){
        
        conn = connectDB();
        String query = "select  userEmail from user ";
        PreparedStatement consulta = null;
        ResultSet resultadotabla = null;
        //String w = "";
        //StringBuilder tabla = new StringBuilder(w);
        
        try{
            consulta = conn.prepareStatement(query);
            resultadotabla = consulta.executeQuery();
                while (resultadotabla.next()){
                if(user.equals(resultadotabla.getString(1))){
                    return  true ;
                }

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
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
    
    //CODIGO QUE INSERTA EVENTOS
    
    public int insertarEventos(String eventName, String eventStart, String eventEnd){
        conn = connectDB();
        String query = " insert into events "
                + "(eventName, eventStart, eventEnd)" + 
                " values (?,?,?) ";
        PreparedStatement preStmt =null;
        try {
            preStmt = conn.prepareStatement(query);
            
            //preStmt.setInt(1, userId);
            preStmt.setString(1, eventName);
            preStmt.setString(2, eventStart);
            preStmt.setString(3, eventEnd);
                       
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
    }
    
      //CODIGO QUE CONSULTA AGENDA 
    public String getTablaEvent(String events){
        
        conn = connectDB();
        String query = " select * from events";
        PreparedStatement consulta = null;
        ResultSet resultadotabla = null;
        String w = "";
        StringBuilder tabla = new StringBuilder(w);
        
        try{
            consulta = conn.prepareStatement(query);
            consulta.setString(1, events);
            resultadotabla = consulta.executeQuery();
            tabla.append("evento|\tfecha Inicio|\tfecha fin\n");
            while (resultadotabla.next()){
                tabla.append(resultadotabla.getInt(1)).append("\t");
                tabla.append(resultadotabla.getString(2)).append("\t");
                tabla.append(resultadotabla.getString(3)).append("\n");
            }
            return tabla.toString();
        } catch (SQLException ex) {
            Logger.getLogger(Conector.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tabla.toString();
    }  
    




//CODIGO QUE INSERTA CORREO  
    
    public int insertarUsuarios(String userMail, String userName){
        conn = connectDB();
        String query = " insert into user "
                + "(userEmail, userName)" + 
                " values (?,?) ";
        PreparedStatement preStmt =null;
        try {
            preStmt = conn.prepareStatement(query);
            
            //preStmt.setInt(1, userId);
            preStmt.setString(1, userMail);
            preStmt.setString(2, userName);

           
            
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
