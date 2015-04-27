package proyectocumple

import proyectocumple.Empleado

class EmpleadoService{

	def buscarCumpleanierosPorMesActual(){
			
			def today = new Date()
			def mesAtual = today.month

			def cumpleanieros = Empleado.list()
			def resultadoLista 

		/*
			cumpleanieros.each {
				def mesEmpleado = (it.fechaCumple).month
				if (mesEmpleado == mesActual) {

					resultadoLista.add(it)
				}
			}
		*/

		/*
		  for (def empleado: cumpleanieros) {

        	def mesEmpleado = empleado.fechaCumple.month
				if (mesEmpleado == mesActual) {

					resultadoLista.add(it)
          }
*/
   			
	}

}