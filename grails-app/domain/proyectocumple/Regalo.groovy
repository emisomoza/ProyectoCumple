package proyectocumple

import com.testapp.User

class Regalo {
	static belongsTo = [empleado: User]
	String idMeli
	String titulo
	String link
	Date fechaDeAsignacion

}