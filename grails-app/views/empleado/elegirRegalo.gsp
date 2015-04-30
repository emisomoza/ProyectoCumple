<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>

<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>
<script>
var  endpoint = "${createLink(controller:'empleado', action:'asignarRegaloPost')} "
</script>
</head>	


		<div id="page-body" role="main">
			<h1>Elegi un regalo para</h1>

<input type="hidden" id="id" name="id" value="${empleado.id}" />
<input type="text" id="id22" name="i2d" value="${empleado.apellido} ${empleado.nombre}" disabled />
			

				<p>Busqueda <input type="text" id="meliquery" name="query" placeholder="Busque aqui..." /></p>
				<ul id="resultadoBusqueda">
				</ul>

					<script type="text/template" id="templateItem">
						
						<g:form action="asignarRegaloPost" controller="EmpleadoController">

						<li>
						<a href="#url#"> #title# </a>
						</li>

						</g:form>

					</script>

		</div>
		
