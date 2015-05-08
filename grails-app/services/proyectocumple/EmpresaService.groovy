package proyectocumple

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails

import com.testapp.User

@Transactional
class EmpresaService {

	@Secured(['ROLE_USER'])
    def getEmpresa() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = ((UserDetails) auth.getPrincipal()).getUsername()
        User logueado = User.findByUsername(userName)
		return logueado.empresa
    }
	
	@Secured(['ROLE_USER'])
	def getEmpleadosPorEmpresa() {
		def empresaActual = getEmpresa()
		return User.findAllByEmpresa(empresaActual)
	}
}
