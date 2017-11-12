/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author augusto
 */
import db.models.*;
public class Tests {
    public static void main(String[] args){
        Publicacion p = new Publicacion();
        
        System.out.println( p.getObjects(new String[][]{{"topico","kjnkjnk"}}) );
        
    }
    
}
