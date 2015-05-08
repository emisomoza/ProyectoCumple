<html>

<head>
	<asset:javascript src="application.js"/>
	<meta name="layout" content="bootstrap"/>
	<style type="text/css" media="screen">
		#arribaDerecha{
	 		position:absolute;
	 		top:0;
	 		right:0;
	 		width:200px;
	 		margin-top:5px;
		}
	</style>
</head>

<body>

<table border=1>
		
	Lista de personas que cumplen años este mes
</br>
	<br>
	Dale click al nombre para asignar un regalo o ver su historial

	</br>

		<td>Nombre Empleado</td>  	<td>Fecha de Cumpleaños</td> 
		
	<g:each in="${empleadosEmpresaMesActual}" var="empleado">
		<tr>
		
 		<!--	<td> <a href="/ProyectoCumple/empleado/elegirRegalo?idEmpleado=${empleado.id}"> ${empleado.username} </a>  </td>  -->

 			<td> <a href="${createLink(controller:"user", action:"elegirRegalo", id: empleado.id)}"> ${empleado.username} </a>  </td>
			
		
 		<!--	
			<td> <g:link controller="user"  action="elegirRegalo" params="${[idEmpleado: empleado.id]}"> ${empleado.username} </g:link>  </td>
		-->

			<td> ${empleado.fechaCumple} </td> 

		</tr>
	</g:each>
		
</table>

</br>
</br>

<label>Busca Empleados por el Nombre a traves de un servicio REST</label>
<br>
	
	<input type="text" id="nombre" name="nombre" value=""/> 
	<input type="button" name="Submit" value="Buscar" onclick="enviar();"/>


<div id ="contenedor">
</div>
<br>
</br>
</br>
</br>
</br>
<label>Formulario de alta por REST</label>
	<br>
	<br>
	<g:form controller="EmpleadoRest" action="save" method="POST">
		<label>Datos del empleado</label>
		<br>
		<br>
		<label>Nombre:</label>
		<g:field type="text" name="nombre"/>
		<br>
		<label>Apellido:</label>
		<g:field type="text" name="apellido"/>
		<br>
		<label>Fecha de nacimiento</label>
		<g:datePicker precision="day" name="cumple"/>
		<br>
		<br>
		<input type="submit"  value="Guardar"/>
	</g:form>
</body>


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
				str = item.nombre + " " + item.apellido + " " + "<br>";
				$("#contenedor").append(str);
			})
	});
 
	request.fail(function( jqXHR, textStatus ) {
		alert( "Request failed: " + textStatus );
	});
}
</script>
<div id="arribaDerecha">
	<sec:ifLoggedIn>
	Bienvenido <sec:username/>!
	<a href="${createLink(controller:"user", action:"logout")}"> Logout </a>
	</sec:ifLoggedIn>
</div>
</html>




