package proyectocumple

import org.springframework.web.servlet.ModelAndView
import grails.rest.RestfulController
import grails.converters.JSON

class EmpleadoRestController extends RestfulController{

	static responseFormats = ['json', 'xml']

	public EmpleadoRestController() {
		super(Empleado)
	}

	def search() {
		def empleados = Empleado.findAllByNombreLike(params.nombre + "%")
		respond empleados
	}


}