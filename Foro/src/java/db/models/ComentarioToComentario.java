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
/**
 *
 * @author augusto
 */
public class ComentarioToComentario extends Model {
    private int comentarioPrincipal;
    private int comentarioSecundario;
    
    public ComentarioToComentario() {}
    public ComentarioToComentario(int id, int comentarioPrincipal, int comentarioSecundario){
        this.id = id;
        this.comentarioPrincipal = comentarioPrincipal;
        this.comentarioSecundario = comentarioSecundario;
    }

    
    @Override
    public Model save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Model> getObjects(String[][] atributo_valor) {
        ArrayList<Model> comts = new ArrayList<Model>();
        String query = "SELECT * FROM `Comentarios-Comentarios` WHERE ";
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
                this.id = comentarios.getInt("id");
                this.comentarioPrincipal = comentarios.getInt("comentarioPrincipal");
                this.comentarioSecundario = comentarios.getInt("comentarioSecundario");
                
                
                
                
                
                comts.add( new ComentarioToComentario(id, comentarioPrincipal, comentarioSecundario));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return comts;
    }

    @Override
    public ArrayList<Model> getAllObjects() {
        ArrayList<Model> comts = new ArrayList<Model>();
        ResultSet comentarios = this.connection.ejecutarConsulta("SELECT * FROM `Comentarios-Comentarios`");
        
        try {
            // Recupera datos de cada fila
            while( comentarios.next()){
                this.id = comentarios.getInt("id");
                this.comentarioPrincipal = comentarios.getInt("comentarioPrincipal");
                this.comentarioSecundario = comentarios.getInt("comentarioSecundario");
                
                
                
                
                
                comts.add( new ComentarioToComentario(id, comentarioPrincipal, comentarioSecundario));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comts;
    }

    public int getComentarioPrincipal() {
        return comentarioPrincipal;
    }

    public void setComentarioPrincipal(int comentarioPrincipal) {
        this.comentarioPrincipal = comentarioPrincipal;
    }

    public int getComentarioSecundario() {
        return comentarioSecundario;
    }

    public void setComentarioSecundario(int comentarioSecundario) {
        this.comentarioSecundario = comentarioSecundario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
