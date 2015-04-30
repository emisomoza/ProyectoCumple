<html>

<head>
</head>

<body>

<table border=1>
		
		<td>Nombre Empleado</td>  	<td>Fecha de Cumpleaños</td> 
		
	<g:each in="${listaEmpleadosCumple}" var="empleado">
		<tr>
		
 		<!--	<td> <a href="/ProyectoCumple/empleado/elegirRegalo?idEmpleado=${empleado.id}"> ${empleado.nombre} </a>  </td>  -->

 			<td> <a href="${createLink(controller:"empleado", action:"elegirRegalo", id: empleado.id)}"> ${empleado.nombre} </a>  </td> 
			
		
 		<!--	
			<td> <g:link controller="empleado"  action="elegirRegalo" params="${[idEmpleado: empleado.id]}"> ${empleado.nombre} </g:link>  </td> 
		-->

			<td> ${empleado.fechaCumple} </td> 

		</tr>
	</g:each>
		
</table>

</body>

</html>




