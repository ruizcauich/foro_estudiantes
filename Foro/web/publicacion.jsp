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
                  <li><a href="login.jsp">Login</a></li>
                  <li><a href="registro.jsp">Registrar</a></li>
              </ul>
          </div>
      </nav>
  </header>
  <section class="publicacion">
    <h1 class="titulo_h1">Publicaci�n</h1>
    <div class="fondo-publicacion">
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ab modi soluta quas vel voluptates ex saepe sit a dolorem. Quae ratione repudiandae ipsam consequuntur, suscipit nostrum in sapiente, nesciunt debitis
      Hic inventore quis aspernatur doloremque omnis blanditiis cupiditate ex, labore dolore magnam sapiente. At ea nemo nisi facilis eaque, exercitationem explicabo quaerat ab quo aperiam dolor eveniet voluptatem facere molestias.
      Consequatur totam id ab dolorem impedit, voluptas nihil inventore reprehenderit ex optio, sequi rem corporis vitae delectus illo fugit qui ipsa harum. Quia, mollitia, amet? Praesentium dolorem illum ab maiores.
      Facilis dignissimos nam totam! Modi tempora eveniet asperiores quaerat esse dignissimos consequuntur eum fuga error corporis, quas facere, voluptatem eaque molestiae neque ipsa dolores dolorem, architecto accusantium optio id sed!
      Sunt in at nihil tempora pariatur neque odio enim, iste itaque, sint sequi? Alias magnam quibusdam illum repudiandae vel ut vitae, maxime, illo possimus maiores praesentium, tenetur ad atque repellat
      </p>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores obcaecati excepturi debitis, assumenda. Voluptas, odit, tenetur. Voluptas officiis non dolorem!
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cumque ab consectetur sapiente officia, at nam quaerat maxime quae amet autem. Quo delectus expedita dignissimos obcaecati cum, est itaque doloremque ipsa iure quasi dicta voluptatum. Cum.
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae eum laborum atque natus id delectus quam quia non, saepe molestiae vel architecto dolor fugiat consectetur odit doloribus dignissimos cupiditate praesentium.
      </p>
      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Asperiores obcaecati excepturi debitis, assumenda. Voluptas, odit, tenetur. Voluptas officiis non dolorem!
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cumque ab consectetur sapiente officia, at nam quaerat maxime quae amet autem. Quo delectus expedita dignissimos obcaecati cum, est itaque doloremque ipsa iure quasi dicta voluptatum. Cum.
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Recusandae eum laborum atque natus id delectus quam quia non, saepe molestiae vel architecto dolor fugiat consectetur odit doloribus dignissimos cupiditate praesentium.
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorum excepturi pariatur cumque optio tempore porro eum obcaecati quam aperiam exercitationem praesentium odio, consequuntur soluta, totam dicta rem maiores, consequatur, deleniti.
      Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quas, cumque, itaque debitis enim rerum non accusamus quos illum iste voluptas.
      </p>
    </div>
    <hr>
  </section>
  <!-- Contenedor Principal de los comentarios-->
  <div class="publicacion_formulario">
    <h2 class="titulo_h2">Comenta</h2>
    <form class="" action="" method="post">
      <textarea class="publicacion_textarea" name="name" rows="8" cols="80"></textarea>
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
            <img src="img/default-avatar.png" alt="No se encontr� la imagen">
          </div>
          <!-- Contenedor del comentario  -->
          <div class="comment-box">
            <div class="comment-head">
              <h6 class="comment-name by-author"><a href="#">Agust�n Perera</a></h6>
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
              <img src="img/default-avatar.png" alt="No se encontr� la imagen">
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
            <img src="img/default-avatar.png" alt="No se encontr� la imagen">
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
            <img src="img/default-avatar.png" alt="No se encontr� la imagen">
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
            <img src="img/default-avatar.png" alt="No se encontr� la imagen">
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