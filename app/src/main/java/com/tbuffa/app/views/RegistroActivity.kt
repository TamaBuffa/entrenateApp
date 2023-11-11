package com.tbuffa.app.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tbuffa.app.databinding.RegistroActivityBinding
import com.tbuffa.app.model.Constants
import com.tbuffa.app.model.Usuario
import com.tbuffa.app.repository.UsuarioRepository

class RegistroActivity : AppCompatActivity(){
    private lateinit var binding:RegistroActivityBinding
    private lateinit var userRepository: UsuarioRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegistroActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        userRepository = UsuarioRepository()

        binding.btnRegistrarme.setOnClickListener {

            guardarUsuario()
        }

    }

    private fun guardarUsuario() {
        if (validateUser()) {
            var usuario = getUser()
            userRepository.guardar(usuario , this)

            val intent = Intent(this, InicioActivity::class.java)
            intent.putExtra(Constants.USER_EMAIL, usuario.email)
            intent.putExtra(Constants.USER_ID, usuario.id)
            startActivity(intent)

            Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "No se ha podido guardar", Toast.LENGTH_LONG).show()
        }
    }

    private fun getUser(): Usuario {
        return Usuario(-1, binding.etNombre.text.toString(), binding.etApellido.text.toString(),
            binding.etEmail.text.toString(),binding.etPassw.text.toString(),null)
//            ,binding.etRepPassw.text.toString()),""
    }

    private fun validateUser(): Boolean {
        return binding.etNombre.text.isNotBlank() && binding.etApellido.text.isNotBlank() &&
                binding.etEmail.text.isNotBlank() && binding.etPassw.text.isNotBlank()
//                && binding.etRepPassw.text.isNotBlank()
    }
}



    //val intent = Intent(this, InicioActivity::class.java)
//////         intent.putExtra("nombreUsuario", binding.etNombre.text.toString())
//            intent.putExtra("emailUsuario", binding.etEmail.text.toString())
//            startActivity(intent)
//            Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
//

//                val usuario=registradosDBHelper.anadirdato(detalleUsuarios("-1","","","","",""))
//                registradosDBHelper.anadirdato(usuario)


//
//
//                var nuevoUsuario = detalleUsuarios()
//                var usuarioRegistrado = registradosDBHelper.anadirdato(nuevoUsuario)

//
////                intent.putExtra("UsuarioId", usuarioRegistrado)
//                intent.putExtra("UsuarioNombre", nombre)
//
////












//        registradosDBHelper = sqlLite(this)
//
//
//        val etNombre = findViewById<EditText>(R.id.etNombre)
//        val etApellido = findViewById<EditText>(R.id.etApellido)
//        val etEmail = findViewById<EditText>(R.id.etEmail)
//        val etPassw = findViewById<EditText>(R.id.etPassw)
//        val etRepPassw = findViewById<EditText>(R.id.etRepPassw)
//        val btnRegistro = findViewById<Button>(R.id.btnRegistrarme)
//        val tvIngreso = findViewById<TextView>(R.id.tvIrIngreso)
//
//
//        tvIngreso.setOnClickListener {
//            val i = Intent(this, IngresoActivity::class.java)
//            startActivity(i)
//        }

//        btnRegistro.setOnClickListener {
//            val nombre = etNombre.text.toString()
//            val apellido = etApellido.text.toString()
//            val email = etEmail.text.toString()
//            val passw = etPassw.text.toString()
//            val repPassw = etRepPassw.text.toString()
//
//            if (nombre.isNotBlank() && apellido.isNotBlank() && email.isNotBlank()
//                && passw.isNotBlank() && repPassw.isNotBlank())
//            {
//                val nuevoId= registradosDBHelper.anadirdato(nombre, apellido, email, passw, repPassw)
//                intent.putExtra("UsuarioId",nuevoId)
//                intent.putExtra("nombre", nombre)
//                startActivity(Intent(this, InicioActivity::class.java))
//                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
//
//            } else {
//                Toast.makeText(this, "No se ha podido guardar", Toast.LENGTH_LONG).show()
//            }
//        }
//    }
//}






//            binding.btnConsulta.setOnClickListener {
//                binding.tvConsultar.text=""
//                val db : SQLiteDatabase = registradosDBHelper.readableDatabase
//                val cursor= db.rawQuery("SELECT * FROM registrados", null)
//
//
//                if (cursor.moveToFirst()) {
//                    do {
//                        binding.tvConsultar.append(
//                            cursor.getInt(0).toString() + ": ")
//                        binding.tvConsultar.append(
//                            cursor.getString(1).toString()+ ", ")
//                        binding.tvConsultar.append(
//                            cursor.getString(2).toString()+ ", ")
//                        binding.tvConsultar.append(
//                            cursor.getString(3).toString()+ ", ")
//                        binding.tvConsultar.append(
//                            cursor.getString(4).toString()+ ", ")
//                        binding.tvConsultar.append(
//                            cursor.getString(5).toString() + "\n")
//
//                    } while (cursor.moveToNext())
//                }
//
//            }









