package com.tbuffa.app.views
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tbuffa.app.databinding.ActivityMainBinding
import com.tbuffa.app.databinding.InicioActivityBinding
import com.tbuffa.app.model.Constants
import com.tbuffa.app.model.Usuario
import com.tbuffa.app.repository.TurnoRepository
import com.tbuffa.app.repository.UsuarioRepository

class InicioActivity : AppCompatActivity() {

    lateinit var binding: InicioActivityBinding
    private lateinit var userRepository: UsuarioRepository
    private var usuario: Usuario? = null
    private lateinit var turnoRepository: TurnoRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InicioActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRepository = UsuarioRepository()
        turnoRepository=TurnoRepository()

        var email=intent.getStringExtra(Constants.USER_EMAIL)

        if (email != null) {
            val usuariosEncontrados: List<Usuario> = userRepository.getPorEmail(email, this)
            for (usuario in usuariosEncontrados) {
                binding.tvsaludoNombre.text= "¡Hola ${(usuario.nombre)} !" }
        }


        binding.ivMiPerfil.setOnClickListener() {
            val intent = Intent(this, PerfilActivity::class.java)
            intent.putExtra(Constants.USER_EMAIL, email)
            startActivity(intent)
        }

        binding.ivTurno.setOnClickListener() {
            val intent= Intent(this,TurnoActivity::class.java)
            intent.putExtra(Constants.USER_EMAIL, email)
            startActivity(intent)
        }

        binding.ivEntrena.setOnClickListener() {
            goToEntrenamiento()
        }


        binding.ivHistorialTurnos.setOnClickListener {
            val intent = Intent(this,HistorialTurnosActivity::class.java)
            intent.putExtra(Constants.USER_EMAIL, email)
            startActivity(intent)
        }

        binding.ibcerrarSesion.setOnClickListener{
            val intent = Intent(this,IngresoActivity::class.java)
            startActivity(intent)
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



//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        val inflater:MenuInflater=menuInflater
//        inflater.inflate(R.menu.main_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }




//        /*-----TOOLBAR------*/
//        val toolbar:androidx.appcompat.widget.Toolbar=binding.toolbar
//        setSupportActionBar(toolbar)
//
//        /*-----NAVIGATION DRAWER MENU------*/
////        binding.navView.bringToFront()
//        drawer=binding.drawerLayout
//        toogle = ActionBarDrawerToggle(this, drawer, toolbar,
//            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
//       drawer.addDrawerListener(toogle)


//        binding.navView.setNavigationItemSelectedListener(this)
//        binding.navView.setCheckedItem(R.id.nav_perfil)

//        val navigationView=binding.navView
//        navigationView.setNavigationItemSelectedListener(this)







//
//    override fun onPostCreate(savedInstanceState: Bundle?) {
//        super.onPostCreate(savedInstanceState)
//        toogle.syncState()
//
//    }
//
//    override fun onConfigurationChanged(newConfig: Configuration) {
//        super.onConfigurationChanged(newConfig)
//        toogle.onConfigurationChanged(newConfig)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if(toogle.onOptionsItemSelected(item)){
//        return true
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//     override fun onOptionsItemSelected(menu: MenuItem): Boolean {
//         return when (menu.itemId) {
//            R.id.nav_perfil-> {
//                goToSettings()
//                true
//            }
//            R.id.nav_entrenamientos-> {
//                Toast.makeText(this, "Opción 2 escogida", Toast.LENGTH_LONG).show()
//                true
//            }
//            R.id.nav_turnos-> {
//                Toast.makeText(this, "Opción 3 escogida", Toast.LENGTH_LONG).show()
//                true
//            }
//
//             R.id.nav_historialTurnos-> {
//                 Toast.makeText(this, "Opción 3 escogida", Toast.LENGTH_LONG).show()
//                 true
//             }
//
//            else -> super.onOptionsItemSelected(menu)
//
//        }
//}
//
//    private fun goToSettings() {
//        val intent = Intent(this, PerfilActivity::class.java)
//        startActivity(intent)
//
//}
//}






//        override fun onBackPressed() {
//            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
//                binding.drawerLayout.closeDrawer(GravityCompat.START)
//            } else {
//                super.onBackPressed()
//            }
//        }

//
//        override fun OnNavigationItemSelected(menuItem: MenuItem): Boolean {
//            when (menuItem.itemId) {
//                R.id.nav_perfil -> {
//                    val intent = Intent(this, PerfilActivity::class.java)
//                    startActivity(intent)
//                }
//
//                R.id.nav_entrenamientos -> {
//                    val intent = Intent(this, EntrenaActivity::class.java)
//                    startActivity(intent)
//                }
//
//                R.id.nav_turnos -> {
//
//                }
//
//                R.id.nav_historialTurnos -> {
//
//                }
//
//            }
//
//            return true
//        }
//
//
//    }
//




//    public void onBackPressed() {
//        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
//            binding.drawerLayout.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed()
//        }
//    }
//        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//            switch(menuItem.getItemId()) {
//                case R . id . nav_perfil;
//                break;
//            }
//        binding.drawerLayout.closeDrawer(GravityCompat.START)
//        return true;
//        }
//    }







//    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
//        when (menuItem.itemId) {
//            R.id.nav_perfil -> {
//                val intent = Intent(this, PerfilActivity::class.java)
//                startActivity(intent)
//                return true
//            }
//
//            else -> return false
//        }
//    }
//}



//                R.id.nav_entrenamientos->{
//                    Toast.makeText(this, "Entrenamientos", Toast.LENGTH_SHORT).show()
//                    val intent = Intent(this, EntrenaActivity::class.java)
//                    startActivity(intent)
//                    true
//                }

//                R.id.nav_turnos->{
//                    Toast.makeText(this, "Turnos", Toast.LENGTH_SHORT).show()
//                    true
//                }
//
//                R.id.nav_historialTurnos->{
//                    Toast.makeText(this, "Historial Turnos", Toast.LENGTH_SHORT).show()
//                    true
//                }











//
//        val id = intent.getLongExtra(Constants.USER_ID, -1)
//
//        val nombre=intent.getStringExtra(Constants.USER_NOMBRE)
//
//
//        if (email != null) {
////            Log.d("InicioActivity", "Valor de email: $email")
//            val usuariosEncontrados: List<Usuario> = userRepository.getPorEmail(email, this)
////            Log.d("InicioActivity", "Cantidad de usuarios encontrados: ${usuariosEncontrados.size}")
//            for (usuario in usuariosEncontrados) {
//                binding.tvsaludoNombre.text= "Bienvenida ${(usuario.nombre)}" }
//        }
//
//        binding.btnMiPerfil.setOnClickListener() {
//            val intent = Intent(this, PerfilActivity::class.java)
//            intent.putExtra(Constants.USER_EMAIL, email)
//            startActivity(intent)
//        }


//        binding.btnEntrena.setOnClickListener() {
//            goToEntrenamiento()
//        }
//    }



//    private fun goToEntrenamiento() {
//        val intent = Intent(this, EntrenaActivity::class.java)
//        startActivity(intent)
//    }
//    private fun goToPerfil() {
//        val intent = Intent(this, PerfilActivity::class.java)
//        startActivity(intent)
//    }


//}









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

