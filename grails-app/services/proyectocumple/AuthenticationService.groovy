package proyectocumple

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder

class AuthenticationService {

	public Authentication getAuth() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication()
		return auth
	}

}
