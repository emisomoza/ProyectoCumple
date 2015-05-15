package proyectocumple

import grails.test.*

class EmpresaControllerTests extends ControllerUnitTestCase {
	void testIndex() {
		controller.index()
		assertEquals '/index', redirectArgs.uri
	}
}