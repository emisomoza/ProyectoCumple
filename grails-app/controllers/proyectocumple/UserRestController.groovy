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
	EmpresaService empresaService
	
	UserService userService


	public UserRestController() {
		super(User)
	}

	@Secured(['ROLE_USER'])
	def search() {
		def empleados = User.findAllByUsernameLike(params.nombre + "%")
		respond empleados.intersect(empresaService.getEmpleadosPorEmpresa())
	}

	@Override
	@Secured(['ROLE_USER'])
	def save() {
		userService.guardarEmpleado(params)
		redirect(uri: "/user/index")
	}

}