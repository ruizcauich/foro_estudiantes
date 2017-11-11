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
import java.util.logging.Level;
import java.util.logging.Logger;
import html.HtmlModel;
/**
 *
 * @author augusto
 */
public class Usuario extends Model implements HtmlModel {
    
    private String nombre;
    
    public Usuario( int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
    
    public Usuario(){};
    
    @Override
    public Model save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Model> getObjects(String[] params) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Model> getAllObjects() {
        ArrayList<Model> usrs = new ArrayList<Model>();
        ResultSet usuarios = this.connection.ejecutarConsulta("SELECT * FROM Usuarios;");
        
        try {
            // Recupera datos de cada fila
            while( usuarios.next()){
                int id = usuarios.getInt("id");
                String nombre = usuarios.getString("nombre");
                usrs.add( new Usuario(id, nombre));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usrs;
    }

    @Override
    public String toHtml() {
        return "<h1>" + nombre+ "</h1>";
    }
    
}
