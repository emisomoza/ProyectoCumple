package proyectocumple

import org.springframework.web.servlet.ModelAndView

class EmpleadoController {

	EmpleadoService empleadoService

	def scaffold = true


	def buscarCumpleaniero = {
		def listaEmpleadosCumple = empleadoService.buscarCumpleanierosPorMesActual()
		return new ModelAndView ('/proyectocumplevista/cumpleDelMes', [listaEmpleadosCumple: listaEmpleadosCumple])
	}


	def elegirRegalo = {
		
		def idEmpleado = params.idEmpleado
		return new ModelAndView ('/proyectocumplevista/buscarRegalos', [idEmpleado: idEmpleado])

	}

/*
	def asignarRegalo = {
		
		def idEmpleado = params.idEmpleado
		def idRegalo = params.idRegalo

		// service que graba el regalo en el empleado

		return new ModelAndView ('/proyectocumplevista/buscarRegalos', [idEmpleado: idEmpleado])

	}
*/

}