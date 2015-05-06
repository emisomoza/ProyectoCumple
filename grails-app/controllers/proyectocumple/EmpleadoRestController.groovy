package proyectocumple

import org.springframework.web.servlet.ModelAndView
import grails.rest.RestfulController
import grails.converters.JSON

class EmpleadoRestController extends RestfulController{

	static responseFormats = ['json', 'xml']

	EmpleadoService empleadoService
	public EmpleadoRestController() {
		super(Empleado)
	}

	def search() {
		def empleados = Empleado.findAllByNombreLike(params.nombre + "%")
		respond empleados
	}

	@Override
	def save() {
		empleadoService.guardarEmpleado(params)
		redirect(uri: "/empleado/index")
	}

}