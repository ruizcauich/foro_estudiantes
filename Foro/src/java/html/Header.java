/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package html;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author augusto
 */
public class Header implements HtmlModel {
    boolean estaAutenticado;
    public Header( boolean estaAutenticado ){
        this.estaAutenticado = estaAutenticado;
    }
    @Override
    public String toHtml() {
        String headerMenu = " <header>\n" +
"        <nav>\n" +
"            <div class=\"contenedor\">\n" +
"              <a href=\"index.html\"><img id=\"logo\" src=\"img/gif2.gif\"></a>\n" +
"               <div class=\"busqueda\">\n" +
"                   <form action=\"resultado_busqueda.jsp\" method=\"get\">\n" +
"                       <input type=\"text\" name=\"buscar\">\n" +
"                       <button  class=\"boton\" type=\"submit\">Buscar</button>\n" +
"                   </form>\n" +
"               </div>\n" +
"                <ul class=\"menu\">\n" +
"                    <li><a href=\"/\">Inicio</a></li>\n" +
"                    <li><a href=\"perfil.jsp\">Perfil</a></li>\n" +
                ((!estaAutenticado)?
"                    <li><a href=\"login.jsp\">Login</a></li>\n":"<li><a href=\"publicar.jsp\">Publicar Post</a></li>\n") +
               ((!estaAutenticado)?
"                    <li><a href=\"registro.jsp\">Registrar</a></li>\n":"") +
"                </ul>\n" +
"            </div>\n" +
"        </nav>\n" +
"    </header>";
        
        return headerMenu;
    }
    
}
