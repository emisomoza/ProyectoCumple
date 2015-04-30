Confirmar asignacion de regalo <br>

<g:form controller="empleado" action="confirmacionDeGuardado" >

<td>Identificacion Empleado: </td>  ${empleado.id}	<br>
<td>Nombre Empleado: </td>  ${empleado.nombre}	<br>
<td>Apellido Empleado: </td>  ${empleado.apellido}	<br>
<td>Fecha de Nacimiento Empleado: </td>  ${empleado.fechaCumple}	<br>
<td>Regalo de Cumpleaños Empleado: </td>  ${empleado.regaloDeCumpleanios} 	<br>


<g:hiddenField name="idEmpleado" value= "${empleado.id}" />
<g:hiddenField name="idRegalo" value= "${empleado.regaloDeCumpleanios}" />
  
  <g:submitButton name="Submit" value="ACEPTAR" class="lnk" />
  <input id="mybutton" type="button" value="CANCELAR" onclick="back();" />

</g:form>



<script>

function back(){
	window.history.back();
}

</script>