<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>

<asset:stylesheet src="application.css"/>
		<asset:javascript src="application.js"/>

</head>	
		<div id="page-body" role="main">
			<h1>Busca los regalos</h1>


				<p>Busqueda <input type="text" id="meliquery" name="query" placeholder="Busque aqui..." /></p>
				<ul id="resultadoBusqueda">
				</ul>

					<script type="text/template" id="templateItem">
						
						<g:form action="asignarRegalo" controller="EmpleadoController">

						<li>
						<a href="#url#"> #title# </a>
						</li>

						</g:form>

					</script>

		</div>
		
