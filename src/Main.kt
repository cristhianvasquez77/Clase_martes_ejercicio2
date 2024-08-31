fun main() {
    val registroHospital = RegistroYcontrol()

    fun solicitarDato(campo: String): String {
        print("Ingrese $campo: ")
        return readln()
    }
    fun capturarDatosPaciente(): Paciente {
        val dni = solicitarDato("Ingrese el DNI del paciente:")
        val nombre = solicitarDato("Ingrese el nombre del paciente:")
        val apellido = solicitarDato("Ingrese el apellido del paciente:")
        val fechaNacimiento = solicitarDato("Ingrese la fecha de nacimiento del paciente (dd/mm/yyyy):")
        val direccion = solicitarDato("Ingrese la dirección del paciente:")
        val ciudadProcedencia = solicitarDato("Ingrese la ciudad de procedencia del paciente:")
        val numeroHistoriaClinica = solicitarDato("Ingrese el número de historia clínica del paciente:")
        val sexo = solicitarDato("Ingrese el sexo del paciente:")
        val grupoSanguineo = solicitarDato("Ingrese el grupo sanguíneo del paciente:")
        val alergias = solicitarDato("Ingrese las alergias del paciente (separadas por coma):").split(",")

        return Paciente(dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia, numeroHistoriaClinica, sexo, grupoSanguineo, alergias)
    }
    fun capturarDatosEmpleado(): Empleado {
        println("Seleccione el tipo de empleado:")
        println("1. Planilla")
        println("2. Eventual")
        val tipoEmpleado = when (readln()) {
            "1" -> TipoEmpleado.Planilla
            "2" -> TipoEmpleado.Eventual
            else -> throw Exception("Tipo de empleado no válido")
        }


        val dni = solicitarDato("Ingrese el DNI del empleado:")
        val nombre = solicitarDato("Ingrese el nombre del empleado:")
        val apellido = solicitarDato("Ingrese el apellido del empleado:")
        val fechaNacimiento = solicitarDato("Ingrese la fecha de nacimiento del empleado (dd/mm/yyyy):")
        val direccion = solicitarDato("Ingrese la dirección del empleado:")
        val ciudadProcedencia = solicitarDato("Ingrese la ciudad de procedencia del empleado:")
        val codigoEmpleado = solicitarDato("Ingrese el código del empleado:")
        val horasExtras = solicitarDato("Ingrese el número de horas extras:").toInt()
        val fechaIngreso = solicitarDato("Ingrese la fecha de ingreso (dd/mm/yyyy):")
        val area = solicitarDato("Ingrese el área del empleado:")
        val cargo = solicitarDato("Ingrese el cargo del empleado:")

        return when (tipoEmpleado) {
            TipoEmpleado.Planilla -> {

                val salarioMensual = solicitarDato("Ingrese el salario mensual:").toDouble()
                val porcentajeAdicionalHoraExtra = solicitarDato("Ingrese el porcentaje adicional por hora extra:").toDouble()

                EmpleadoPlanilla(
                    dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia,
                    codigoEmpleado, horasExtras, fechaIngreso, area, cargo,
                    salarioMensual, porcentajeAdicionalHoraExtra
                )
            }
            TipoEmpleado.Eventual -> {

                val honorariosPorHora = solicitarDato("Ingrese los honorarios por hora:").toDouble()
                val totalHorasTrabajadas = solicitarDato("Ingrese el número total de horas trabajadas:").toInt()
                val fechaTerminoContrato = solicitarDato("Ingrese la fecha de término del contrato (dd/mm/yyyy):")

                EmpleadoEventual(
                    dni, nombre, apellido, fechaNacimiento, direccion, ciudadProcedencia,
                    codigoEmpleado, horasExtras, fechaIngreso, area, cargo,
                    honorariosPorHora, totalHorasTrabajadas, fechaTerminoContrato
                )
            }
        }
    }

    fun capturarDatosMedico(): Medico {
        println("\n=== Registro de Médico ===")
        val dni = solicitarDato("DNI")
        val nombre = solicitarDato("nombre")
        val apellido = solicitarDato("apellido")
        val fechaNacimiento = solicitarDato("fecha de nacimiento (dd/mm/yyyy)")
        val direccion = solicitarDato("dirección")
        val ciudadProcedencia = solicitarDato("ciudad de procedencia")
        val codigoEmpleado = solicitarDato("código de empleado")
        val horasExtras = solicitarDato("número de horas extras").toInt()
        val fechaIngreso = solicitarDato("fecha de ingreso (dd/mm/yyyy)")
        val area = solicitarDato("área")
        val cargo = solicitarDato("cargo")
        val especialidad = solicitarDato("especialidad")
        val servicio = solicitarDato("servicio")
        val numeroConsultorio = solicitarDato("número de consultorio")

        return Medico(
            dni = dni,
            nombre = nombre,
            apellido = apellido,
            fechaNacimiento = fechaNacimiento,
            direccion = direccion,
            ciudadProcedencia = ciudadProcedencia,
            codigoEmpleado = codigoEmpleado,
            horasExtras = horasExtras,
            fechaIngreso = fechaIngreso,
            area = area,
            cargo = cargo,
            especialidad = especialidad,
            servicio = servicio,
            numeroConsultorio = numeroConsultorio
        )
    }

    while (true) {
        println("\n=== Sistema de Registro del Hospital ===")
        println("Seleccione una opción:")
        println("1. Registrar un nuevo paciente")
        println("2. Registrar un nuevo empleado")
        println("3. Registrar un nuevo médico")
        println("4. Registrar una nueva cita médica")
        println("5. Listar médicos por especialidad")
        println("6. Listar pacientes atendidos por un médico")
        println("7. Salir")

        when (readln()) {
            "1" -> {
                val paciente = capturarDatosPaciente()
                registroHospital.registrarPaciente(paciente)
                println("Paciente registrado con éxito.")
            }
            "2" -> {
                val empleado = capturarDatosEmpleado()
                registroHospital.registrarEmpleado(empleado)
                println("Empleado registrado con éxito.")
            }
            "3" -> {
                val medico = capturarDatosMedico()
                registroHospital.registrarMedico(medico)
                println("Médico registrado con éxito.")
            }
            "4" -> {
                println("Ingrese el DNI del paciente:")
                val dniPaciente = readln()
                val paciente = registroHospital.pacientes.find { it.dni == dniPaciente }
                if (paciente == null) {
                    println("Paciente no encontrado.")
                    continue
                }

                println("Ingrese el código del médico:")
                val codigoMedico = readln()
                val medico = registroHospital.medicos.find { it.codigoEmpleado == codigoMedico }
                if (medico == null) {
                    println("Médico no encontrado.")
                    continue
                }

                println("Ingrese la fecha de la cita (dd/mm/yyyy):")
                val fecha = readln()
                println("Ingrese la hora de la cita (hh:mm):")
                val hora = readln()
                println("Ingrese el servicio para la cita:")
                val servicio = readln()

                val cita = CitaMedica(paciente, medico, fecha, hora, servicio)
                registroHospital.registrarCita(cita)
                println("Cita médica registrada con éxito.")
            }
            "5" -> {
                println("Ingrese la especialidad para listar médicos:")
                val especialidad = readln()
                val medicos = registroHospital.listarMedicosPorEspecialidad(especialidad)
                if (medicos.isEmpty()) {
                    println("No se encontraron médicos con la especialidad $especialidad.")
                } else {
                    println("Médicos con la especialidad $especialidad:")
                    medicos.forEach { medico ->
                        println("${medico.nombre} ${medico.apellido}")
                    }
                }
            }
            "6" -> {
                println("Ingrese el código del médico para listar los pacientes atendidos:")
                val codigoMedico = readln()
                val pacientes = registroHospital.listarPacientesPorMedico(codigoMedico)
                if (pacientes.isEmpty()) {
                    println("No se encontraron pacientes atendidos por el médico con código $codigoMedico.")
                } else {
                    println("Pacientes atendidos por el médico con código $codigoMedico:")
                    pacientes.forEach { paciente ->
                        println("${paciente.nombre} ${paciente.apellido}")
                    }
                }
            }
            "7" -> {
                break
            }
            else -> println("Opción no válida, por favor intente de nuevo.")
        }
    }
}
