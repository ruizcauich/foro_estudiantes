<%@ page import="db.models.Usuario" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="html.ControlSeguridad" %>
<%
    if( !ControlSeguridad.estaAutenticado(request) ) response.sendRedirect("login.jsp");
    
%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <link rel="shortcut icon" type="image/x-icon" href="img/logo-favicon.ico">
  <link rel="stylesheet" href="css/perfil.css">
  <link rel="stylesheet" href="css/contenedores.css">
  <link rel="stylesheet" href="css/menus.css">
  <link rel="stylesheet" href="css/botones.css">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  <script src="js/ajax.js"></script>
  <script src="js/perfil.js"></script>
  <title>Perfil</title>
</head>
<body>
  <header>
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
              </ul>
          </div>
      </nav>
  </header>
  <div class="contenedor-perfil">
    <div class="contenedor-avatar">
      <img id="avatar"  src="img/default-avatar.png" alt="No se pudo cargar la imagen">
      <form class="formulario-avatar" action="actualizarAvatar" enctype="multipart/form-data">
        <input id="cambiar_avatar" class="btn" hidden type="file" name="avatar" value="Elije una imagen"  >
        <input id="sumbit_avatar" class="btn" type="submit" value="Seleccionar avatar">
              </form>
    </div>
    <div class="contenedor-datos">
      <form class="formulario-perfil-datos" action="index.html" method="post">
          <input type="hidden" id="id" value="1" name="id">
        <div class="contenedor-campo">
          <label for="nombre">Nombre</label>
          <input type="text" name="nombre" value="Andres">
        </div>
        <div class="contenedor-campo">
          <label for="apellidos">Apellidos</label>
          <input type="text" name="apellidos" value="Ancala Montalvo">
        </div>
        <div class="contenedor-campo">
          <label for="institucion">Institución</label>
          <input type="text" name="institucion" value="UNAM">
        </div>
        <div class="contenedor-campo">
          <label for="nickname">Nickname</label>
          <input type="text" name="nickname" value="Andres Patricio">
        </div>
        <div class="contenedor-campo">
          <label for="email">Email</label>
          <input type="text" name="email" value="Andres@gmail.com">
        </div>
        <div class="contenedor-campo">
          <label for="contraseña">Contraseña</label>
          <input type="password" name="contraseña" value="contraseñadeAndres">
        </div>
        <div class="contenedor-campo">
          <label for="boton">Guarda tus Cambios</label>
          <input class="btn" type="submit" name="boton" value="Guardar">
        </div>

      </form>

    </div>
  </div>
</body>
</html>
