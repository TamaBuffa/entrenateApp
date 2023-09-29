package com.tbuffa.app
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast

class InicioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio_activity)
    }



}



//**Menu que no funcionó**//

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater: MenuInflater =menuInflater
//        inflater.inflate(R.menu.menu,menu)
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