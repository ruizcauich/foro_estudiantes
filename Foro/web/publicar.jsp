<%--/*
 * Nombre del archivo: publicar.jsp
 * Descripción: Muestra formulario para hacer una publicación
 *              
 * Autor (es): Dindier Alexander, Eyden Villanueva
 * Fecha de realización: 20-Noviembre-2017, 03-Diciembre-2017
 */
 --%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Publica algo en la comunidad</title>
    <link rel="stylesheet" href="css/contenedores.css">
    <link rel="stylesheet" href="css/menus.css">
    <link rel="stylesheet" href="css/botones.css">
    <link rel="stylesheet" href="css/titulos.css">

    <style media="screen">
      #titulo-publicar{
        width: 300px;
        padding: 5px;
        margin-bottom: 20px;
      }
    </style>
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
    <section class="contenedor">
       <div class="area-publicar">
           <h3 class="titulo_h3">Buscas ayuda, opiniones o algo más?</h3>
           <p>
               Escribe en la sección de abajo para poder hacer una publicación que cualquiera en este foro pueda ver.
           </p>
            <form action="Publicar" class="publicar">
                <input id="titulo-publicar" type="text" name="titulo" value=""placeholder="Titulo">
                <textarea name="contenido" id="" cols="30" rows="10"></textarea>

                <div>
                    <button type="submit" class="btn">Publicar</button>
                </div>

            </form>
       </div>

    </section>
</body>
</html>
