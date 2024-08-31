open class Empleado(
    dni: String,
    nombre: String,
    apellido: String,
    fechaNacimiento: String,
    direccion: String,
    ciudadProcedencia: String,
    val codigoEmpleado: String,
    val horasExtras: Int,
    val fechaIngreso: String,
    val area: String,
    val cargo: String)
    : Persona(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia)
