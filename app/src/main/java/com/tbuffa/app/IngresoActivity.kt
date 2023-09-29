package com.tbuffa.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class IngresoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ingreso_activity)


        val btnIngreso=findViewById<Button>(R.id.btnLogin)
        btnIngreso.setOnClickListener {
            val i= Intent(this,PerfilActivity::class.java)
            startActivity(i)
        }

        val tvIrRegitrarse=findViewById<TextView>(R.id.tvIrRegistrarse)
        tvIrRegitrarse.setOnClickListener{
            val i= Intent(this,RegistroActivity::class.java)
            startActivity(i)
        }
    }


}