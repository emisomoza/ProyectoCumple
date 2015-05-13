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
   <!-- <meta name="layout" content="bootstrap"/> -->
    <title>Agregar Via REST</title>
</head>
<body>
<br/>
<br/>
<br/>
<br/>
    <h3>Formulario de alta por REST</h3>
    <g:form controller="UserRest" action="save" method="POST">
        <label>Datos del empleado</label>
        <br/>
        <br/>
        <label>Nombre:</label>
        <g:field type="text" name="nombre"/>
        <br/>
        <label>Apellido:</label>
        <g:field type="text" name="apellido"/>
        <br/>
        <label>Password:</label>
        <g:field type="password" name="password"/>
        <br/>
        <label>Fecha de nacimiento</label>
        <g:datePicker precision="day" name="cumple"/>
        <br/>
        <br/>
        <input type="submit"  value="Guardar"/>
    </g:form>
    <br/>
    <a class="btn" href="buscarUserViaREST">Buscar User x REST</a>
</body>
</html>