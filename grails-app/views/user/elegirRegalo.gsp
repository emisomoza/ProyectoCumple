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
var  endpoint = "${createLink(controller:'user', action:'asignarRegaloPost')} "
</script>
</head>	

		<div id="page-body" role="main">
			<h1>Historial de asignaciones de regalos para: ${empleado.apellido} ${empleado.username}</h1>

			<table border=1>

				<g:each var="regalo" in ="${empleado.regaloDeCumpleanios}">
					<tr> 
						<td> ${regalo.titulo} </td>
						<td> ${regalo.fechaDeAsignacion.getYear()+1900}</td>
						<!--td> <fmt:formatDate pattern="yyyy-MM-dd" value="${regalo.fechaDeAsignacion}"/> </td-->
					
					</tr>
				</g:each>
			</table>


		</div>


		


<g:if test = "${mostrar}">
		<div id="page-body" role="main">
			<h1>Elegi un regalo para</h1>

<input type="hidden" id="id" name="id" value="${empleado.id}" />
<input type="text" id="id22" name="i2d" value="${empleado.apellido} ${empleado.username}" disabled />
			

				<p>Busqueda <input type="text" id="meliquery" name="query" placeholder="Busque aqui..." /></p>
				<ul id="resultadoBusqueda">
				</ul>

					<script type="text/template" id="templateItem">
						
						<g:form action="asignarRegaloPost" controller="UserController">

						<li>
						<a href="#url#"> #title# </a>
						</li>

						</g:form>

					</script>

		</div>
		
</g:if>