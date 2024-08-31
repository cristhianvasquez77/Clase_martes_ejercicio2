class RegistroYcontrol {
    val pacientes = mutableListOf<Paciente>()
    val empleados = mutableListOf<Empleado>()
    val medicos = mutableListOf<Medico>()
    val citasMedicas = mutableListOf<CitaMedica>()

    fun registrarPaciente(paciente: Paciente) {
        try{
            pacientes.add(paciente)
        }catch (e: Exception) {
            println("Error al registrar el paciente: ${e.message}")
        }
    }

    fun registrarEmpleado(empleado: Empleado) {
        try{
            empleados.add(empleado)
        }catch (e: Exception) {
            println("Error al registrar el empleado: ${e.message}")
        }
    }

    fun registrarMedico(medico: Medico) {
        try{
            medicos.add(medico)
        }catch (e: Exception) {
            println("Error al registrar el medico: ${e.message}")
        }
    }

    fun registrarCita(cita: CitaMedica) {
       try{
           citasMedicas.add(cita)
       }catch (e: Exception) {
           println("Error al registrar la cita médica: ${e.message}")
       }
    }

    fun listarMedicosPorEspecialidad(especialidad: String): List<Medico> {
        return medicos.filter { it.especialidad == especialidad }
    }

    fun listarPacientesPorMedico(codigoMedico: String): List<Paciente> {
        val citasPorMedico = citasMedicas.filter { it.medico.codigoEmpleado == codigoMedico }
        return citasPorMedico.map { it.paciente }
    }
}
class CitaMedica(val paciente: Paciente, val medico: Medico, val fecha: String, val hora: String, val servicio: String)

