<table border=1>
		
		<td>Nombre Empleado</td>  	<td>Fecha de Cumpleaños</td> 
		
	<g:each in="${listaEmpleadosCumple}" var="empleado">
		<tr>
		
 			<td> <a href="/ProyectoCumple/empleado/elegirRegalo?idEmpleado=${empleado.id}"> ${empleado.nombre} </a>  </td> 
			
			<td> ${empleado.fechaCumple} </td> 
		</tr>
	</g:each>
		
</table>