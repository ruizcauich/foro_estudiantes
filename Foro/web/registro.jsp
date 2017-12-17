<%-- 
 * Nombre del archivo: perfil.jsp
 * Descripci�n: Muestrar un formulario al usuario para que pesda
 *               realizar una publicaci�n
 * Autor (es): Augusto Neftal� Ruiz Cauich, Eyden Villanueva Alpuche
 * Fecha de realizaci�n: 11-Noviembre-2017
 --%>
 <%@ page import="html.Header" %>
<%@ page import="html.ControlSeguridad" %>
<% Header head = new Header(ControlSeguridad.estaAutenticado(request));%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Registro</title>
  <link rel="shortcut icon" type="image/x-icon" href="img/logo-favicon.ico">
  <link rel="stylesheet" href="css/registro.css">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
  <link rel="stylesheet" href="css/menus.css">
  <link rel="stylesheet" href="css/contenedores.css">
  <link rel="stylesheet" href="css/botones.css">
  <link rel="stylesheet" href="css/titulos.css">
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
                  <li><a href="login.jsp">Login</a></li>
                  <li><a href="registro.jsp">Registrar</a></li>
              </ul>
          </div>
      </nav>
  </header>--%>
  <%=head.toHtml()%>
  <h1 class="titulo_h1">��nete!</h1>
  <form class="registro_formulario" action="RealizarRegistro" method="post">
    <!--Nombre Apellidos Institución Nickname Contraseña Email -->
    <input type="text" class="campo" name="nombre" placeholder="Nombre(s)">
    <input type="text" class="campo" name="apellidos" placeholder="Apellidos">
    <input type="text" class="campo" name="institucion" placeholder="Instituci�n">
    <input type="text" class="campo" name="email" placeholder="Correo Electr�nico">
    <input type="text" class="campo" name="nickname" placeholder="Nickname">
    <input type="password" class="campo" name="contrase�a" placeholder="Contrase�a">
    <input type="password" class="campo" name="confirmar_contrase�a" placeholder="Confirmar Contrase�a">
    <input type="submit" value="Continuar" class="btn medio block">
  </form>
  <p>�Ya tienes una cuenta? <a href="http://localhost:8084/login.jsp">�Ingresa!</a></p>

</body>
</html>
