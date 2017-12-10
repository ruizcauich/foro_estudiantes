/*
 * Nombre del archivo: actualizarAvatar.java
 * Descripción: Recibe un id y una imagen para actualizar el avatar
 *              de un usuario
 * Autor (es): Augusto Neftalí Ruiz Cauich
 * Fecha de realización: 06-Diciembre-2017
 */

import db.models.Usuario;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author augusto
 */
@WebServlet(urlPatterns = {"/actualizarAvatar"})
public class actualizarAvatar extends HttpServlet {

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
        response.setContentType("image/jpeg");
        try {
//            PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            String id = request.getParameter("id");
            Part avatar = request.getPart("avatar");
            InputStream avatarFoto = avatar.getInputStream();
            
            Usuario n = new Usuario();
            String [][] atributo_valor = {{"id",id}};
            n = (Usuario)n.getObjects(atributo_valor).get(0);
            n.actualizarAvatar(avatarFoto);
            
            
            byte buff [] = new byte[16777215];
            //n.getAvatar().read(buff);
            
            
            ServletOutputStream o = response.getOutputStream();
            int tamano = 0;
            
            
            while( (tamano=avatarFoto.read(buff))>=0){
                o.write(buff, 0, tamano);
            }
        }
        catch(Exception e){
            e.printStackTrace();
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
