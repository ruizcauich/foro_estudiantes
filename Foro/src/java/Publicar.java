/*
 * Nombre del archivo: Publicar.java
 * Descripción: Guarda en la base de datos una publicación
 * Autor (es):  Eyden Villanueva Alpuche
 * Fecha de realización: 03-Diciembre-2017
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import db.models.Publicacion;
import db.models.Usuario;
import html.ControlSeguridad;
//import java.sql.Date;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
        

/**
 *
 * @author Eyden Villanueva
 */
@WebServlet(urlPatterns = {"/Publicar"})
public class Publicar extends HttpServlet {

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
            throws ServletException, IOException, InstantiationException, IllegalAccessException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            ControlSeguridad seguridad = new ControlSeguridad();
            
            if(seguridad.estaAutenticado(request))
            {
                Cookie cookies[] = request.getCookies();
                String nickname = "";
                String contrasena = "";
                
                for(int i = 0; i < cookies.length; i++)
                {
                    if(cookies[i].getName().equals("nickname"))
                    {
                        nickname = cookies[i].getValue();
                        continue;
                    }
                    if(cookies[i].getName().equals("contrasena"))
                    {
                        contrasena = cookies[i].getValue();
                    }
                }
                
                Usuario user;
                
                String [][] atributo_valor = {{"nickname",nickname}};
                
                user = (Usuario)db.models.Usuario.class.newInstance().getObjects(atributo_valor).get(0);
                
                int idUsuario = user.getId();
                String contenido =  request.getParameter("contenido");
                String titulo = request.getParameter("titulo");
                Date fechaActual = new Date();
                java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
                
                Publicacion pub = new Publicacion(idUsuario,fechaSQL,contenido,titulo);
                pub.save();
                
                String [][] datos = {{"topico",titulo},{"contenido",contenido}};
                pub = (Publicacion)pub.getObjects(datos).get(0);
                
                response.sendRedirect("publicacion.jsp?publicacion="+pub.getId());
                
                
            }
            else
            {
                response.sendRedirect("login.jsp");
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
        } catch (InstantiationException ex) {
            Logger.getLogger(Publicar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Publicar.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (InstantiationException ex) {
            Logger.getLogger(Publicar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Publicar.class.getName()).log(Level.SEVERE, null, ex);
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
