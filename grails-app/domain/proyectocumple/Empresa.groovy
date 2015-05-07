package proyectocumple

class Empresa {

    String Ename
    static hasMany = [empleados: Empleado]
    static constraints = {
    }
}
