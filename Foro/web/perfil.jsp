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
      <img src="img/default-avatar.png" alt="No se pudo cargar la imagen">
      <form class="formulario-avatar" action="index.html" method="post">
        <input class="btn" type="submit" name="" value="Cambiar Avatar">
      </form>
    </div>
    <div class="contenedor-datos">
      <form class="formulario-perfil-datos" action="index.html" method="post">
        <div class="contenedor-campo">
          <label for="nombre">Nombre</label>
          <input type="text" name="nombre" value="Andres">
        </div>
        <div class="contenedor-campo">
          <label for="apellidos">Apellidos</label>
          <input type="text" name="apellidos" value="Ancala Montalvo">
        </div>
        <div class="contenedor-campo">
          <label for="institucion">Instituci�n</label>
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
          <label for="contrase�a">Contrase�a</label>
          <input type="password" name="contrase�a" value="contrase�adeAndres">
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