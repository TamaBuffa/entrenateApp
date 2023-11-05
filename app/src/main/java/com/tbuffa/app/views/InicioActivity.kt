package com.tbuffa.app.views
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tbuffa.app.databinding.ActivityPerfilBinding
import com.tbuffa.app.databinding.InicioActivityBinding
import com.tbuffa.app.model.Constants
import com.tbuffa.app.model.Usuario
import com.tbuffa.app.repository.UsuarioRepository
import kotlin.reflect.KClass

class InicioActivity : AppCompatActivity() {

    lateinit var binding: InicioActivityBinding
    private lateinit var userRepository: UsuarioRepository
    private var usuario: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InicioActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRepository = UsuarioRepository()

//        val id = intent.getLongExtra(Constants.USER_ID, -1)
        val email=intent.getStringExtra(Constants.USER_EMAIL)
//        val nombre=intent.getStringExtra(Constants.USER_NOMBRE)


        if (email != null) {
//            Log.d("InicioActivity", "Valor de email: $email")
            val usuariosEncontrados: List<Usuario> = userRepository.getPorEmail(email, this)
//            Log.d("InicioActivity", "Cantidad de usuarios encontrados: ${usuariosEncontrados.size}")
            for (usuario in usuariosEncontrados) {
                binding.tvsaludoNombre.text= "Bienvenida ${(usuario.nombre)}" }
        }


        binding.btnMiPerfil.setOnClickListener() {
            val intent = Intent(this, PerfilActivity::class.java)
            intent.putExtra(Constants.USER_EMAIL, email)
            startActivity(intent)
        }



        binding.btnEntrena.setOnClickListener() {
            goToEntrenamiento()
        }
    }



    private fun goToEntrenamiento() {
        val intent = Intent(this, EntrenaActivity::class.java)
        startActivity(intent)
    }
    private fun goToPerfil() {
        val intent = Intent(this, PerfilActivity::class.java)
        startActivity(intent)
    }


}



//            binding.tvsaludoNombre.text=  usuariosEncontrados.toString()

//        val em=userRepository.getPorEmail(email.toString(),this)
//      usuario = userRepository.getById(id, this)
//      val em=userRepository.getPorEmail(email.toString(),this    )

//        Log.d("InicioActivity", "Antes de llamar a getPorEmail")
//        val usuariosEncontrados: List<Usuario> = userRepository.getPorEmail(email.toString(), this)
//        Log.d("InicioActivity", "Después de llamar a getPorEmail")
//
//        for (usuario in usuariosEncontrados) {
//            Log.d("InicioActivity", "ID: ${usuario.id}, Nombre: ${usuario.nombre}, Email: ${usuario.email}")
//        }

//        binding.tvsaludoNombre.text = "Bienvenida ${(em)}"


//        binding.btnMiPerfil.setOnClickListener() {
//            goToPerfil()
//        }









//var id = intent.getLongExtra(usuario!!.id)
//usuario= usuarioRepository.getById(id,this)

//        usuario = usuarioRepository.getById(id, this)
////        var nombre= intent.getStringExtra(usuario!!.nombre)
//


//
//        if (textViewEmail != null) {
//                binding.tvsaludoNombre.text = "Hola $textViewEmail"
//            }
//


//        registradosDBHelper= sqlLite(this)

