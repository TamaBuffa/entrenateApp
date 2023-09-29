package com.tbuffa.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegistroActivity : AppCompatActivity() {


    lateinit var registradosDBHelper: sqlLite
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro_activity)

        registradosDBHelper= sqlLite(this)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellido = findViewById<EditText>(R.id.etApellido)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassw = findViewById<EditText>(R.id.etPassw)
        val etRepPassw = findViewById<EditText>(R.id.etRepPassw)
        val btnRegistro = findViewById<Button>(R.id.btnRegistrarme)
        val tvIngreso=findViewById<TextView>(R.id.tvIrIngreso)


        tvIngreso.setOnClickListener {
                val i=Intent(this,IngresoActivity::class.java )
                startActivity(i)
        }

        btnRegistro.setOnClickListener {
            val nombre = etNombre.text.toString()
            val apellido = etApellido.text.toString()
            val email = etEmail.text.toString()
            val passw = etPassw.text.toString()
            val repPassw = etRepPassw.text.toString()

            if (nombre.isNotBlank() && apellido.isNotBlank() && email.isNotBlank()
                && passw.isNotBlank() && repPassw.isNotBlank()) {

                registradosDBHelper.anadirdato(nombre, apellido, email, passw, repPassw)

                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,InicioActivity::class.java))
            }
            else {
                Toast.makeText(this, "No se ha podido guardar", Toast.LENGTH_LONG).show()
            }
        }
    }
}
