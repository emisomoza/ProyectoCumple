package proyectocumple

import grails.test.*
import spock.lang.Specification

@TestFor(EmpresaService)
@Mock(AuthenticationService)
class EmpresaServiceSpec extends Specification {
	void testEmpresaServiceGetEmpresa() {
		
		def empresa = service.getEmpresa()

	}
}
