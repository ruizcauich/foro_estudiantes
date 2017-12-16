/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.models.Comentario;
import db.models.ComentarioToComentario;
import db.models.Publicacion;
import db.models.Usuario;
import html.ControlSeguridad;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author augusto
 */
@WebServlet(urlPatterns = {"/ComentarComentario"})
public class ComentarComentario extends HttpServlet {

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
           ControlSeguridad seguridad = new ControlSeguridad();
            
            if(seguridad.estaAutenticado(request)){
                //Obtenemos la fecha actual
                Date fechaActual = new Date();
                java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
                
                //Obtenemos el usuario en sesion
                Usuario usuario = seguridad.obtenerUsuarioEnSesion(request);
                
                //Creamos una nueva publicacion
                Publicacion publicacion = new Publicacion();
                
                //Obtengo el contenido del comentario de la respuesta
                String contenido = request.getParameter("comentario");
                //Obtengo el comentario seleccionado al que le haremos una replica
                int comentarioSeleccionado =Integer.parseInt( request.getParameter("comentarioSeleccionado"));
                
                //Obtengo el id de la publicacion
                int idPublicacion = Integer.parseInt(request.getParameter("publicacion"));
                
                //creo la matriz con el id de la publicacion
                String [][] atributo_valor = {{"id",String.valueOf(idPublicacion)}};
                
                //Obtengo la publicacion de la base de datos
                publicacion = (Publicacion)publicacion.getObjects(atributo_valor).get(0);
                
                //creamos el comentario secundario
                Comentario comentario = new Comentario(usuario.getId(),fechaSQL,contenido,publicacion.getId());
                // guardamos en la base de datos
                comentario.save();
                
                // traemos de la base de datos ya con un id
                String nuevoComentario[][]= {{"contenido", comentario.getContenido()}};
                // Espera a que la base de datos se ponga al día con
                // el comentario guardado
                while( comentario.getObjects(nuevoComentario).size()==0){}
                
                comentario = (Comentario)comentario.getObjects(nuevoComentario).get(0);
                
                // Creamos la relación entre los comentarios
                ComentarioToComentario cTc = new ComentarioToComentario();
                cTc.setComentarioPrincipal(comentarioSeleccionado);
                cTc.setComentarioSecundario( comentario.getId());
                cTc.save();
                
                
            }
            else{
                out.println("<h1> No autenticado</h1>");
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
