<%@page import="java.util.ArrayList"%>
<%@ page import="html.Header" %>
<%@ page import="html.ControlSeguridad" %>
<%@ page import="db.models.Publicacion" %>
<%@ page import="db.models.Usuario" %>
<%@ page import="db.Model" %>
<% Header head = new Header(ControlSeguridad.estaAutenticado(request));%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
    <link rel="shortcut icon" type="image/x-icon" href="img/logo-favicon.ico">
    <link rel="stylesheet" href="css/contenedores.css">
    <link rel="stylesheet" href="css/menus.css">
    <link rel="stylesheet" href="css/titulos.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>
    <%--<header>
        <nav>
            <div class="contenedor">
              <a href="index.jsp"><img id="logo" src="img/gif2.gif"></a>
               <div class="busqueda">
                   <form action="#">
                       <input type="text" name="buscar">
                       <button  class="boton" type="submit">Buscar</button>
                   </form>
               </div>
                <ul class="menu">
                    <li><a href="perfil.jsp">Perfil</a></li>
                    <li><a href="login.jsp">Login</a></li>
                    <li><a href="registro.jsp">Registrar</a></li>
                </ul>
            </div>
        </nav>
    </header>--%>
    <%=head.toHtml()%>
    <section class="contenedor">
     <br>
      <h2 class="titulo_h2">
          Resultados de la busqueda:
      </h2>
     <%  
         Publicacion pub = new Publicacion();
         ArrayList<Model> pubs =  pub.getObjectsLike( request.getParameter("buscar") );
     %>
        
     <%
         for(int i = 0; i<pubs.size(); i++){
             pub = (Publicacion)pubs.get(i);
             Usuario us = new Usuario();
             String [][] att_val = {{"id",""+pub.getUsuario()}};
             us = (Usuario) us.getObjects(att_val).get(0);
     %>
        
        <a href="">
            <article class="publicacion-link">
                <div class="avatar">
                     <img src="obtenerAvatar?id=<%=us.getId()%>" alt="">
                </div>
                <div class="contenido">
                    <div class="titulo">
                        <h2><%=pub.getTopico()%></h2>
                    </div>
                    <div class="datos">
                        <span class="usuario">
                            <%=us.getNickname()%>
                        </span>
                        <span class="fecha-publicacion">
                            <%=pub.getFecha().toString()%>
                        </span>

                    </div>
                    <div class="resumen">
                        <%
                            if(pub.getContenido().length()>=220){
                                out.print(pub.getContenido().substring(0, 220));
                            }
                            else{
                                out.print(pub.getContenido());
                            }
                        %>
                        
                    </div>
                 </div>
            </article>
        </a>
     <%
         }
     %>
        <%--<a href="">
            <article class="publicacion-link">
           <div class="avatar">
                <img src="img/default-avatar.png" alt="">
            </div>
            <div class="contenido">
                <div class="titulo">
                    <h2>Lorem ipsum dolor sit amet, consectetur.</h2>
                </div>
                <div class="datos">
                    <span class="usuario">
                        Usuario
                    </span>
                    <span class="fecha-publicacion">
                        12-Julio-2017
                    </span>

                </div>
                <div class="resumen">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sint deserunt velit nihil, dolorem culpa perspiciatis eum harum itaque quos voluptas, molestiae blanditiis quae vitae, facere nisi est. Culpa est, ullam?
                </div>
            </div>
        </article>
        </a>
        <a href="">
            <article class="publicacion-link">
           <div class="avatar">
                <img src="img/default-avatar.png" alt="">
            </div>
            <div class="contenido">
                <div class="titulo">
                    <h2>Lorem ipsum dolor sit amet, consectetur.</h2>
                </div>
                <div class="datos">
                    <span class="usuario">
                        Usuario
                    </span>
                    <span class="fecha-publicacion">
                        12-Julio-2017
                    </span>

                </div>
                <div class="resumen">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sint deserunt velit nihil, dolorem culpa perspiciatis eum harum itaque quos voluptas, molestiae blanditiis quae vitae, facere nisi est. Culpa est, ullam?
                </div>
            </div>
        </article>
        </a>
        <a href="">
            <article class="publicacion-link">
           <div class="avatar">
                <img src="img/default-avatar.png" alt="">
            </div>
            <div class="contenido">
                <div class="titulo">
                    <h2>Lorem ipsum dolor sit amet, consectetur.</h2>
                </div>
                <div class="datos">
                    <span class="usuario">
                        Usuario
                    </span>
                    <span class="fecha-publicacion">
                        12-Julio-2017
                    </span>

                </div>
                <div class="resumen">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sint deserunt velit nihil, dolorem culpa perspiciatis eum harum itaque quos voluptas, molestiae blanditiis quae vitae, facere nisi est. Culpa est, ullam?
                </div>
            </div>
        </article>
        </a>--%>


    </section>
    <footer>

    </footer>

</body>
</html>
