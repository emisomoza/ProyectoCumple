package proyectocumple

class Empleado {
	
	int id
	String nombre
	String apellido
	Date fechaCumple
	static hasOne = [empresa: Empresa]
//	String regaloDeCumpleanios
	static hasMany = [regaloDeCumpleanios: Regalo]

    static constraints = {
		nombre()
		apellido()
		fechaCumple()
		regaloDeCumpleanios(display: false)
    }
	static mapping = {
		regaloDeCumpleanios column: 'empleado_regalo_id', joinTable: false

	}
}