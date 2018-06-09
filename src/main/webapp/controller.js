/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
 $(document).ready(function() {
    $.ajax({
        type : "POST",
        contentType : "application/json",
        data : ('{"userID": "8800", "nombre": "","pass": "pass2","tipo": 1}'),
        url: "http://localhost:8084/api/usuario/valida"
    }).then(function(data) {
            console.log(data);
            if(data.message[0].userID!=""){
              //  window.location.replace("http://localhost:8084/api/gestionUsuarios.html");
            }
    });
});


	
	