package com.tbuffa.app.views

import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.Toast
import com.tbuffa.app.R
import com.tbuffa.app.databinding.ActivityTurnoBinding
import com.tbuffa.app.databinding.InicioActivityBinding
import com.tbuffa.app.model.Constants
import com.tbuffa.app.model.Entrenador
import com.tbuffa.app.model.Usuario
import com.tbuffa.app.model.turno
import com.tbuffa.app.repository.TurnoDatabaseHelper
import com.tbuffa.app.repository.TurnoRepository
import com.tbuffa.app.repository.UsuarioRepository
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class turnoActivity : AppCompatActivity() {

    lateinit var binding: ActivityTurnoBinding
    private lateinit var turnoRepository: TurnoRepository
    private lateinit var userRepository: UsuarioRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTurnoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRepository = UsuarioRepository()
        turnoRepository = TurnoRepository()


// Configurar Spinner con tipos de entrenamiento
        val tiposEntrenamiento = listOf("Yoga", "CrossFit", "Funcional")
        val adapterEntrenamiento = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiposEntrenamiento)
        adapterEntrenamiento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spEntrenamiento.adapter = adapterEntrenamiento

        // Configurar Spinner con horarios disponibles
        val horarioDisponible = listOf("08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00")
        val horarioEntrenamiento = ArrayAdapter(this, android.R.layout.simple_spinner_item, horarioDisponible)
        horarioEntrenamiento.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spHorarDisp.adapter = horarioEntrenamiento

        // Configurar Spinner para horarios disponibles del entrenador
        val horarioEntrenadorAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, emptyList<String>())
        horarioEntrenadorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spHorariDisp.adapter = horarioEntrenadorAdapter


        binding.btnVolveraConsultar.setOnClickListener{
            binding.cvConsulta.visibility = View.VISIBLE
            binding.cvConfirmar.visibility = View.GONE
            binding.btnConsulta.visibility = View.VISIBLE
            binding.btnConfirmar.visibility= View.GONE
            binding.btnVolveraConsultar.visibility=View.GONE
        }

        binding.btnConsulta.setOnClickListener {
            // Obtener el tipo de entrenamiento, nivel y horario seleccionados
            val tipoEntrenamiento = binding.spEntrenamiento.selectedItem.toString()
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
                    val horariosFiltrados = horariosDisponiblesEntrenador.filter { it == horarioSeleccionado }

                    if (horariosFiltrados.isNotEmpty()) {
                        // Actualizar el Spinner de horarios disponibles del entrenador
                        val horariosEntrenadorAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, horariosFiltrados)
                        horariosEntrenadorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                        binding.spHorariDisp.adapter = horariosEntrenadorAdapter
                    }
                }

                // Mostrar el CardView de confirmación
                binding.cvConsulta.visibility = View.GONE
                binding.btnConsulta.visibility = View.GONE
                binding.cvConfirmar.visibility = View.VISIBLE
                binding.btnConfirmar.visibility= View.VISIBLE
                binding.btnVolveraConsultar.visibility=View.VISIBLE

            } else {
                // No se encontraron entrenadores disponibles para los parámetros seleccionados.
                // Puedes mostrar un mensaje de error o manejarlo según tus necesidades.
            }
        }



        binding.btnConfirmar.setOnClickListener {
            // Obtener el entrenador y horario seleccionados para la confirmación
            var entrenadorSeleccionado = binding.spEntrenDisp.selectedItem.toString()
            var horarioEntrenadorSeleccionado = binding.spHorariDisp.selectedItem.toString()
            var tipoEntrenamientoSeleccionado=binding.spEntrenamiento.selectedItem.toString()

//            var usuario = getUser()
//            turnoRepository.guardarTurno(usuario , this)


                // Luego, puedes redirigir al usuario o realizar otras acciones necesarias
                Toast.makeText(this, "Turno con $entrenadorSeleccionado a las $horarioEntrenadorSeleccionado confirmado",
                    Toast.LENGTH_SHORT
                ).show()
                finish()

        }

    }

//
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



    private fun filtrarEntrenadores(tipoEntrenamiento: String, nivel: String): List<Entrenador> {
        return listaEntrenadores.filter { entrenador ->
            entrenador.especialidad == tipoEntrenamiento && entrenador.nivel == nivel
        }
    }

    private val listaEntrenadores = listOf(

        Entrenador("Maria Perez", "Yoga", "Inicial", "1511111111", listOf("08:00", "10:00", "12:00", "14:00", "16:00", "18:00")),
        Entrenador("Leonardo Gimenez", "Yoga", "Intermedio", "1522222222", listOf("09:00", "11:00", "13:00", "15:00", "17:00", "19:00")),
        Entrenador("Carlos Silva", "Yoga", "Avanzado", "1533333333", listOf("10:00", "12:00", "14:00", "16:00", "18:00")),
        Entrenador("Mariano Luca", "Yoga", "Inicial", "1544444444", listOf("07:00", "11:00", "13:00", "16:00", "18:00")),

        Entrenador("Florencia Villalba", "CrossFit", "Inicial", "1555555555", listOf("08:00", "10:00", "12:00", "14:00", "16:00", "18:00")),
        Entrenador("Nicolas Diaz", "CrossFit", "Intermedio", "1544444444", listOf("09:00", "11:00", "13:00", "15:00", "17:00", "19:00")),
        Entrenador("Leandro Suarez", "CrossFit", "Avanzado", "1555555555", listOf("10:00", "12:00", "14:00", "16:00", "18:00")),
        Entrenador("Monica Sanchez", "CrossFit","Inicial", "1555555555", listOf("7:00", "11:00", "13:00", "16:00", "18:00")),
        )

}


