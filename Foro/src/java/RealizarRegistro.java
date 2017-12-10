/*
 * Nombre del archivo: RealizarRegistro.java
 * Descripción: Guarda en la base de datos, la información de un usuario
 *              que se esta registrando
 * Autor (es): Augusto Neftalí Ruiz Cauich, Eyden Villanueva Alpuche
 * Fecha de realización: 20-Noviembre-2017
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.models.Usuario;
import javax.servlet.http.Cookie;

/**
 *
 * @author augusto
 */
@WebServlet(urlPatterns = {"/RealizarRegistro"})
public class RealizarRegistro extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        response.setContentType("text/html;charset=UTF-8");
        try {
            /* TODO output your page here. You may use following sample code. */
            String nombre = request.getParameter("nombre");
            String appellidos = request.getParameter("apellidos");
            String inst = request.getParameter("institucion");
            String email = request.getParameter("email");
            String nickN = request.getParameter("nickname");
            String contrs = request.getParameter("contraseña");
            
            Usuario us = new Usuario(nombre, appellidos, inst, nickN, contrs, email, false);
            us.save();
            Cookie nickname = new Cookie("nickname", nickN);
            Cookie contrasena = new Cookie("contrasena", contrs);
            
            response.addCookie(nickname);
            response.addCookie(contrasena);
            
            response.sendRedirect("index.jsp");
        }catch(Exception e){
            out.println("Algo salio mal");
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
