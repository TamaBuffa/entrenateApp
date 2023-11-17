package com.tbuffa.app.views

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.tbuffa.app.R
import com.tbuffa.app.databinding.ActivityTurnoBinding
import com.tbuffa.app.model.Constants
import com.tbuffa.app.model.Entrenador
import com.tbuffa.app.model.Usuario
import com.tbuffa.app.model.turno
import com.tbuffa.app.repository.TurnoRepository
import com.tbuffa.app.repository.UsuarioRepository
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TurnoActivity : AppCompatActivity() {

    lateinit var binding: ActivityTurnoBinding
    private lateinit var turnoRepository: TurnoRepository
    private lateinit var userRepository: UsuarioRepository
    private var usuario: Usuario? = null
    private var turno: turno? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTurnoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRepository = UsuarioRepository()
        turnoRepository = TurnoRepository()

        val email = intent.getStringExtra(Constants.USER_EMAIL)

// Configurar Spinner con tipos de entrenamiento
        val tiposEntrenamiento = listOf("Yoga", "CrossFit", "Funcional")
        val adapterEntrenamiento =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposEntrenamiento)
        adapterEntrenamiento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spTipoEntrenamiento.adapter = adapterEntrenamiento

        // Configurar Spinner con horarios disponibles
        val horarioDisponible = listOf(
            "08:00",
            "09:00",
            "10:00",
            "11:00",
            "12:00",
            "13:00",
            "14:00",
            "15:00",
            "16:00",
            "17:00",
            "18:00",
            "19:00",
            "20:00"
        )
        val horarioEntrenamiento =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, horarioDisponible)
        horarioEntrenamiento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spHorarDisp.adapter = horarioEntrenamiento

        // Configurar Spinner para horarios disponibles del entrenador
        val horarioEntrenadorAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, emptyList<String>())
        horarioEntrenadorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spHorariDisp.adapter = horarioEntrenadorAdapter

        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val date = Date()

        val currentDate = dateFormat.format(date)
        binding.tvfecha.text = currentDate


        binding.btnConsulta.setOnClickListener {
            // Obtener el tipo de entrenamiento, nivel y horario seleccionados
            val tipoEntrenamiento = binding.spTipoEntrenamiento.selectedItem.toString()
            val nivelSeleccionado = when (binding.radioGroupNivel.checkedRadioButtonId) {
                R.id.radioInicial -> "Inicial"
                R.id.radioIntermedio -> "Intermedio"
                R.id.radioAvanzado -> "Avanzado"
                else -> "" // Maneja el caso donde no se selecciona ningún nivel
            }
            val horarioSeleccionado = binding.spHorarDisp.selectedItem.toString()

            // Filtrar entrenadores disponibles según los parámetros seleccionados
            val entrenadoresDisponibles = filtrarEntrenadores(tipoEntrenamiento, nivelSeleccionado)

            if (entrenadoresDisponibles.isNotEmpty()) {
                // Actualizar el Spinner con los entrenadores disponibles
                val entrenadoresAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
                    entrenadoresDisponibles.map { it.nombre })
                entrenadoresAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                binding.spEntrenDisp.adapter = entrenadoresAdapter

                // Filtrar los horarios disponibles del primer entrenador de la lista según el horario seleccionado
                val primerEntrenador = entrenadoresDisponibles.firstOrNull()
                if (primerEntrenador != null) {
                    val horariosDisponiblesEntrenador = primerEntrenador.horarioDisponibilidad
                    val horariosFiltrados =
                        horariosDisponiblesEntrenador.filter { it == horarioSeleccionado }

                    if (horariosFiltrados.isNotEmpty()) {
                        // Actualizar el Spinner de horarios disponibles del entrenador
                        val horariosEntrenadorAdapter = ArrayAdapter(
                            this,
                            android.R.layout.simple_spinner_item,
                            horariosFiltrados
                        )
                        horariosEntrenadorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        binding.spHorariDisp.adapter = horariosEntrenadorAdapter
                    }
                }

                // Mostrar el CardView de confirmación
                binding.cvConsulta.visibility = View.GONE
                binding.btnConsulta.visibility = View.GONE
                binding.cvConfirmar.visibility = View.VISIBLE
                binding.btnConfirmar.visibility = View.VISIBLE
                binding.btnVolveraConsultar.visibility = View.VISIBLE

            } else {
                // No se encontraron entrenadores disponibles para los parámetros seleccionados.
                // Puedes mostrar un mensaje de error o manejarlo según tus necesidades.
            }
        }
            binding.btnVolveraConsultar.setOnClickListener {
            binding.cvConsulta.visibility = View.VISIBLE
            binding.btnConsulta.visibility = View.VISIBLE
            binding.cvConfirmar.visibility = View.GONE
            binding.btnConfirmar.visibility = View.GONE
            binding.btnVolveraConsultar.visibility = View.GONE


        }

        binding.btnConfirmar.setOnClickListener {
            guardarUsuario()
            binding.cvConfirmar.visibility = View.GONE
            binding.btnConfirmar.visibility = View.GONE
            binding.cvConsulta.visibility = View.GONE
            binding.btnConsulta.visibility = View.GONE
            binding.btnVolveraConsultar.visibility = View.GONE
            binding.btnIrHome.visibility=View.VISIBLE
            binding.reservaTurnos.visibility=View.VISIBLE
            binding.ivWhsp.visibility=View.VISIBLE
            mostrarTurno()
            val email = intent.getStringExtra(Constants.USER_EMAIL)
            intent.putExtra(Constants.USER_EMAIL, email)



            binding.btnIrHome.setOnClickListener {
                val email = intent.getStringExtra(Constants.USER_EMAIL)
                val intent = Intent(this, InicioActivity::class.java)
                intent.putExtra(Constants.USER_EMAIL, email)
                startActivity(intent)
            }

    } }

    private fun filtrarEntrenadores(tipoEntrenamiento: String, nivel: String): List<Entrenador> {
        return listaEntrenadores.filter { entrenador ->
            entrenador.especialidad == tipoEntrenamiento && entrenador.nivel == nivel
        }
    }

    private fun guardarUsuario() {
            val email = intent.getStringExtra(Constants.USER_EMAIL)
            var turno = getUser(email.toString())
            val turnoGuardado = turnoRepository.guardar(turno , this)
//            Log.d("TurnoRepository", "Turno guardado con ID: ${turnoGuardado.id}")

            Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()

    }


    private fun getUser(emailUsuario: String): turno {
        val tipoEntrenamientoSeleccionado = binding.spTipoEntrenamiento.selectedItem.toString()
        val entrenadorSeleccionado = binding.spEntrenDisp.selectedItem.toString()
        val horarioEntrenadorSeleccionado = binding.spHorariDisp.selectedItem.toString()
        val fechaactual = binding.tvfecha.text.toString()

        return turno(-1, emailUsuario, tipoEntrenamientoSeleccionado, entrenadorSeleccionado, fechaactual, horarioEntrenadorSeleccionado)
    }


    private fun mostrarTurno(){

        val tvFechaTurno = binding.tvfecha.text.toString()
        val tvHoraTurno = binding.spHorariDisp.selectedItem.toString()
        val tvTipEntrenamTurno = binding.spTipoEntrenamiento.selectedItem.toString()
        val tvNivelTurno = when (binding.radioGroupNivel.checkedRadioButtonId) {
            R.id.radioInicial -> "Inicial"
            R.id.radioIntermedio -> "Intermedio"
            R.id.radioAvanzado -> "Avanzado"
            else -> ""
        }
        val tvEntrenadorTurno = binding.spEntrenDisp.selectedItem.toString()
        val entSeleccionado = listaEntrenadores.find { it.nombre == tvEntrenadorTurno }
        val telefonoEntrenadorTurno = entSeleccionado?.telefono ?: "Teléfono no encontrado"


        // Asignar el texto directamente a tvturnoreservado
        binding.tvFechaTurno.text="Fecha: $tvFechaTurno"
        binding.tvHoraTurno.text="Hora $tvHoraTurno"
        binding.tvTipEntrenamTurno.text="Tipo de entrenamiento: $tvTipEntrenamTurno"
        binding.tvNivelTurno.text="Nivel: $tvNivelTurno"
        binding.tvEntrenadorTurno.text="Entrenador: $tvEntrenadorTurno"
        binding.telefonoEntrenadorTurno.text="Celular: $telefonoEntrenadorTurno"

    }


    private val listaEntrenadores = listOf(

        Entrenador("Maria Perez", "Yoga", "Inicial", "1534294750", listOf("08:00", "10:00", "12:00", "14:00", "16:00", "18:00")),
        Entrenador("Leonardo Gimenez", "Yoga", "Intermedio", "1534294739", listOf("09:00", "11:00", "13:00", "15:00", "17:00", "19:00")),
        Entrenador("Carlos Silva", "Yoga", "Avanzado", "1534294740", listOf("10:00", "12:00", "14:00", "16:00", "18:00")),
        Entrenador("Mariano Luca", "Yoga", "Inicial", "1534294741", listOf("07:00", "11:00", "13:00", "16:00", "18:00")),

        Entrenador("Florencia Villalba", "CrossFit", "Inicial", "1534294740", listOf("08:00", "10:00", "12:00", "14:00", "16:00", "18:00")),
        Entrenador("Nicolas Diaz", "CrossFit", "Intermedio", "1534294743", listOf("09:00", "11:00", "13:00", "15:00", "17:00", "19:00")),
        Entrenador("Leandro Suarez", "CrossFit", "Avanzado", "1534294744", listOf("10:00", "12:00", "14:00", "16:00", "18:00")),
        Entrenador("Monica Sanchez", "CrossFit","Inicial", "1534294745", listOf("7:00", "11:00", "13:00", "16:00", "18:00")),

        Entrenador("Vanesa Perez", "Funcional", "Inicial", "1534294746", listOf("08:00", "10:00", "12:00", "14:00", "16:00", "18:00")),
        Entrenador("David Quintero", "Funcional", "Intermedio", "1534294747", listOf("09:00", "11:00", "13:00", "15:00", "17:00", "19:00")),
        Entrenador("Diego Rivera", "Funcional", "Avanzado", "1534294748", listOf("10:00", "12:00", "14:00", "16:00", "18:00")),
        Entrenador("Carlos Martin", "Funcional","Inicial", "1534294749", listOf("7:00", "11:00", "13:00", "16:00", "18:00")),

        )

    fun openWhatsApp(view: View) {
        val nombreEntrenador=binding.tvEntrenadorTurno.text
        val horaTurno=binding.tvHoraTurno.text
        val diaTurno=binding.tvFechaTurno.text
        val phoneNumber = binding.telefonoEntrenadorTurno.text
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data =
            Uri.parse("https://api.whatsapp.com/send?phone=$phoneNumber&text=Reserva en Entrenate:%20$nombreEntrenador%20     $diaTurno%20$horaTurno")
        startActivity(intent)
    }




}

