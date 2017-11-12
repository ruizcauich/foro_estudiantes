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
public class Comentario extends Model{
    //int id;
    private int usuario;
    private Date fecha;
    private String contenido;
    private int publicacion;
    public Comentario(){}
    public Comentario(int id, int usuario, Date fecha, String contenido,int publicacion){
        this.id = id;
        this.usuario = usuario;
        this.fecha = fecha;
        this.contenido = contenido;
        this.publicacion = publicacion;
    }
    @Override
    public Model save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Model> getObjects(String[][] atributo_valor) {
        ArrayList<Model> comts = new ArrayList<Model>();
        String query = "SELECT * FROM Comentarios WHERE ";
        for( int atributo = 0; atributo< atributo_valor.length; atributo++){
            query += atributo_valor[ atributo ][0] + "='";
            query += atributo_valor[ atributo ][1] + "' ";
            if( atributo== (atributo_valor.length-1)){
                query += ";";
            }else{
                query += " OR ";
            }
        }
        ResultSet comentarios = this.connection.ejecutarConsulta(query);
        
        try {
            // Recupera datos de cada fila
            while( comentarios.next()){
                this.usuario = comentarios.getInt("usuario");
                this.fecha = comentarios.getDate("fecha");
                this.contenido = comentarios.getString("contenido");
                this.id = comentarios.getInt("id");
                
                
                
                comts.add( new Comentario(id, usuario, fecha, contenido, publicacion));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return comts;
    }

    @Override
    public ArrayList<Model> getAllObjects() {
        ArrayList<Model> comts = new ArrayList<Model>();
        ResultSet comentarios = this.connection.ejecutarConsulta("SELECT * FROM Comentarios;");
        
        try {
            // Recupera datos de cada fila
            while( comentarios.next()){
                this.usuario = comentarios.getInt("usuario");
                this.fecha = comentarios.getDate("fecha");
                this.contenido = comentarios.getString("contenido");
                this.id = comentarios.getInt("id");
                
                
                
                comts.add( new Comentario(id, usuario, fecha, contenido, publicacion));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return comts;
    }
    
    public String toString(){ return this.contenido;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
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

    public int getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(int publicacion) {
        this.publicacion = publicacion;
    }
    
}
