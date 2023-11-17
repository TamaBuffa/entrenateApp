package com.tbuffa.app.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tbuffa.app.databinding.IngresoActivityBinding
import com.tbuffa.app.databinding.RegistroActivityBinding
import com.tbuffa.app.model.Constants
import com.tbuffa.app.repository.UsuarioRepository

class IngresoActivity : AppCompatActivity() {

    lateinit var binding: IngresoActivityBinding
    private lateinit var userRepository: UsuarioRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= IngresoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRepository = UsuarioRepository()

        binding.btnLogin.setOnClickListener {
            val email = binding.etCorreo.text.toString()
            val password = binding.etPassw.text.toString()

            val usuario = userRepository.getUsuarioByEmailPassword(email, password, this)
            if (usuario != null) {
                // Las credenciales coinciden, procede con la actividad principal

                val intent = Intent(this, InicioActivity::class.java)
                intent.putExtra(Constants.USER_EMAIL, usuario.email)
                startActivity(intent)


            } else {
                // Las credenciales son incorrectas
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }

            binding.etCorreo.text.clear()
            binding.etPassw.text.clear()
        }



          binding.tvIrRegistrarse.setOnClickListener{
              val i= Intent(this, RegistroActivity::class.java)
              startActivity(i)
          }
 }


}