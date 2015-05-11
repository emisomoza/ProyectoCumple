package proyectocumple

import com.testapp.User
import com.testapp.UserService
import org.springframework.web.servlet.ModelAndView
import grails.rest.RestfulController
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import proyectocumple.EmpresaService

@Secured(['ROLE_USER'])
class UserRestController extends RestfulController{

	static responseFormats = ['json', 'xml']
	
	UserService userService
	EmpresaService empresaService


	public UserRestController() {
		super(User)
	}

	@Secured(['ROLE_USER'])
	def search() {
		empresaService.getEmpresa()
		def empleados = User.findAllByUsernameLike(params.nombre + "%")
		respond empleados.intersect(empresaService.getEmpleadosPorEmpresa())
	}

	@Override
	@Secured(['ROLE_USER'])
	def save() {
		params.put('empresa',empresaService.getEmpresa())
		userService.guardarEmpleado(params)
		redirect(uri: "/user/index")
	}

	@Secured(['ROLE_USER'])
	def searchRegalos() {
		List listaVacia = [] 
		def empleadosEmpresa = empresaService.getEmpleadosPorEmpresa()
		def empleado = empleadosEmpresa.find{it.username == params.usuario}
		if(empleado) {
			respond empleado.regaloDeCumpleanios
		} else {
			respond listaVacia
		}
	}

}