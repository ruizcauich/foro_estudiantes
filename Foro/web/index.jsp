<%--
 * Nombre del archivo: index.jsp
 * Descripci�n: P�gina principal del sistema
 *
 * Autor (es): Dindier Alexander Pot Mukul, Augusto Neftal� Ruiz Cauich, Eyden Villanueva Alpuche
 * Fecha de realizaci�n: 11-Noviembre-2017, 10-Diciembre-2017
 --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Inicio</title>
    <link rel="shortcut icon" type="image/x-icon" href="img/logo-favicon.ico">
    <link rel="stylesheet" href="css/contenedores.css">
    <link rel="stylesheet" href="css/menus.css">
    <link rel="stylesheet" href="css/botones.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <script src="js/publicacionesRecientes.js"></script>
    <script src="js/ajax.js"></script>
</head>
<body>
    <header>
        <nav>
            <div class="contenedor">
              <a href="index.html"><img id="logo" src="img/gif2.gif"></a>
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
    </header>
    <section class="contenedor">
       <div class="contenedor-contenido">
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
           <input id="mostrar_mas" type="button" class="btn" value="Mostrar m�s">
       </div>
        
        <aside id="navegacion-lateral">
            <div class="resumen-usuario">
               <span class="avatar"><img src="img/default-avatar.png" alt=""></span>
               <h3 class="nombre_usuario">Nombre de usuario</h3>
            </div>
            <div class="area-de-notificacion">
               <h4>Notificaciones</h4>
                <div class="notificacion">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Beatae quasi odit magnam perspiciatis delectus quisquam eaque, ducimus doloremque quaerat provident at, voluptatum alias sed rem tempore neque culpa maxime asperiores.
                </div>
                <div class="notificacion">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Beatae quasi odit magnam perspiciatis delectus quisquam eaque, ducimus doloremque quaerat provident at, voluptatum alias sed rem tempore neque culpa maxime asperiores.
                </div>
                <div class="notificacion">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Beatae quasi odit magnam perspiciatis delectus quisquam eaque, ducimus doloremque quaerat provident at, voluptatum alias sed rem tempore neque culpa maxime asperiores.
                </div>
                <div class="notificacion">
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit. Beatae quasi odit magnam perspiciatis delectus quisquam eaque, ducimus doloremque quaerat provident at, voluptatum alias sed rem tempore neque culpa maxime asperiores.
                </div>
            </div>
        </aside>
        
    </section>

    <footer>

    </footer>

</body>
</html>
