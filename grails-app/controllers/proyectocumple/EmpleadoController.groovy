package proyectocumple

import org.springframework.web.servlet.ModelAndView

class EmpleadoController {

	EmpleadoService empleadoService

	def scaffold = true


	def buscarCumpleaniero() {
		def listaEmpleadosCumple = empleadoService.buscarCumpleanierosPorMesActual()
		[listaEmpleadosCumple: listaEmpleadosCumple]
	//	return new ModelAndView ('/proyectocumplevista/cumpleDelMes', [listaEmpleadosCumple: listaEmpleadosCumple])
	}


	def elegirRegalo() {
		
		def idEmpleado = params.idEmpleado
		def empleado = Empleado.findById(idEmpleado)

		[empleado: empleado]

	//	return new ModelAndView ('/proyectocumplevista/buscarRegalos', [idEmpleado: idEmpleado])

	}


	def asignarRegalo() {
		
		def idEmpleado = params.idEmpleado
		def idRegalo = params.idRegalo

		def empleado = empleadoService.guardarRegaloEnEmpleado(idEmpleado,idRegalo)
		[empleado: empleado]
	//	return new ModelAndView ('/proyectocumplevista/mostrarRegaloAsignado', [empleado: empleado])

	}


}