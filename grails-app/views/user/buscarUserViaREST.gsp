<%--
  Created by IntelliJ IDEA.
  User: imatellan
  Date: 11/05/2015
  Time: 11:44 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <asset:javascript src="application.js"/>
    <asset:stylesheet src="application.css" />
    <meta name="layout" content="bootstrap"/>
    <script>
        function enviar(){
            console.log("enviar");
            var nombre = $("#nombre").val();
            console.log("nombre", nombre);
            var request = $.ajax({
                url: "${createLink(controller: "UserRest", action: "search")}",
                data: { nombre: nombre }
            });
            request.done(function( data ) {
                console.log("done", data);
                var str

                $("#contenedor").empty();
                data.forEach(function(item) {
                    str = item.username + " " + item.apellido + " " + "<br>";
                    $("#contenedor").append(str);
                })
            });
            request.fail(function( jqXHR, textStatus ) {
                alert( "Request failed: " + textStatus );
            });
        }
    </script>
    <title>Buscar Via REST</title>
</head>
<body>
    <h3>Busca Empleados por el Nombre a traves de un servicio REST</h3>
    <br/>
    <input type="text" id="nombre" name="nombre" value=""/>
    <input type="button" name="Submit" value="Buscar" onclick="enviar();"/>
    <br/>
    <br/>
    <div id ="contenedor">
    </div>
</body>
</html>