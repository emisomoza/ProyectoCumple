$(function() {
	$("#meliquery").keypress( enviarConsulta );

	function enviarConsulta() {
		setTimeout(function() {
			var query = "https://api.mercadolibre.com/sites/MLA/search?q=" + $("#meliquery").val();

			var promise = $.get(query);
			promise.done( recibirResultados );
		}, 0);
	}

	function recibirResultados( json ) {
		$("#resultadoBusqueda").empty();
		json.results.forEach(function(item) {
			var str = $("#templateItem").text()
		//	str = str.replace(/#url#/g, item.permalink);
		//	str = str.replace(/#url#/g, "javascript:asignarRegalo(" + item.id + ");");
			str = str.replace(/#url#/g, "empleado/asignarRegalo?idProducto=" + item.id);
			str = str.replace(/#title#/g, item.title);

			$("#resultadoBusqueda").append(str);
		})
	}
});


function asignarRegalo(val){
	alert ("sasas");
}