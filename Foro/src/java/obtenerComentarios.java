/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.Model;
import db.models.Comentario;
import db.models.ComentarioToComentario;
import db.models.Publicacion;
import db.models.Usuario;
import html.ControlSeguridad;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author augusto
 */
@WebServlet(urlPatterns = {"/obtenerComentarios"})
public class obtenerComentarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            int cont = Integer.parseInt( request.getParameter("cont") );
            String pubId =  request.getParameter("publicacion");
            String [][] atributo_valor_pub = {{"id", pubId}};
            
            Publicacion pub = new Publicacion();
            pub = (Publicacion)pub.getObjects(atributo_valor_pub).get(0);
            
            Comentario com = new Comentario();
            String [][] atributo_valor = {{"publicacion", pubId}};
            ArrayList<Model> coms = com.getObjects( atributo_valor );
            // comentarios a comentarios
            ComentarioToComentario comToCom = new ComentarioToComentario();
            // obtener todas las relaciones comentario-comentario
            ArrayList<Model> comsToComs = comToCom.getAllObjects();
            
            //Obtener el usuario en sesion
            ControlSeguridad control = new ControlSeguridad();
            Usuario usuarioEnSesion = control.obtenerUsuarioEnSesion(request);
            
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cometarios</title>");            
            out.println("</head>");
            out.println("<body>");
            
            for(int i=0; i<coms.size(); i++){
                // obtenemos el comentario a evaluar si es secundario
                com = (Comentario)coms.get(i);
                
                for(int j=0; j< comsToComs.size(); j++){
                    comToCom = (ComentarioToComentario)comsToComs.get(j);
                    if( com.getId() ==comToCom.getComentarioSecundario() ){
                        coms.remove(i);
                        // por que se quita un comentario se debe quitar uno al
                        // contador
                        i--;
                        break;
                    }
                }
            }
            String impComs = "";

            for( int i = 0; i<coms.size()&& i<cont*4; i++){
                com = (Comentario)coms.get(i);
                String us_id[][]={{"id", ""+ com.getUsuario()}};
                Usuario us = (Usuario)(new Usuario()).getObjects( us_id ).get(0);
                impComs += "<li>\n" +
"        <div class=\"comment-main-level\">\n" +
"          <!--AVATAR -->\n" +
"          <div class=\"comment-avatar\">\n" +
"            <img src=\"obtenerAvatar?id="+us.getId()+"\" alt=\"No se encontró la imagen\">\n" +
"          </div>\n" +
"          <!-- Contenedor del comentario  -->\n" +
"          <div class=\"comment-box\">\n" +
"            <div class=\"comment-head\">\n";
                
                
                if(com.getUsuario() == pub.getUsuario()){
                 impComs+=
"              <h6 class=\"comment-name by-author\"><a href=\"#\">"+us.getNickname()+"</a></h6>\n";

                }
                else{
                    impComs+=
"              <h6 class=\"comment-name\"><a href=\"#\">"+us.getNickname()+"</a></h6>\n";
                }
                
                impComs+=
"              <span>" + com.getFecha()+ "</span>\n";
                if(usuarioEnSesion.getId() == com.getUsuario() || usuarioEnSesion.isEsModerador()){
                impComs +=
 "              <i data-eliminado=\""+com.getId()+"\" class=\"fa fa-window-close\" aria-hidden=\"true\"></i>\n";                       
                }
                if(usuarioEnSesion.getId() == com.getUsuario()){    
               impComs+=
"              <i data-actualizado=\""+com.getId()+"\" class=\"fa fa-pencil\" aria-hidden=\"true\"></i>\n";                                       
                }
      
                impComs +=
"              <i data-comentario=\""+com.getId()+"\" class=\"fa fa-reply\" aria-hidden=\"true\"></i>\n" +
"            </div>\n" +
"            <div class=\"comment-content\">\n" +
                        com.getContenido()+
//"              Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et\n" +
//"              dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\n" +
"            </div>\n" +
"          </div>\n" +
"        </div>\n" +
"\n" +
"        <!--Comentario Anidado -->\n" +
"        <ul class=\"comments-list reply-list\">";
                
                
                
                
                // obtener relacion comentario-comentarios secundarios
                String atributo_valor_[][] ={{"comentarioPrincipal", ""+com.getId()}};
                comsToComs = comToCom.getObjects( atributo_valor_ );
                for(int j=0; j<comsToComs.size(); j++ ){
                    //para traer el comentario secundario corespondiente
                   String comentario_sec[][] ={{
                       "id",
                       ""+((ComentarioToComentario)comsToComs.get(j)).getComentarioSecundario()
                   }}; 
                   
                   Comentario com_sec = (Comentario) (new Comentario()).getObjects(comentario_sec).get(0);
                   String[][] us_id_={{"id", ""+ com_sec.getUsuario()}};
                   us = (Usuario)(new Usuario()).getObjects(us_id_).get(0);
                   impComs+="<li>\n" +
"            <!--AVATAR -->\n" +
"            <div class=\"comment-avatar\">\n" +
"              <img src=\"obtenerAvatar?id="+us.getId()+"\" alt=\"No se encontró la imagen\">\n" +
"            </div>\n" +
"            <!-- Contenedor del comentario  -->\n" +
"            <div class=\"comment-box\">\n" +
"              <div class=\"comment-head\">\n" +
"                <h6 class=\"comment-name\"><a href=\"#\">"+us.getNickname()+"</a></h6>\n" +
"                <span>"+ com_sec.getFecha()+ "</span>\n";
                if(usuarioEnSesion.getId() == com_sec.getUsuario() || usuarioEnSesion.isEsModerador()){
                impComs +=
 "              <i data-eliminado=\""+com_sec.getId()+"\" class=\"fa fa-window-close\" aria-hidden=\"true\"></i>\n";                       
                }                   
                   
                if(usuarioEnSesion.getId() == com_sec.getUsuario()){    
                 impComs+=
"              <i data-actualizado=\""+com_sec.getId()+"\" class=\"fa fa-pencil\" aria-hidden=\"true\"></i>\n";                                       
                }
                impComs +=             
//"                <i class=\"fa fa-heart\" aria-hidden=\"true\"></i>\n" +
//"                <i class=\"fa fa-reply\" aria-hidden=\"true\"></i>\n" +
"              </div>\n" +
"              <div class=\"comment-content\">\n" +
                           com_sec.getContenido()+
//"                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et\n" +
//"                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud\n" +
"              </div>\n" +
"            </div>\n" +
"          </li>";
                }
            impComs +=" </ul>\n" +
"      </li>";
                
            }
            
            out.println(impComs);
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
