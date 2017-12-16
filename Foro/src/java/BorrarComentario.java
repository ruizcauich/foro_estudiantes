/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.models.Comentario;
import html.ControlSeguridad;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/*
 * Nombre del archivo: BorrarComentario.java
 * Descripción: Servlet Destinado a la eliminación de comentarios
 *              
 * Autor (es): Eyden Villanueva
 * Fecha de realización: 16-Noviembre-2017
 */


/**
 *
 * @author Eyden Villanueva
 */
@WebServlet(urlPatterns = {"/BorrarComentario"})
public class BorrarComentario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            /*
                Obtener los parátros del comentario seleccionado
                Hacer un getObjects para tener el comentario que queremos eliminar
                Se lo asignamos a un objeto de tipo comentario 
                Lo eliminamos de la base de datos con un delete
            */
            

                int id = Integer.parseInt(request.getParameter("comentario"));
                
                Comentario comentario = new Comentario ();
                String [][] atributo_valor = {{"id",String.valueOf(id)}};
                comentario = (Comentario)comentario.getObjects(atributo_valor).get(0);
                
                comentario.delete();

            
            
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
