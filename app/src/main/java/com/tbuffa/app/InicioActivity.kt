package com.tbuffa.app
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import java.nio.channels.InterruptedByTimeoutException

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio_activity)

        val btnMiPerfil=findViewById<Button>(R.id.btnMiPerfil)
        btnMiPerfil.setOnClickListener {
            val i =Intent(this, PerfilActivity::class.java)
            startActivity(i)
        }

    }


}



//**Menu que no funcionó**//

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater: MenuInflater =menuInflater
//        MenuInflater.inflate(R.menu.menu,menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item:MenuItem): Boolean {
//       when (item.itemId) {
//            R.id.itemHome->{ Toast.makeText(this,"Home", Toast.LENGTH_SHORT).show()
//            return true
//       }
//           else -> return super.onOptionsItemSelected(item)
//       }
//    }