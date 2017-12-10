<%-- 
 * Nombre del archivo: login.jsp
 * Descripción: Para el inicio de sesión
 *               
 * Autor (es): Augusto Neftalí Ruiz Cauich, Eyden Villanueva Alpuche
 * Fecha de realización: 11-Noviembre-2017
 --%>
<%@ page import="db.models.Usuario" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.Cookie" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login</title>
  <link rel="shortcut icon" type="image/x-icon" href="img/logo-favicon.ico">
  <link rel="stylesheet" href="css/menus.css">
  <link rel="stylesheet" href="css/contenedores.css">
  <link rel="stylesheet" href="css/login.css">
  <link rel="stylesheet" href="css/botones.css">
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
                  <li><a href="login.jsp">Login</a></li>
                  <li><a href="registro.jsp">Registrar</a></li>
              </ul>
          </div>
      </nav>
  </header>
  <center>
    <img id='answer' src="img/gif2.gif">
  </center>
<%
    String mensaje_contrasena="";
    String mensaje_usuario="";
    try{
        String nickname = request.getParameter("usuario");
        String contrasena =request.getParameter("contrasena");
        // Para iniciar sesión
        if(nickname!=null){
            // Obtener usuario de la base de datos
            Usuario us = new Usuario();
            String atributo_valor[][] = {{"nickname", nickname}};
            us = (Usuario) us.getObjects( atributo_valor).get(0);
            // Verificar contraseña
            if(contrasena.equals( us.getContrasena() )){
                Cookie nickN = new Cookie("nickname", nickname);
                Cookie psw = new Cookie("contrasena", contrasena);
                // agregar esto a las cookies
                response.addCookie(nickN);
                response.addCookie(psw);
                
                response.sendRedirect("/");
            }
            else{
                mensaje_contrasena = "Contraseña erronea";

            }
        }
        
    }catch(IndexOutOfBoundsException e){
        mensaje_usuario = "Usuario incorrecto";
    }
    catch(Exception e){}
    
%>
  <form class="login_formulario" action="" method="post" border="1px">
    <%out.print(mensaje_usuario); %>  
    <br>
    <img class="login_iconos" src="img/icono-usuario.svg" alt="No se encontró la imagen" class="icono">
    <input type="text" id="usuario" class="campo" name="usuario" placeholder="Usuario">
    <%out.print(mensaje_contrasena); %>  
    <br>
    <img class="login_iconos" src="img/icono-contraseña.svg" alt="No se encontró la imagen" width=40px height=40px class="icono">
    <input type="password" id="contraseña" class="campo" name="contrasena" placeholder="Contraseña">

    <input class="btn grande block" type="submit" value="Ingrese">

    <p>¿No tienes cuenta? <a href="registro.jsp"> Únete ahora</a></p>

  </form>
    
</body>
</html>
