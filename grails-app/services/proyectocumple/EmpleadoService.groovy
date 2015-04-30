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


/*

def buscarCumpleaniero() {
		def listaEmpleadosCumple = empleadoService.buscarCumpleanierosPorMesActual()
		[listaEmpleadosCumple: listaEmpleadosCumple]
	}


	def elegirRegalo() {
		
		def idEmpleado = params.idEmpleado
		return new ModelAndView ('/proyectocumplevista/buscarRegalos', [idEmpleado: idEmpleado])
		render view: "blbj",model: []

*/