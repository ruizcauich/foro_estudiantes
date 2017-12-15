<%@page import="db.models.Publicacion"%>
<%@ page import="html.Header" %>
<%@ page import="html.ControlSeguridad" %>
<% Header head = new Header(ControlSeguridad.estaAutenticado(request));%>
<%--/*
 * Nombre del archivo: publicar.jsp
 * Descripción: Muestra una publicación
 *              
 * Autor (es): Eyden Villanueva
 * Fecha de realización: 11-Noviembre-2017
 */
 --%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Post</title>
  <link rel="shortcut icon" type="image/x-icon" href="img/logo-favicon.ico">
  <link rel="stylesheet" href="css/contenedores.css">
  <link rel="stylesheet" href="css/menus.css">
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/publicacion.css">
  <link rel="stylesheet" href="css/botones.css">
  <link rel="stylesheet" href="css/titulos.css">
  <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>
  <%=head.toHtml()%>
  <%  
      
      Publicacion publicacion = new Publicacion();
      int id = Integer.parseInt(request.getParameter("publicacion"));
      String atributo_valor [][] = {{"id",String.valueOf(id)}};
      publicacion = (Publicacion)publicacion.getObjects(atributo_valor).get(0);
  
  
  %>
  <section class="publicacion">
    <h1 class="titulo_h1"><%out.print(publicacion.getTopico()); %> </h1>
    <div class="fondo-publicacion">
      <p>
          <% out.print(publicacion.getContenido());%>
      </p>
    </div>
    <hr>
  </section>
  <!-- Contenedor Principal de los comentarios-->
  <div class="publicacion_formulario">
    <h2 class="titulo_h2">Comenta</h2>
    <form class="" action="Comentar" method="get">
      <textarea class="publicacion_textarea" name="comentario" rows="8" cols="80"></textarea>
      <input class="" id="idPublicacion" name="publicacion" rows="8" cols="80" value="<%out.print(publicacion.getId());%>">
      <input class="btn" type="submit" name="" value="Aceptar">
    </form>
  </div>
  <div class="comments-container">
    <h2 class="titulo_h2">Comentarios</h2>

    <ul id="comments-list" class="comments-list">
      <li>
        <div class="comment-main-level">
          <!--AVATAR -->
          <div class="comment-avatar">
            <img src="img/default-avatar.png" alt="No se encontró la imagen">
          </div>
          <!-- Contenedor del comentario  -->
          <div class="comment-box">
            <div class="comment-head">
              <h6 class="comment-name by-author"><a href="#">Agustín Perera</a></h6>
              <span>Hace 20 minutos</span>
              <i class="fa fa-heart" aria-hidden="true"></i>
              <i class="fa fa-reply" aria-hidden="true"></i>
            </div>
            <div class="comment-content">
              Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
              dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
            </div>
          </div>
        </div>

        <!--Comentario Anidado -->
        <ul class="comments-list reply-list">
          <li>
            <!--AVATAR -->
            <div class="comment-avatar">
              <img src="img/default-avatar.png" alt="No se encontró la imagen">
            </div>
            <!-- Contenedor del comentario  -->
            <div class="comment-box">
              <div class="comment-head">
                <h6 class="comment-name"><a href="#">Lorena Rojero</a></h6>
                <span>Hace 10 minutos</span>
                <i class="fa fa-heart" aria-hidden="true"></i>
                <i class="fa fa-reply" aria-hidden="true"></i>
              </div>
              <div class="comment-content">
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
                dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
              </div>
            </div>
          </li>
        </ul>
      </li>
      <li>
        <div class="comment-main-level">
          <!--AVATAR -->
          <div class="comment-avatar">
            <img src="img/default-avatar.png" alt="No se encontró la imagen">
          </div>
          <!-- Contenedor del comentario  -->
          <div class="comment-box">
            <div class="comment-head">
              <h6 class="comment-name"><a href="#">Lorena Rojero</a></h6>
              <span>Hace 10 minutos</span>
              <i class="fa fa-heart" aria-hidden="true"></i>
              <i class="fa fa-reply" aria-hidden="true"></i>
            </div>
            <div class="comment-content">
              Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
              dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
            </div>
          </div>
        </div>
      </li>
      <li>
        <div class="comment-main-level">
          <!--AVATAR -->
          <div class="comment-avatar">
            <img src="img/default-avatar.png" alt="No se encontró la imagen">
          </div>
          <!-- Contenedor del comentario  -->
          <div class="comment-box">
            <div class="comment-head">
              <h6 class="comment-name"><a href="#">Lorena Rojero</a></h6>
              <span>Hace 5 minutos</span>
              <i class="fa fa-heart" aria-hidden="true"></i>
              <i class="fa fa-reply" aria-hidden="true"></i>
            </div>
            <div class="comment-content">
              Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
              dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
            </div>
          </div>
        </div>
      </li>
      <ul class="comments-list reply-list">
        <li>
          <!--AVATAR -->
          <div class="comment-avatar">
            <img src="img/default-avatar.png" alt="No se encontró la imagen">
          </div>
          <!-- Contenedor del comentario  -->
          <div class="comment-box">
            <div class="comment-head">
              <h6 class="comment-name"><a href="#">Lorena Rojero</a></h6>
              <span>Hace 3 minutos</span>
              <i class="fa fa-heart" aria-hidden="true"></i>
              <i class="fa fa-reply" aria-hidden="true"></i>
            </div>
            <div class="comment-content">
              Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et
              dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
            </div>
          </div>
        </li>
      </ul>
    </ul>
  </div>
</body>
</html>
