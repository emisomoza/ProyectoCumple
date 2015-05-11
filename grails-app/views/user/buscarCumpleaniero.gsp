<html>
<head>
	<asset:javascript src="application.js"/>
	<asset:stylesheet src="application.css" />
	<meta name="layout" content="bootstrap"/>

</head>
<body>

	<table border=1>
		<h3>Lista de personas que cumplen años este mes</h3>
		<br/>
		<p>Dale click al nombre para asignar un regalo o ver su historial!</p>
		<td>Nombre Empleado</td>
		<td>Fecha de Cumpleaños</td>
		<g:each in="${empleadosEmpresaMesActual}" var="empleado">
			<tr>
				<!--	<td> <a href="/ProyectoCumple/empleado/elegirRegalo?idEmpleado=${empleado.id}"> ${empleado.username} </a>  </td>  -->
				<td> <a href="${createLink(controller:"user", action:"elegirRegalo", id: empleado.id)}"> ${empleado.username} </a>  </td>
				<!--<td> <g:link controller="user"  action="elegirRegalo" params="${[idEmpleado: empleado.id]}"> ${empleado.username} </g:link>  </td>-->
				<td> ${empleado.fechaCumple} </td>
			</tr>
		</g:each>
	</table>
	<br/>
	<a class="btn" href="buscarUserViaREST">Buscar User x REST</a>
	<div id="arribaDerecha">
		<sec:ifLoggedIn>
			Bienvenido <sec:username/>!
			<a href="${createLink(controller:"user", action:"logout")}"> Logout </a>
		</sec:ifLoggedIn>
	</div>
</body>
</html>




