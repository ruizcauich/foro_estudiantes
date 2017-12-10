/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.Model;
import db.models.Publicacion;
import db.models.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author augusto
 */
@WebServlet(urlPatterns = {"/obtenerPublicaciones"})
public class obtenerPublicaciones extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Publicaciones</title>");            
            out.println("</head>");
            out.println("<body>");
            Publicacion pubs = new Publicacion();
            ArrayList<Model> listaPubs = pubs.getAllObjects();
            
            for(int i=0; i<listaPubs.size() && (i<= cont*5-1); i++){
                Publicacion pub = (Publicacion)listaPubs.get(i);
                Usuario us = new Usuario();
                String atributo_valor[][] = {{"id", ""+pub.getUsuario()}};
                
                us = (Usuario)us.getObjects(atributo_valor).get(0);
                String resumen ="";
                if( pub.getContenido().length()>=222){
                    resumen+=pub.getContenido().substring(0, 222);
                }else{
                    resumen+=pub.getContenido();
                            
                }
                String link_pub = 
"        <a href=\"\">\n" +
"            <article class=\"publicacion-link\">\n" +
"           <div class=\"avatar\">\n" +
"                <img src=\"obtenerAvatar?id="+us.getId()+"\" alt=\"\">\n" +
"            </div>\n" +
"            <div class=\"contenido\">\n" +
"                <div class=\"titulo\">\n" +
"                    <h2>"+ pub.getTopico()+"</h2>\n" +
"                </div>\n" +
"                <div class=\"datos\">\n" +
"                    <span class=\"usuario\">\n" +
"                        "+us.getNickname()+"\n" +
"                    </span>\n" +
"                    <span class=\"fecha-publicacion\">\n" +
"                        "+pub.getFecha().toString()+"\n" +
"                    </span>\n" +
"\n" +
"                </div>\n" +
"                <div class=\"resumen\">\n" +
"                    "+resumen+"\n" +
"                </div>\n" +
"            </div>\n" +
"        </article>\n" +
"        </a>";
                
                out.println(link_pub);
            }
            
            
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
