/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import db.models.Usuario;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
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
@WebServlet(urlPatterns = {"/obtenerAvatar"})
public class obtenerAvatar extends HttpServlet {

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
        
        try  {
            /* TODO output your page here. You may use following sample code. */
            String id = request.getParameter("id");
            
            
            Usuario n = new Usuario();
            String [][] atributo_valor = {{"id",id}};
            n = (Usuario)n.getObjects(atributo_valor).get(0);
            
            
            
            response.reset();
            //response.setContentType("image/png");
            ServletContext sc = getServletContext();
            response.setContentType(sc.getMimeType("h.jpg"));
            response.addHeader("Content-Disposition","filename=avatar.jpg");
            
            ServletOutputStream o = response.getOutputStream();
            /*
            BufferedInputStream bin = new BufferedInputStream(n.getAvatar());  
            BufferedOutputStream bout = new BufferedOutputStream(o); 

            int ch=0;   
            while((ch=bin.read())!=-1)  
            {  
                bout.write(ch);  
            }  
            if(bin!=null)bin.close();  
            
            if(bout!=null)bout.close();  
            
            */
            int tamano = 0;
            byte buff [] = new byte[16777215];
            while( (tamano=n.getAvatar().read(buff))>=0){
                o.write(buff,0, tamano);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(obtenerAvatar.class.getName()).log(Level.SEVERE, null, ex);
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