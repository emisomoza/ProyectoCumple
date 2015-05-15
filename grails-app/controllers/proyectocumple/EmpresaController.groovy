package proyectocumple

import org.springframework.security.access.annotation.Secured

class EmpresaController {
	
	@Secured(['ROLE_ADMIN'])
	def index() {
		redirect uri: '/index'
	}
}