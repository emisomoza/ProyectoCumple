package com.testapp

import grails.plugins.rest.client.RestBuilder

//import grails.plugins.rest.client.RestBuilder
import static org.springframework.http.HttpStatus.*
import grails.converters.JSON
import grails.plugin.springsecurity.SpringSecurityUtils
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import proyectocumple.EmpresaService

@Transactional
class UserController {

    EmpresaService empresaService
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userInstanceCount: User.count()]
    }

    def show(User userInstance) {
        respond userInstance
    }

    def create() {
        respond new User(params)
    }

    @Transactional
    def save(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'create'
            return
        }

        userInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*' { respond userInstance, [status: CREATED] }
        }
    }

    def edit(User userInstance) {
        respond userInstance
    }

    @Transactional
    def update(User userInstance) {
        if (userInstance == null) {
            notFound()
            return
        }

        if (userInstance.hasErrors()) {
            respond userInstance.errors, view:'edit'
            return
        }

        userInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect userInstance
            }
            '*'{ respond userInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(User userInstance) {

        if (userInstance == null) {
            notFound()
            return
        }

        userInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'User.label', default: 'User'), userInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }

    //WARNING!!!!!  This here to the end of the class is a copy-paste from the old "EmpleadosController.groovy" class
    UserService userService
    def scaffold = true

//	static allowedMethods = [elegirRegalo: 'POST',
//							 asignarRegalo: 'POST']

    def login() {

    }

    @Secured(['ROLE_USER'])
    def buscarCumpleaniero() {
        def listaEmpleadosEmpresa = empresaService.getEmpleadosPorEmpresa()
		def empleadosEmpresaMesActual = userService.buscarCumpleanierosPorMesActual(listaEmpleadosEmpresa)
        [empleadosEmpresaMesActual: empleadosEmpresaMesActual]
        //	return new ModelAndView ('/proyectocumplevista/cumpleDelMes', [listaEmpleadosCumple: listaEmpleadosCumple])
    }

    @Secured(['ROLE_USER'])
    def buscarUserViaREST() {
        def listaEmpleadosEmpresa = empresaService.getEmpleadosPorEmpresa()
        def empleadosEmpresaMesActual = userService.buscarCumpleanierosPorMesActual(listaEmpleadosEmpresa)
        [empleadosEmpresaMesActual: empleadosEmpresaMesActual]
        //	return new ModelAndView ('/proyectocumplevista/cumpleDelMes', [listaEmpleadosCumple: listaEmpleadosCumple])
    }

    @Secured(['ROLE_USER'])
    def agregarUserViaREST() {
        def listaEmpleadosEmpresa = empresaService.getEmpleadosPorEmpresa()
        def empleadosEmpresaMesActual = userService.buscarCumpleanierosPorMesActual(listaEmpleadosEmpresa)
        [empleadosEmpresaMesActual: empleadosEmpresaMesActual]
        //	return new ModelAndView ('/proyectocumplevista/cumpleDelMes', [listaEmpleadosCumple: listaEmpleadosCumple])
    }

    @Secured(['ROLE_USER'])
    def elegirRegalo() {
        def empleado = User.get(params.id)

        def anioActual = new Date().getYear()
        def regaloMesActual = empleado.regaloDeCumpleanios

        def anioRegalo
        def mostrar = true

        empleado.regaloDeCumpleanios.each() {
            anioRegalo = it.fechaDeAsignacion.getYear()
            if ( anioRegalo == anioActual ){
                mostrar= false
            }
        }

        [empleado: empleado, mostrar: mostrar, anioRegalo: anioRegalo, anioActual: anioActual]

        //	return new ModelAndView ('/proyectocumplevista/buscarRegalos', [idEmpleado: idEmpleado])

    }

    @Secured(['ROLE_ADMIN'])
    @Transactional
    def asignarRegalo() {

        def idEmpleado = params.idEmpleado
        def idRegalo = params.idRegalo

        def empleado = userService.guardarRegaloEnEmpleado(idEmpleado,idRegalo)
        [empleado: empleado]
        //	return new ModelAndView ('/proyectocumplevista/mostrarRegaloAsignado', [empleado: empleado])

    }

    @Secured(['ROLE_USER'])
    def asignarRegaloPost() {

        def idEmpleado = params.idEmpleado
        def idRegalo = params.idRegalo



        def empleado = User.get(idEmpleado)

        // empleado.regaloDeCumpleanios.add(regalo)



        [empleado: empleado,idRegalo: idRegalo]
        //	return new ModelAndView ('/proyectocumplevista/mostrarRegaloAsignado', [empleado: empleado])

    }

    @Secured(['ROLE_USER'])
    def confirmacionDeGuardado() {

        def idEmpleado = params.idEmpleado
        def idRegalo = params.idRegalo

        def empleado = userService.guardarRegaloEnEmpleado(idEmpleado,idRegalo)

        [empleado: empleado]
        //	return new ModelAndView ('/proyectocumplevista/mostrarRegaloAsignado', [empleado: empleado])

    }
	
	def logout() {
		session.invalidate()
		redirect uri: SpringSecurityUtils.securityConfig.logout.filterProcessesUrl
	}

	def obtenerRegalos() {
				RestBuilder rest = new RestBuilder()
				String apiMeli = "https://api.mercadolibre.com/sites/MLA/search?q=" + params.buscar
				
				def resp = rest.get(apiMeli)
				render resp as JSON
			}

}
