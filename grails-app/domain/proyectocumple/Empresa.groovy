package proyectocumple

import com.testapp.User

class Empresa {

    String Ename
    static hasMany = [empleados: User]
    static constraints = {
    }
    static mapping = {
        empleados column: 'empleado_empresa_id', joinTable: false
    }
}
