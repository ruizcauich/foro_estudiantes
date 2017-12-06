package html;


import db.models.Usuario;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author augusto
 */
public class ControlSeguridad {
    public static boolean estaAutenticado(HttpServletRequest request){
        try{
            Cookie cookies[] = request.getCookies();
            String nickname = "";
            String contrasena ="";
            for(int i=0; i<cookies.length; i++ ){
                if(cookies[i].getName().equals("nickname")){
                    nickname = cookies[i].getValue();
                    continue;
                }
                if(cookies[i].getName().equals("contrasena")){
                    contrasena = cookies[i].getValue();

                }

            }
            Usuario us = new Usuario();
            String a[][] = {{"nickname",nickname}};
            us = (Usuario) us.getObjects(a).get(0);
            
            return us.getContrasena().equals(contrasena);
        }catch(Exception e){ }
        
        return false;
    }
}
