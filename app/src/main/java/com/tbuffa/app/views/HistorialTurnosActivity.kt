package com.tbuffa.app.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tbuffa.app.databinding.ActivityHistorialTurnosBinding
import com.tbuffa.app.model.Constants
import com.tbuffa.app.model.turno
import com.tbuffa.app.repository.TurnoRepository
import com.tbuffa.app.repository.UsuarioRepository
import com.tbuffa.app.views.AdaptadorTurnos

class HistorialTurnosActivity : AppCompatActivity() {

    private lateinit var turnoRepository: TurnoRepository
    private lateinit var userRepository: UsuarioRepository
    lateinit var binding: ActivityHistorialTurnosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistorialTurnosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        turnoRepository = TurnoRepository()
        userRepository = UsuarioRepository()

        val emailUsuario = intent.getStringExtra(Constants.USER_EMAIL)

        if (emailUsuario != null) {
            val turnosDelUsuario = turnoRepository.getPorEmail(emailUsuario, this)
            val recyclerView = binding.rvHistorialTurnos
            recyclerView.layoutManager = LinearLayoutManager(this)
            val adaptadorTurnos = AdaptadorTurnos(ArrayList(turnosDelUsuario))
            recyclerView.adapter = adaptadorTurnos


        }


    }
}















//
//package com.tbuffa.app.views
//
//import android.os.Bundle
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.tbuffa.app.R
//import com.tbuffa.app.databinding.ActivityHistorialTurnosBinding
//import com.tbuffa.app.databinding.ActivityTurnoBinding
//import com.tbuffa.app.model.Constants
//import com.tbuffa.app.model.turno
//import com.tbuffa.app.repository.TurnoRepository
//import com.tbuffa.app.repository.UsuarioRepository
//import com.tbuffa.app.views.AdaptadorTurnos
//
//class HistorialTurnosActivity : AppCompatActivity() {
//
//    private lateinit var turnoRepository: TurnoRepository
//    private lateinit var userRepository: UsuarioRepository
//    lateinit var binding: ActivityHistorialTurnosBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityHistorialTurnosBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        turnoRepository = TurnoRepository()
//
//        val emailUsuario = intent.getStringExtra(Constants.USER_EMAIL)
//        if (emailUsuario != null) {
//            val turnosDelUsuario = turnoRepository.getPorEmail(emailUsuario, this)
//            val recyclerView = binding.rvHistorialTurnos
//            recyclerView.layoutManager = LinearLayoutManager(this)
//            val adaptadorTurnos = AdaptadorTurnos(ArrayList(turnosDelUsuario))
//            recyclerView.adapter =adaptadorTurnos
//        }
//
//
//
//    }
//}
//

//
//    private fun showTurns(turnos: List<turno>) {
//        for (turno in turnos) {
//            val textView = TextView(this)
//            textView.text = "Fecha del turno: ${turno.dia_cita}"
//            binding.llTurnosContainer.addView(textView)
//            // Agregar otros elementos de vista según sea necesario para cada turno
//        }
//    }
//}
//
//














//package com.tbuffa.app.views
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.tbuffa.app.R
//import com.tbuffa.app.databinding.ActivityHistorialTurnosBinding
//import com.tbuffa.app.model.Constants
//import com.tbuffa.app.model.Usuario
//import com.tbuffa.app.model.turno
//import com.tbuffa.app.repository.TurnoRepository
//import com.tbuffa.app.repository.UsuarioRepository
//import com.tbuffa.app.views.AdaptadorTurnos
//
//class HistorialTurnosActivity : AppCompatActivity() {
//    // ...
//    lateinit var binding: ActivityHistorialTurnosBinding
//    private lateinit var turnoRepository: TurnoRepository
//    private lateinit var userRepository: UsuarioRepository
//    private var usuario: Usuario? = null
//    private var turno: turno? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityHistorialTurnosBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//
//        val userRepository = UsuarioRepository() // Considerando que aquí tienes un repositorio para los usuarios.
//        val turnoRepository = TurnoRepository() // Repositorio para turnos
//        val emailUsuario = intent.getStringExtra(Constants.USER_EMAIL)
//
//        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewTurnos)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//
//        val turnosDelUsuario = turnoRepository.getPorEmail(emailUsuario, this)
//
//        // Crear un adaptador para los turnos
//        val adaptadorTurnos = AdaptadorTurnos(turnosDelUsuario)
//        recyclerView.adapter = adaptadorTurnos
//
//    }
//    }
//        val email: String? = intent.getStringExtra(Constants.USER_EMAIL)
//
//        email?.let { userEmail ->
//            val turnosEncontrados: List<turno> = turnoRepository.getPorEmail(userEmail, this)
//
//            val historialTurnos = StringBuilder()
//            for (turno in turnosEncontrados) {
//                historialTurnos.append("Turno con ${turno.entrenador} a las ${turno.hora_cita}\n")
//            }
//
//            binding.tvTurnos.text = historialTurnos.toString()
//        } ?: run {
//            // Manejar el caso donde el email es nulo
//            // Por ejemplo, mostrar un mensaje de error o tomar otra acción
//        }
//    }

