/* 
 * Nombre del archivo: perfil.js
 * Descripción: Script aplicable a las operaciones en la página de perfil
 * Autor (es): Augusto Neftalí Ruiz Cauich
 * Fecha de realización: 06-Diciembre-2017
 */


document.onreadystatechange = init;
var file;
var formulario;
var avatar;
var id;
// inicializa enventos y demás variables
function init(){
    // si el evento no es carga completa no hace nada
    if( this.readyState!="complete") return; 
    var formulario_avatar = document.getElementsByClassName("formulario-avatar")[0];
    var cambiar_avatar = document.getElementById("cambiar_avatar");
    
    formulario_avatar.addEventListener("submit", submitFormulario);
    cambiar_avatar.addEventListener("change", subirAvatar );
    avatar = document.getElementById("avatar");
    id = document.getElementById("id").value;
}

function submitFormulario( event){
    event.preventDefault();
    //formulario = new FormData( document.getElementsByClassName("formulario-avatar")[0]);
    formulario = new FormData(this);
    var cambiar_avatar = document.getElementById("cambiar_avatar").click();
    
}

function subirAvatar(){
    file = this.files[0];
    
    //var formulario = new FormData();
    // para inicializar con valores del formulario de html (enctype)
    
    document.getElementById("avatar").src="";
    formulario.append("id", id);
    formulario.set("avatar", file, file.name);
    avatar.src="";
    console.log( formulario);
    
    ejecutarAjax("actualizarAvatar", formulario, "POST", 
        function( respuesta ){
            var image = new Image();
            image.onload=function(){
                avatar.src = this.src;
            };
            var d = new Date;
            image.src="obtenerAvatar?id="+id + "&d="+d.getTime();
            console.log(respuesta );
        }
    );
    
    
}
 