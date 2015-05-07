package proyectocumple

import proyectocumple.Empleado
import grails.plugin.springsecurity.annotation.Secured
import groovy.json.JsonSlurper

class EmpleadoService{

	@Secured(['ROLE_USER'])
	def buscarCumpleanierosPorMesActual(){
			def today = new Date()
			def mesActual = today.getMonth()

			def cumpleanieros = Empleado.where {
				//  year(fechaCumple) == 1980
				month(fechaCumple) == mesActual + 1
			}			
	}

	@Secured(['ROLE_ADMIN'])
	def guardarRegaloEnEmpleado(idEmpleado, idRegalo){

		def empleado = Empleado.get(idEmpleado)

		def fecha = new Date()
		
		def url = "https://api.mercadolibre.com/items/" + idRegalo
		url = url.toURL()
		def strJson = url.getText(requestProperties: [Accept: 'application/json'])
		def json = new JsonSlurper().parseText(strJson)

		def regalo = new Regalo()
		regalo.idMeli = idRegalo
		regalo.titulo = json.title
		regalo.link = json.permalink
		regalo.fechaDeAsignacion = fecha
		empleado.addToRegaloDeCumpleanios(regalo)

		//def empleado = Empleado.findById(empleado.id)
		empleado.save()
	}

	@Secured(['ROLE_ADMIN'])
	def guardarEmpleado(params){
		def empleado = new Empleado()
		empleado.nombre = params.nombre
		empleado.apellido = params.apellido
		empleado.fechaCumple = params.cumple
		empleado.save()
	}

}


/*

def buscarCumpleaniero() {
		def listaEmpleadosCumple = empleadoService.buscarCumpleanierosPorMesActual()
		[listaEmpleadosCumple: listaEmpleadosCumple]
	}


	def elegirRegalo() {
		
		def idEmpleado = params.idEmpleado
		return new ModelAndView ('/proyectocumplevista/buscarRegalos', [idEmpleado: idEmpleado])
		render view: "blbj",model: []

*/