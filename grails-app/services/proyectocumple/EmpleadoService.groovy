package proyectocumple

import proyectocumple.Empleado
import groovy.json.JsonSlurper

class EmpleadoService{

	def buscarCumpleanierosPorMesActual(){
			def today = new Date()
			def mesActual = today.getMonth()

			def cumpleanieros = Empleado.where {
				//  year(fechaCumple) == 1980
				month(fechaCumple) == mesActual + 1
			}			
	}

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