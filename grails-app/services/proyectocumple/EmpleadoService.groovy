package proyectocumple

import proyectocumple.Empleado

class EmpleadoService{

	def buscarCumpleanierosPorMesActual(){
			def today = new Date()
			def mesActual = today.getMonth()

			def cumpleanieros = Empleado.where {
				//  year(fechaCumple) == 1980
				month(fechaCumple) == mesActual + 1
			}

			
	}

}