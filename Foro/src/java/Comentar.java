/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.models.Comentario;
import db.models.Publicacion;
import db.models.Usuario;
import db.models.ComentarioToComentario;
import html.ControlSeguridad;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * Nombre del archivo: Comentar.java
 * Descripción: Guarda un comentario en la base de datos
 *              
 * Autor (es): Eyden Villanueva, Augusto Ruíz, Dindier Moo Mukul
 * Fecha de realización: 14-Noviembre-2017
 */

/**
 *
 * @author Eyden Villanueva
 */
public class Comentar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IllegalAccessException, InstantiationException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            ControlSeguridad seguridad = new ControlSeguridad();
            
            if(seguridad.estaAutenticado(request)){
                
                Date fechaActual = new Date();
                java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
                   
                Usuario usuario = seguridad.obtenerUsuarioEnSesion(request);
                Publicacion publicacion;
                
                String contenido = request.getParameter("comentario");
                
                int idPublicacion = Integer.parseInt(request.getParameter("idPublicacion"));
                String [][] atributo_valor = {{"id",String.valueOf(idPublicacion)}};
                
                publicacion = (Publicacion)db.models.Publicacion.class.newInstance().getObjects(atributo_valor).get(0);
                
                Comentario comentario = new Comentario(usuario.getId(),fechaSQL,contenido,publicacion.getId());
                comentario.save();
                
                
            }
            

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
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Comentar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Comentar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Comentar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Comentar.class.getName()).log(Level.SEVERE, null, ex);
        }
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
