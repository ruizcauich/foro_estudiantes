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
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
/**
 *
 * @author augusto
 */
public class Usuario extends Model {
    
    private String nombre;
    private String apellidos;
    private String institucion;
    private String nickname;
    private String contrasena;
    private String email;
    private InputStream avatar;
    private boolean esModerador; 

  
    public Usuario( int id, String nombre, String apellidos, String
            institucion, String nickname, String contrasena, String
                    email,InputStream avatar, boolean esModerador){
        
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.institucion = institucion;
        this.nickname = nickname;
        this.contrasena = contrasena;
        this.email= email;
        this.avatar = avatar;
        this.esModerador = esModerador;
    }
    public Usuario( String nombre, String apellidos, String
            institucion, String nickname, String contrasena, String
                    email, boolean esModerador){
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.institucion = institucion;
        this.nickname = nickname;
        this.contrasena = contrasena;
        this.email= email;
        
        this.esModerador = esModerador;
    }
    
    public Usuario(){};
    
    @Override
    public Model save() {
        
        String [][] atributos = {{"nickname",nickname}};
        
        Usuario userAux =  new Usuario(nombre,apellidos,institucion,nickname,contrasena,email,esModerador);
        
        
        try{
            if(userAux.getObjects(atributos).isEmpty()){
                String query = "INSERT INTO Usuarios VALUES(NULL,'"+nombre+"','"+apellidos+"','"+institucion+"','"+nickname+"'"
                        + ",'"+contrasena+"','"+email+"','NULL','"+((esModerador)?'1':'0')+"');";
                if(connection.ejecutarInstruccion(query)){
                    return this;
                }
            }
            return null;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
    public boolean update(){
        try
        { 
            String query = "UPDATE Usuarios SET"
                    + " nombre = '"+nombre+"',"
                    + " apellidos = '"+apellidos+"',"
                    + " institucion = '"+institucion+"',"
                    + " nickname = '"+nickname+"',"
                    + " contrasena = '"+contrasena+"',"
                    + " email = '"+email+"',"
                    + " avatar = 'NULL',"
                    + " es_moderador = '"+((esModerador)?'1':'0')+"' WHERE nickname = '"+nickname+"';";
            
                if(connection.ejecutarInstruccion(query)){
                    return true;
                }
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ArrayList<Model> getObjects(String[][] atributo_valor) {
        ArrayList<Model> usrs = new ArrayList<Model>();
        String query = "SELECT * FROM Usuarios WHERE ";
        for( int atributo = 0; atributo< atributo_valor.length; atributo++){
            query += atributo_valor[ atributo ][0] + "='";
            query += atributo_valor[ atributo ][1] + "' ";
            if( atributo== (atributo_valor.length-1)){
                query += ";";
            }else{
                query += " OR ";
            }
        }
        ResultSet usuarios = this.connection.ejecutarConsulta(query);
        try {
            // Recupera datos de cada fila
            while( usuarios.next()){
                this.id = usuarios.getInt("id");
                this.nombre = usuarios.getString("nombre");
                this.apellidos = usuarios.getString("apellidos");
                this.institucion = usuarios.getString("institucion");
                this.nickname = usuarios.getString("nickname");
                this.contrasena = usuarios.getString("contrasena");
                this.email = usuarios.getString("email");
                this.avatar = usuarios.getBlob("avatar").getBinaryStream();
                this.esModerador = usuarios.getBoolean("es_moderador");
                usrs.add( new Usuario(id, nombre, apellidos, institucion,
                nickname, contrasena, email, avatar, esModerador)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usrs;
        
        
    }

    @Override
    public ArrayList<Model> getAllObjects() {
        ArrayList<Model> usrs = new ArrayList<Model>();
        ResultSet usuarios = this.connection.ejecutarConsulta("SELECT * FROM Usuarios;");
        
        try {
            // Recupera datos de cada fila
            while( usuarios.next()){
                this.id = usuarios.getInt("id");
                this.nombre = usuarios.getString("nombre");
                this.apellidos = usuarios.getString("apellidos");
                this.institucion = usuarios.getString("institucion");
                this.nickname = usuarios.getString("nickname");
                this.contrasena = usuarios.getString("contrasena");
                this.email = usuarios.getString("email");
                this.avatar = usuarios.getBlob("avatar").getBinaryStream();
                this.esModerador = usuarios.getBoolean("es_moderador");
                usrs.add( new Usuario(id, nombre, apellidos, institucion,
                nickname, contrasena, email, avatar, esModerador)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usrs;
    }
    
    @Override
    public boolean delete() {
        try{
            String query = "DELETE FROM Usuarios WHERE id = '"+id+"'";
            if(connection.ejecutarInstruccion(query))
            {
                return true;
            }
            return false;
        
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean actualizarAvatar(InputStream avatar) throws SQLException{
        
        
        String query = "Update Usuarios SET avatar = ?"+" WHERE id="+this.id;
        PreparedStatement ps = connection.getConnectionToDB().prepareStatement(query);
        ps.setBlob(1, avatar);
        ps.executeUpdate();
        
        return false;
    }

    
    public String toString(){ return nombre;} 
    
       
      public String getNombre() {
        return nombre;
    }
    
    public int getId(){
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InputStream getAvatar() throws SQLException {
        /*String query = "SELECT avatar from Usuarios WHERE id="+this.id;
        
        ResultSet av = this.connection.ejecutarConsulta(query);
        
            while( av.next()){
                return av.getBlob("avatar").getBinaryStream();
            }
            

                    //return ava.getBinaryStream();
        
        return null;*/
        return this.avatar;
        
    }

    public void setAvatar(InputStream avatar) {
        this.avatar = avatar;
    }

    public boolean isEsModerador() {
        return esModerador;
    }

    public void setEsModerador(boolean esModerador) {
        this.esModerador = esModerador;
    }

}
