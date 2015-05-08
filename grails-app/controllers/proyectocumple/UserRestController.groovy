package proyectocumple

import com.testapp.User
import com.testapp.UserService
import org.springframework.web.servlet.ModelAndView
import grails.rest.RestfulController
import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_USER'])
class UserRestController extends RestfulController{

	static responseFormats = ['json', 'xml']

	UserService userService


	public UserRestController() {
		super(User)
	}

	def search() {
		def empleados = User.findAllByUsernameLike(params.nombre + "%")
		respond empleados
	}

	@Override
	def save() {
		userService.guardarEmpleado(params)
		redirect(uri: "/user/index")
	}

}