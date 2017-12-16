/*
* Nombre del archivo: Conexion.java
* Descripción: Clase que representa una conexión a la base de datos
*               del proyecto;
* Autor (es): Augusto Neftalí Ruiz Cauich
* Fecha de realización: 07-Novienbre-2017
*/

package db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    //Configuracion de los datos de la BD
    private String usuario = "root";
    private String pass = "";
    private String host = "localhost";
    private String nombre_BD = "Foro";
    
    private Connection con = null;
    private Statement st;
    public Connection getConnectionToDB(){
        return con;
    }
    public Conexion() {
         
    }
    public void desconectar(){
        try {
            if(!con.isClosed()) con.close();
            if(!st.isClosed()) st.close();
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance( );
            String servidor = "jdbc:mysql://"+host+"/"+nombre_BD;
            con = DriverManager.getConnection(servidor,usuario,pass);
            st = con.createStatement();
            
        }catch(Exception e){
            e.printStackTrace();
            
        }
    }
    public ResultSet ejecutarConsulta( String query){
         try {
             conectar();
            return  st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean ejecutarInstruccion(String query){
        try {
            conectar();
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
