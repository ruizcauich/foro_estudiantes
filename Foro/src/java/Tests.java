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
        Usuario us = new Usuario(2,"Jose","alfredo","uady","jose","jose","jose","",true);
       // us.save();
       String[][] a = {{"nombre","Jose"}};
        
        
        
        
        us = (Usuario)us.getObjects(a).get(0);
        System.out.println(us.isEsModerador());
        
        
        
        
    }
    
}
