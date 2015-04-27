package proyectocumple

import org.springframework.web.servlet.ModelAndView

class EmpleadoController {

	EmpleadoService empleadoService

	def scaffold = true


	def buscarCumpleaniero = {
		def listaEmpleadosCumple = empleadoService.buscarCumpleanierosPorMesActual()
		return new ModelAndView ('/proyectocumplevista/cumpleDelMes', [listaEmpleadosCumple: listaEmpleadosCumple])
	}


}