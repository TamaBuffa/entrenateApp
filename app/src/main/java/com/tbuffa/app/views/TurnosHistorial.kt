package com.tbuffa.app.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tbuffa.app.R
import com.tbuffa.app.databinding.ActivityPerfilBinding
import com.tbuffa.app.databinding.ActivityTurnosHistorialBinding
import com.tbuffa.app.model.Constants
import com.tbuffa.app.model.Usuario
import com.tbuffa.app.model.turno
import com.tbuffa.app.repository.TurnoRepository
import com.tbuffa.app.repository.UsuarioRepository

class TurnosHistorial : AppCompatActivity() {

    lateinit var binding: ActivityTurnosHistorialBinding
    private lateinit var turnoRepository: TurnoRepository
    private lateinit var userRepository: UsuarioRepository
    private var turno: turno? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTurnosHistorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRepository = UsuarioRepository()
        turnoRepository = TurnoRepository()


        // Obtener el email del usuario desde los extras del intent
        val email = intent.getStringExtra(Constants.USER_EMAIL)
    }}
//        val turnosEncontrados: List<turno> =turnoRepository.getPorEmail(email,this)

//        for (turno in turnosEncontrados) {
//            binding.tvHistorial.text=("Turno con ${turno.entrenador} a las ${turno.hora_cita}\n")
//            }
//
//
//    }

