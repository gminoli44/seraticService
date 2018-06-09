/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
 $(document).ready(function() {
    $.ajax({
        url: "http://localhost:8084/api/usuario/listar"
    }).then(function(data) {
            console.log(data.message[0].userID);
            if(data.message[0].userID!=""){
                window.location.replace("http://localhost:8084/api/gestionUsuarios.html");
            }
    });
});