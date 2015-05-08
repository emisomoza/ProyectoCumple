package proyectocumple

import com.testapp.User
import grails.transaction.Transactional
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder

@Transactional
class EmpresaService {

    def getEmpresa() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = ((UserDetails) auth.getPrincipal()).getUsername()
        User logueado = User.findByUsername(userName)
		return logueado.empresa
    }
	
	def getEmpleadosPorEmpresa() {
		def empresaActual = getEmpresa()
		return User.findAllByEmpresa(empresaActual)
	}
}