//    private fun mostrarTurno() {
//        val emailUsuario = intent.getStringExtra(Constants.USER_EMAIL)
//        val ultimoTurno = if (emailUsuario != null) {
//            obtenerUltimoTurnoUsuario(emailUsuario)
//        } else {
//            null
//        }
//
//        if (ultimoTurno != null) {
//            binding.tvturnoreservado.text = "Último turno reservado: ${ultimoTurno.tipoEntrenamiento} " +
//                    "con ${ultimoTurno.entrenador} el ${ultimoTurno.dia_cita} a las ${ultimoTurno.hora_cita}"
//        } else {
//            // Acciones si no se encuentra ningún turno para el usuario
//            binding.tvturnoreservado.text = "No hay turnos previamente reservados"
//        }
//    }

//
//    fun obtenerUltimoTurnoUsuario(emailUsuario: String): turno? {
//        val turnosEncontrados: List<turno> = TurnoRepository().getPorEmail(emailUsuario,this)
//        return if (turnosEncontrados.isNotEmpty()) {
//            turnosEncontrados.lastOrNull()
//        } else {
//            null
//        }
//    }
//










//
//
//
//    private fun guardarUsuario() {
//        val emailUsuario = intent.getStringExtra(Constants.USER_EMAIL)
//        val turnos = emailUsuario?.let { getUser(it) }
//        if (turnos != null) {
//            turnoRepository.guardar(turnos, this)
//            intent.putExtra(Constants.USER_EMAIL, turnos.emailUsuario)
//            Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
//        }
//
//
//        else {
//            Toast.makeText(this, "No se ha podido guardar", Toast.LENGTH_LONG).show()
//        }
//    }






