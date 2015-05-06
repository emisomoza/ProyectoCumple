package proyectocumple

class Regalo {
	static belongsTo = [empleado: Empleado]
	String idMeli
	String titulo
	String link
	Date fechaDeAsignacion

}