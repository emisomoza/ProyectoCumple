<table border=1>
		
		<td>Nombre Empleado</td>  	<td>Fecha de Cumpleaños</td> 
		
	<g:each in="${listaEmpleadosCumple}" var="lista">
		<tr>
			<td> ${lista.nombre} </td>  	
			
			<td> ${lista.fechaCumple} </td> 
		</tr>
	</g:each>
		
</table>