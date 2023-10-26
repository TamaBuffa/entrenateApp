package com.tbuffa.app.views
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tbuffa.app.databinding.InicioActivityBinding
import com.tbuffa.app.model.Constants
import com.tbuffa.app.model.Usuario
import com.tbuffa.app.repository.UsuarioRepository
import kotlin.reflect.KClass

class InicioActivity : AppCompatActivity() {

    lateinit var binding: InicioActivityBinding
    lateinit var usuarioRepository: UsuarioRepository
    var usuario: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inicializarActivity()

        if (usuario != null) {
            binding.tvsaludoNombre.text = "Bienvenida ${usuario!!.email}"
        }

        binding.btnMiPerfil.setOnClickListener() {
            goToPerfil()
        }

        binding.btnEntrena.setOnClickListener() {
            goToEntrenamiento()
        }
    }


    private fun goToEntrenamiento() {
        val intent = Intent(this, EntrenaActivity::class.java)
        intent.putExtra("emailUsuario", usuario!!.email)
        startActivity(intent)
    }
    private fun goToPerfil() {
        val intent = Intent(this, PerfilActivity::class.java)
        startActivity(intent)
    }

    private fun inicializarActivity() {
        binding = InicioActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        usuarioRepository = UsuarioRepository()
        var id = intent.getLongExtra(Constants.USER_ID, -1)
        usuario = usuarioRepository.getById(id, this)
    }

}



//
//        if (textViewEmail != null) {
//                binding.tvsaludoNombre.text = "Hola $textViewEmail"
//            }
//


//        registradosDBHelper= sqlLite(this)










//**Menu que no funcionó**//
