package com.testapp

import com.testapp.User
import grails.plugin.springsecurity.annotation.Secured
import groovy.json.JsonSlurper
import proyectocumple.Regalo

class UserService {

	@Secured(['ROLE_USER'])
	def buscarCumpleanierosPorMesActual(){
			def today = new Date()
			def mesActual = today.getMonth()

			def cumpleanieros = User.where {
				//  year(fechaCumple) == 1980
				month(fechaCumple) == mesActual + 1
			}			
	}

	@Secured(['ROLE_ADMIN'])
	def guardarRegaloEnEmpleado(idEmpleado, idRegalo){

		def empleado = User.get(idEmpleado)

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

		//def empleado = User.findById(empleado.id)
		empleado.save()
	}

	@Secured(['ROLE_ADMIN'])
	def guardarEmpleado(params){
		def empleado = new User()
		empleado.username = params.nombre
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