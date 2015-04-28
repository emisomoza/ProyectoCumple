package proyectocumple

import proyectocumple.Empleado

class EmpleadoService{

	def buscarCumpleanierosPorMesActual(){
			def today = new Date()
			def mesActual = today.getMonth()

			def cumpleanieros = Empleado.list()

			cumpleanieros.each {
				def mesEmpleado = it.fechaCumple.getMonth()
				if mesEmpleado == mesActual
				println(it.nombre)
			}

	}

}