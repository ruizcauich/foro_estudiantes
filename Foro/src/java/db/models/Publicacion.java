/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db.models;
import db.Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author augusto
 */
public class Publicacion extends Model{
    private int usuario;
    //private int id;
    private Date fecha;
    private String contenido;
    private String topico;
    
    public Publicacion(){};
    public Publicacion(int usuario,int id,Date fecha,String contenido,String topico){
        this.usuario = usuario;
        this.id = id;
        this.fecha = fecha;
        this.contenido = contenido;
        this.topico = topico;
    }
    
    public Publicacion(int usuario, Date fecha, String contenido, String topico){
        this.usuario = usuario;
        this.fecha = fecha;
        this.contenido = contenido;
        this.topico = topico;
    
    }

   
    @Override
    public Model save() {
        try{
            String query = "INSERT INTO Publicaciones VALUES('"+usuario+"',NULL,'"+fecha+"','"+contenido+"'"
                + ",'"+topico+"');";
               
            if(connection.ejecutarInstruccion(query)){
                connection.desconectar();
                return this;
            }
            connection.desconectar();
            return null;
        }catch(Exception e){
            e.printStackTrace();
            connection.desconectar();
            return null;
        }
    }
    
    
    @Override
    public boolean update() {
      try{
          
            String query = "UPDATE Publicaciones SET"
                  + " usuario = '"+usuario+"',"
                  + " fecha = '"+fecha+"',"
                  + " contenido = '"+contenido+"',"
                  + " topico = '"+topico+"' WHERE id = '"+id+"';";
            
            if(connection.ejecutarInstruccion(query)){
                connection.desconectar();
                return true;
            }
            connection.desconectar();
            return false;
      }catch(Exception e){
          e.printStackTrace();
          connection.desconectar();
          return false;
      }
    }
    public ArrayList<Model> getObjectsLike(String cad){
        ArrayList<Model> pubs = new ArrayList<Model>();            
        ResultSet publicaciones = this.connection.ejecutarConsulta(
                "SELECT * FROM Publicaciones WHERE contenido LIKE '%"+cad+"%' or"
                        + " topico LIKE '%"+cad+"%' ORDER By fecha DESC;"
        );
        
        try {
            // Recupera datos de cada fila
            while( publicaciones.next()){
                this.usuario = publicaciones.getInt("usuario");
                this.id = publicaciones.getInt("id");
                this.fecha = publicaciones.getDate("fecha");
                this.contenido = publicaciones.getString("contenido");
                this.topico = publicaciones.getString("topico");
                pubs.add( new Publicacion(usuario, id, fecha, contenido, topico));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection.desconectar();
        return pubs;
    }
    @Override
    public ArrayList<Model> getObjects(String[][] atributo_valor) {
        ArrayList<Model> pubs = new ArrayList<Model>();
        String query = "SELECT * FROM Publicaciones WHERE ";
        for( int atributo = 0; atributo< atributo_valor.length; atributo++){
            query += atributo_valor[ atributo ][0] + "='";
            query += atributo_valor[ atributo ][1] + "' ";
            if( atributo== (atributo_valor.length-1)){
                query += ";";
            }else{
                query += " OR ";
            }
        }
        ResultSet publicaciones = this.connection.ejecutarConsulta(query);
        try {
            // Recupera datos de cada fila
            while( publicaciones.next()){
                this.usuario = publicaciones.getInt("usuario");
                this.id = publicaciones.getInt("id");
                this.fecha = publicaciones.getDate("fecha");
                this.contenido = publicaciones.getString("contenido");
                this.topico = publicaciones.getString("topico");
                pubs.add( new Publicacion(usuario, id, fecha, contenido, topico));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection.desconectar();
        return pubs;
    }

    @Override
    public ArrayList<Model> getAllObjects() {
        ArrayList<Model> pubs = new ArrayList<Model>();            
        ResultSet publicaciones = this.connection.ejecutarConsulta("SELECT * FROM Publicaciones ORDER By fecha DESC;");
        
        try {
            // Recupera datos de cada fila
            while( publicaciones.next()){
                this.usuario = publicaciones.getInt("usuario");
                this.id = publicaciones.getInt("id");
                this.fecha = publicaciones.getDate("fecha");
                this.contenido = publicaciones.getString("contenido");
                this.topico = publicaciones.getString("topico");
                pubs.add( new Publicacion(usuario, id, fecha, contenido, topico));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection.desconectar();
        return pubs;
    }
    
    @Override
    public boolean delete() {
        try{
            String query = "DELETE FROM Publicaciones WHERE id = '"+id+"'";
            if(connection.ejecutarInstruccion(query))
            {
                connection.desconectar();
                return true;
            }
            connection.desconectar();
            return false;
        
        }catch (Exception e) {
            e.printStackTrace();
            connection.desconectar();
            return false;
        }
    }
    
    public String toString(){return this.topico;}
     public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTopico() {
        return topico;
    }

    public void setTopico(String topico) {
        this.topico = topico;
    }



}
