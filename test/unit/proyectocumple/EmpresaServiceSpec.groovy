package proyectocumple



import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

@TestFor(EmpresaService)
@Mock(AuthenticationService)
class EmpresaServiceSpec extends Specification {
    void testEmpresaServiceGetEmpresa() {

        def empresa = service.getEmpresa()

    }
}