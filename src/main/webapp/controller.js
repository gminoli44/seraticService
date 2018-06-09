/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
function validar() {
     
     
     
    var userID =  $("#identificacion").val();
    var password = $("#pass").val();
    $.ajax({
        url: "http://localhost:8084/api/usuario/validar",
        type: "POST",
        data: JSON.stringify({userID:userID,nombre:'n',pass:password,tipo:1}),// now data come in this function
        contentType: "application/json; charset=utf-8",
        crossDomain: true,
        dataType: "json",
        success: function (data) {
        }
    }).then(function(data) {
            if(data.message[0]){
                window.location.replace("http://localhost:8084/api/gestionUsuarios.html");
            }
            else{
                alert("Usuario o contraseña incorrecto");
            }
    });
}


	
	