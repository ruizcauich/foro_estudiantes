/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author augusto
 */
import db.models.Usuario;
public class Tests {
    public static void main(String[] args){
        Usuario us = new Usuario();
        String [][] atributos = {{"nombre","eyden"},{"id", "1"}};
        System.out.println( us.getObjects(atributos) );
        System.out.println( us );
        
    }
    
}
