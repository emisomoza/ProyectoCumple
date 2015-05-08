import com.testapp.Role
import com.testapp.User
import com.testapp.UserRole

class BootStrap {

	def init = { servletContext ->

        User admin = new User(username:'admin', password:'password', enabled:true).save()
        User emisomoza = new User(username:'emisomoza', password:'123456', enabled:true).save()
        User imatellan = new User(username:'imatellan', password:'1234', enabled:true).save()
        Role user = new Role(authority: 'ROLE_USER').save()
        Role admin_role = new Role(authority: 'ROLE_ADMIN').save()
        UserRole.create(admin, user)
        UserRole.create(admin, admin_role)
        UserRole.create(emisomoza, user)
        UserRole.create(imatellan, user)
	} 
}
