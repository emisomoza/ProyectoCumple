import com.testapp.Role
import com.testapp.User
import com.testapp.UserRole
import proyectocumple.Empresa

class BootStrap {

	def init = { servletContext ->
        Empresa accenture = new Empresa(Ename: 'Accenture').save()
        User admin = new User(username:'admin', password:'admin', apellido:'apellido', fechaCumple:'0000-00-00 00:00:00', empresa:'1',  enabled:true).save()
        User emisomoza = new User(username:'emisomoza', password:'123456', apellido:'apellido', fechaCumple:'0000-00-00 00:00:00', empresa:'1',  enabled:true).save()
        User imatellan = new User(username:'imatellan', password:'1234', apellido:'apellido', fechaCumple:'0000-00-00 00:00:00', empresa:'1',  enabled:true).save()
        Role user_role = new Role(authority: 'ROLE_USER').save()
        Role admin_role = new Role(authority: 'ROLE_ADMIN').save()
        UserRole.create(admin, user_role)
        UserRole.create(admin, admin_role)
        UserRole.create(emisomoza, user_role)
        UserRole.create(imatellan, user_role)
	} 
}
