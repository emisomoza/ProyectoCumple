package proyectocumple

import com.testapp.User
import grails.transaction.Transactional
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder

@Transactional
class EmpresaService {

    def serviceMethod() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = ((UserDetails) auth.getPrincipal()).getUsername()
        println userName
        User logeado = User.findByUsername(userName)
        println logeado.empresa.getEname()
    }
}