//            mostrarTurno()
//
//            val email = intent.getStringExtra(Constants.USER_EMAIL)
//            if (email != null) {
//                val turnosEncontrados: List<turno> = turnoRepository.getPorEmail(email, this)
//                if (turnosEncontrados.isNotEmpty()) {
//                    val turnoReciente = turnosEncontrados.last()
//                    binding.turnoreservado.text =
//                        "Turno Registrado: ${turnoReciente.tipoEntrenamiento} con ${turnoReciente.entrenador} el ${turnoReciente.dia_cita} a las ${turnoReciente.hora_cita}"
//                }
//            }


//        val tvFechaTurno = binding.tvfecha.text.toString()
//        val tvhoraTurno = binding.spHorariDisp.selectedItem.toString()
//        val tvTipoEntrenamiento = binding.spTipoEntrenamiento.selectedItem.toString()
//        val entrenadorSeleccionado = binding.spEntrenDisp.selectedItem.toString()
//        val tvNivel = when (binding.radioGroupNivel.checkedRadioButtonId) {
//            R.id.radioInicial -> "Inicial"
//            R.id.radioIntermedio -> "Intermedio"
//            R.id.radioAvanzado -> "Avanzado"
//            else -> ""
//        }
//
//        val entSeleccionado = listaEntrenadores.find { it.nombre == entrenadorSeleccionado }
//        val telefonoEntrenador = entSeleccionado?.telefono ?: "Teléfono no encontrado"
//
//        println("Fecha del turno: $tvFechaTurno")
//        println("Hora del turno: $tvhoraTurno")
//        println("Tipo de Entrenamiento: $tvTipoEntrenamiento")
//        println("Nivel del entrenamiento: $tvNivel")
//        println("Teléfono del Entrenador: $telefonoEntrenador")
//
//        // Asignar el texto directamente a tvturnoreservado
//        binding.tvturnoreservado.text = "Turno Registrado: Su turno ha sido reservado para el $tvFechaTurno, a las $tvhoraTurno, $tvTipoEntrenamiento, $tvNivel, $telefonoEntrenador"
//




//
//}




//    private fun getUser(): turno {
//
//        var userId = intent.getLongExtra("userId",0)
//        intent.putExtra(Constants.USER_ID, userId)
//        var tipoEntrenamientoSeleccionado=binding.spEntrenamiento.selectedItem.toString()
//        return turno(-1,userId,binding.spEntrenamiento.selectedItem.toString(),
//            binding.spEntrenDisp.selectedItem.toString(),binding.spHorariDisp.selectedItem.toString())
//    }
//




//            intent.putExtra("tipoEntrenamiento", binding.spEntrenamiento.selectedItem.toString())
//            intent.putExtra("entrenador", binding.spEntrenDisp.selectedItem.toString())
//            intent.putExtra("Horario", binding.spHorariDisp.selectedItem.toString())

            // Aquí puedes implementar la lógica para confirmar el turno con el entrenador y horario seleccionados
//            Toast.makeText(
//                applicationContext,
//                "Turno con $entrenadorSeleccionado a las $horarioEntrenadorSeleccionado confirmado",
//                Toast.LENGTH_SHORT
//            ).show()
//            finish()
//        }
//    }





