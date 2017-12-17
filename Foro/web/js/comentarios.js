document.onreadystatechange = init;
var comentar_publicacion;
var listaComentarios;
var publicacion;
var mas_comentarios;

// servirá para determinar cuantos comentarios principales traer
var cont = 1;
function init(){
  if( this.readyState!="complete"){ return;}
  // reserva el formulario
  comentar_publicacion = document.getElementById("comentar_publicacion");
  // lista para los listaComentarios
  listaComentarios  = document.getElementById("comments-list");
  // aplica una ccion en caso de submit
  comentar_publicacion.addEventListener("submit", comentarPublicacion);
  publicacion = document.getElementById("idPublicacion").value;

  // botón para ver más comentarios
  mas_comentarios =  document.getElementById("mas_comentarios");

  mas_comentarios.addEventListener("click",function(event){actualizarLista(true);} );


  actualizarLista( true );

}

function comentarPublicacion(evento){
  // evita el submit del formulario
  evento.preventDefault();

  parametros = "publicacion="+comentar_publicacion["publicacion"].value+"&comentario="+comentar_publicacion["comentario"].value;
  console.log(parametros);
  ejecutarAjax("Comentar", parametros, "GET",
   function( respuesta ){
     console.log(respuesta.reponseText);
     actualizarLista( false );
   }
 );
}

function actualizarLista( aumentarComentarios ){
  ejecutarAjax("obtenerComentarios", "publicacion="+publicacion+"&cont="+cont, "GET",
    function (respuesta ){
      listaComentarios.innerHTML= respuesta.responseText ;
      var comentarios = document.getElementsByClassName("fa-reply");
      for(com of comentarios){
        if( com.dataset.comentario )  com.addEventListener("click", mostrarReply);
      }
      
      var eliminados = document.getElementsByClassName("fa fa-window-close");
      for(elim of eliminados){
        if( elim.dataset.eliminado )  elim.addEventListener("click", borrarComentario);
      }
      
      var actualizados = document.getElementsByClassName("fa fa-pencil");
      for(act of actualizados){
        if( act.dataset.actualizado )  act.addEventListener("click", actualizarComentario);
      }
      
    }
  ); // fin de ejecutarAjax

  if(aumentarComentarios)
    cont++;
}


var comentarioSeleccionado;
function mostrarReply(evento){
  comentarioSeleccionado = this.dataset.comentario;
  var reply = prompt("Escribe tu comentario: ");
  if( reply ){
    ejecutarAjax("ComentarComentario",
    "comentario="+reply+"&comentarioSeleccionado="+comentarioSeleccionado+"&publicacion="+publicacion,
    "GET",
    function(respuesta){
      actualizarLista( false );
    }
  );
  }

}


var comentarioEliminado;
function borrarComentario(evento){
  comentarioEliminado = this.dataset.eliminado;
  ejecutarAjax("BorrarComentario","comentario="+comentarioEliminado,"GET",
    function(respuesta){
        
        actualizarLista(false);
    }
    );
 

}

var contenidoActualizado;
function actualizarComentario(evento){
    var comentario = this.dataset.actualizado;
    contenidoActualizado = prompt("Escribe de nuevo tu comentario: ");
    if(contenidoActualizado){
        ejecutarAjax("ActualizarComentario",
        "comentario="+comentario+"&contenidoActualizado="+contenidoActualizado,
                "GET",
                function(respuesta){
                    
                    actualizarLista(false);
                });
    }
}
