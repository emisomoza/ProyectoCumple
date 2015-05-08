package com.testapp

import proyectocumple.Empresa
import proyectocumple.Regalo

class User {

	transient springSecurityService

	String username
	String password
	String apellido
	Date fechaCumple
	static hasOne = [empresa: Empresa]
//	String regaloDeCumpleanios
	static hasMany = [regaloDeCumpleanios: Regalo]
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static constraints = {
		username blank: false, unique: true
		password blank: false
		apellido()
		fechaCumple()
		regaloDeCumpleanios(display: false)
	}
	static mapping = {
		password column: '`password`'
		regaloDeCumpleanios column: 'empleado_regalo_id', joinTable: false
	}

	static transients = ['springSecurityService']

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}
