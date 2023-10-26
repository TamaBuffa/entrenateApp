package com.tbuffa.app
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CursorAdapter
import android.widget.TextView
import android.widget.Toast
import com.tbuffa.app.databinding.ActivityPerfilBinding
import com.tbuffa.app.databinding.InicioActivityBinding
import java.nio.channels.InterruptedByTimeoutException

class InicioActivity : AppCompatActivity() {

    lateinit var binding: InicioActivityBinding
    lateinit var registradosDBHelper:sqlLite

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=InicioActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar la base de datos helper
        registradosDBHelper = sqlLite(this)


//        val textViewNombre = intent.getStringExtra("nombreUsuario")
        val textViewEmail=intent.getStringExtra("emailUsuario")

        if (textViewEmail != null) {
            binding.tvsaludoNombre.text = "Bienvenida $textViewEmail"
        }


        binding.btnMiPerfil.setOnClickListener() {
            val intent = Intent(this, PerfilActivity::class.java)
            intent.putExtra("emailUsuario", textViewEmail)
            startActivity(intent)


    }

        binding.btnEntrena.setOnClickListener() {
            val intent = Intent(this, EntrenaActivity::class.java)
            startActivity(intent)


        }

    }

}



//
//        if (textViewEmail != null) {
//                binding.tvsaludoNombre.text = "Hola $textViewEmail"
//            }
//


//        registradosDBHelper= sqlLite(this)










//**Menu que no funcionó**//
