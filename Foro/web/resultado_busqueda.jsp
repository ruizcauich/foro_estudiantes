<%@ page import="html.Header" %>
<%@ page import="html.ControlSeguridad" %>
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


    </section>
    <footer>

    </footer>

</body>
</html>
