package com.tbuffa.app.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tbuffa.app.databinding.IngresoActivityBinding

class IngresoActivity : AppCompatActivity() {

    lateinit var binding: IngresoActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= IngresoActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnLogin.setOnClickListener {
            val i= Intent(this, InicioActivity::class.java)
            startActivity(i)
        }

          binding.tvIrRegistrarse.setOnClickListener{
              val i= Intent(this, RegistroActivity::class.java)
              startActivity(i)
          }
 }


}