/*
 * Nombre del archivo: publicacionesRecientes.js
 * Descripción: Script para la página de inicio, trae las publicaciones mas recientes
 * Autor (es): Augusto Neftalí Ruiz Cauich
 * Fecha de realización: 10-Diciembre-2017
 */
document.onreadystatechange=init;
var cont =1;
var contenedor_pubs;
var mostrar_mas;
function init(){
  // si el evento no es carga completa no hace nada
  if( this.readyState!="complete") return;

  contenedor_pubs = document.getElementsByClassName("contenedor-contenido")[0];
  mostrar_mas = document.getElementById("mostrar_mas");

  mostrar_mas.addEventListener("click", function(){
      ejecutarAjax("obtenerPublicaciones", "cont="+cont, "GET", incluirPublicaciones);
      cont++;
      
  });
  ejecutarAjax("obtenerPublicaciones", "cont="+cont, "GET", incluirPublicaciones);
  cont++;
}

function incluirPublicaciones( resultado ){
  contenedor_pubs.innerHTML = resultado.responseText;
  contenedor_pubs.appendChild(mostrar_mas);
  console.log( resultado );
}
