package proyectocumple

import org.springframework.security.access.annotation.Secured

class EmpresaController {
	def scaffold = true
	
	@Secured(['ROLE_ADMIN'])
    def index() { }
}
