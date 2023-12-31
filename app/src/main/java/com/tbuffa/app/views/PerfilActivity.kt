package com.tbuffa.app.views

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.tbuffa.app.R
import com.tbuffa.app.databinding.ActivityPerfilBinding
import com.tbuffa.app.databinding.InicioActivityBinding
import com.tbuffa.app.model.Constants
import com.tbuffa.app.model.Usuario
import com.tbuffa.app.repository.DbHelper
import com.tbuffa.app.repository.UsuarioRepository
import java.io.ByteArrayOutputStream
import java.io.File

class PerfilActivity : AppCompatActivity() {

    lateinit var binding: ActivityPerfilBinding
    private lateinit var userRepository: UsuarioRepository
    private var usuario: Usuario? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRepository = UsuarioRepository()

        val email = intent.getStringExtra(Constants.USER_EMAIL)

        if (email != null) {
            val usuariosEncontrados: List<Usuario> = userRepository.getPorEmail(email, this)
            if (usuariosEncontrados.isNotEmpty()) {
                usuario = usuariosEncontrados[0]
            }
            for (usuario in usuariosEncontrados) {
                Log.d(
                    "InicioActivity",
                    "Cantidad de usuarios encontrados: ${usuariosEncontrados.size}"
                )
                Log.d("InicioActivity", "Valor de foto: ${usuario.rutaFoto}")

                binding.tvNombrePerfil.text = usuario.nombre
                binding.tvApellidoPerfil.text = usuario.apellido
                binding.tvEmailPerfil.text = usuario.email
                binding.tvRutaFoto.text = usuario.rutaFoto



            // Cargar la imagen del usuario si está disponible

                if (usuario?.rutaFoto != null) {
                    val fileName = usuario?.rutaFoto
                    val file = File(filesDir, fileName)
                    if (file.exists()) {
                        val imageBitmap = BitmapFactory.decodeFile(file.absolutePath)
                        binding.ivCamara.setImageBitmap(imageBitmap)
                    }
                }
            }
        }


        binding.tvCamara.setOnClickListener {
            startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
    }

    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            val imageBitmap = intent?.extras?.get("data") as Bitmap
            binding.ivCamara.setImageBitmap(imageBitmap)

            // Guardar la imagen en almacenamiento interno
            val fileName = usuario?.email?.let { "profile_image_$it.jpg" } ?: "default_filename.jpg"
            val file = File(filesDir, fileName)
            file.createNewFile()
            file.outputStream().use {
                imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
            }
//            Log.d("Guardado", "Ruta de la foto guardada: ${file.absolutePath}")
            // Asociar la imagen al usuario
            usuario!!.rutaFoto = fileName
            usuario.let { userRepository.guardar(usuario!!, this) }

        }
    }
}




//                    val byteArrayOutputStream = ByteArrayOutputStream()
//                    imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
//                    val byteArray = byteArrayOutputStream.toByteArray()
//                    // Llama a la función guardar con el usuario y el arreglo de bytes
//                    usuario = userRepository.guardar(usuario, byteArray, this)


















//
//            binding.tvCamara.setOnClickListener() {
//                startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
//
//            }
//        }
//
//            private val startForResult= registerForActivityResult(ActivityResultContracts.StartActivityForResult())
//            {
//                    result: ActivityResult ->
//
//                if (result.resultCode == Activity.RESULT_OK) {
//                    val intent = result.data
//                    val imageBitmap = intent?.extras?.get("data") as Bitmap
//                    binding.ivCamara.setImageBitmap(imageBitmap)
//                }
//
//            }



//                    val byteArrayOutputStream = ByteArrayOutputStream()
//                    imageBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream)
//                    val byteArray = byteArrayOutputStream.toByteArray()
//                    // Llama a la función guardar con el usuario y el arreglo de bytes
//                    usuario = userRepository.guardar(usuario, byteArray, this)










//            private fun cargarFotoDelUsuario(usuario: Usuario) {
//                val imageFilePath = usuario.photoPath // Supongamos que la ruta se guarda en la propiedad "photoPath" del objeto Usuario
//
//                val bitmap = BitmapFactory.decodeFile(imageFilePath)
//                binding.ivCamara.setImageBitmap(bitmap)
//            }







//            binding.tvCamara.setOnClickListener() {
//                startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
//            }
//        }

//
//
//        rivate fun inicializarActivity() {
//            binding = ActivityPerfilBinding.inflate(layoutInflater)
//            setContentView(binding.root)
//            usuarioRepository = UsuarioRepository()
//
//            var id = intent.getLongExtra(Constants.USER_ID, -1)
//
//            usuario = usuarioRepository.getById(id, this)
//        }
















//            if (email != null) {
//                binding.tvNombrePerfil.text = "Bienvenida $email"
//            }





//            fun obtenerDatosUsuarioPorEmail(email: String): Boolean {
//            val db: SQLiteDatabase? = registradosDBHelper.readableDatabase
//            val query = "SELECT nombre FROM registrados WHERE email = ?"
//            val cursor = db!!.rawQuery(query, arrayOf(email))
//
//            if (cursor.moveToFirst()) {
//
//                val nombreUsuario=cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
//                binding.tvNombrePerfil.text = nombreUsuario
//                binding.tvNombrePerfil.text = "Bienvenida $nombreUsuario"
//                cursor.close()
//                db.close()
//
//                return true // Se encontraron datos y se mostraron en los TextView
//
//                } else {
//                    cursor.close()
//                    db.close()
//
//                    return false // No se encontraron datos para el email proporcionado
//                }
//                }


//                val nombreIndex = cursor.getColumnIndexOrThrow("nombre")
//                val apellidoIndex = cursor.getColumnIndexOrThrow("apellido")
//
//                val nombre = cursor.getString(nombreIndex)
//                val apellido = cursor.getString(apellidoIndex)
//
//                val nombre = cursor.getString(cursor.getColumnIndex("nombre"))
//                val apellido = cursor.getString(cursor.getColumnIndex("apellido"))

//                // Mostrar los datos en los TextView
//                binding.tvNombrePerfil.text = nombre
//                binding.tvApellidoPerfil.text = apellido

//                binding.tvNombrePerfil.text = nombre
//                binding.tvApellidoPerfil.text = apellido











//
//            var user: detalleUsuarios? = null
//
//            if (cursor.moveToFirst()) {
//                // Se encontraron resultados, crea un objeto User con nombre y apellido
//                user = detalleUsuarios(
//                    binding.tvNombrePerfil.text.toString() = cursor.getString(cursor.getColumnIndex("nombre")),
//                    binding.tvApellidoPerfil.text.toString = cursor.getString(cursor.getColumnIndex("apellido"))
//                )
//            }
//
//            cursor.close()
//            db.close()
//
//            return user
//        }
//
//


//            val nombre = userData.getString("nombre")
////            val apellido = userData.getString("apellido")







        // Inicializar la base de datos helper
//        registradosDBHelper = sqlLite(this)
//
//        // En la actividad OtraActividad
//        val emailUsuario = intent.getStringExtra("emailUsuario")
//        val userData = registradosDBHelper.consultarEmail(emailUsuario)
//
//        if (userData != null) {
//            val nombre = userData.getString("nombre")
////            val apellido = userData.getString("apellido")
//
//            // Actualizar la interfaz de usuario con los datos obtenidos
//
//            binding.tvNombrePerfil.text = "Nombre: $nombre"
////            binding.tvApellidoPerfil.text = "Apellido: $apellido"
//            // Puedes agregar más campos según sea necesario
//
//        } else {
//            Toast.makeText(this, "Usuario no encontrado en la base de datos", Toast.LENGTH_SHORT).show()
//        }
//    }






//        if (emailUsuario != null) {
//            binding.tvNombrePerfil.text = "Bienvenida $emailUsuario"
//        }
//
//        if (emailUsuario != null) {
//            val cursor = registradosDBHelper.obtenerDatosUsuarioPorEmail(emailUsuario)
//
//            if (cursor != null && cursor.moveToFirst()) {
//                val nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"))
//
//                binding.tvNombrePerfil.text = "Nombre: $nombre"
//
//
//
//            }
//            cursor?.close()
//        }
//












        //EN ESTA PANTALLA TENGO UN TEXTVIEW!!!

//
//        val usuarioId = intent.getIntExtra("textViewId", -1)
//
//        // Verificar si se proporcionó un ID válido
//        if (usuarioId != -1){
//
//             // Obtener los detalles del usuario según el ID
//            val userDetails = registradosDBHelper.obtenerdatos(usuarioId)
//
//
//            // Mostrar los detalles del usuario en la interfaz de usuario
//            if (userDetails != null) {
//                binding.tvNombrePerfil.text = userDetails.nombre
//                binding.tvApellidoPerfil.text = userDetails.apellido
//                binding.tvEmailPerfil.text = userDetails.email
//
//        }
//        else {
////            // Manejar el caso en el que no se proporcionó un ID válido
//              Toast.makeText(this, "ID de usuario no válido", Toast.LENGTH_SHORT).show()
//        }
//    }






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




        //NUEVO


        // Abrir la base de datos en modo lectura
//        val db : SQLiteDatabase = registradosDBHelper.readableDatabase

        // Realizar una consulta para obtener los datos que deseas mostrar
        //recorre los datos

//        val cursor= db.rawQuery("SELECT * FROM registrados", null)
//
//        val adaptador= CursorAdapterTextView(this, cursor)
//        binding.lvPerfil.adapter=adaptador
//        db.close()
//    }
//
//        inner class CursorAdapterTextView(context: Context, cursor: Cursor):
//            CursorAdapter(context,cursor, FLAG_REGISTER_CONTENT_OBSERVER) {
//
//            //crea la vista
//            override fun newView(context: Context?, cursor: Cursor?, parent: ViewGroup?): View {
//                val inflater= LayoutInflater.from(context)
//                return inflater.inflate(R.layout.item_add,parent, false)
//            }







//
//
//          // Enlazar con la vista
//            override fun bindView(view: View?, context: Context?, cursor: Cursor?) {
//                val bindingItems= ItemAddBinding.bind(view!!)
//                bindingItems.tvNombrePerfil.text=cursor!!.getString(1)
//                bindingItems.tvApellidoPerfil.text=cursor!!.getString(2)
//                bindingItems.tvEmailPerfil.text=cursor!!.getString(3)
//
//            view.setOnClickListener(){
//                Toast.makeText(this@PerfilActivity, "${bindingItems.tvNombrePerfil.text}" +
//                    "${bindingItems.tvApellidoPerfil.text}" + "${bindingItems.tvEmailPerfil.text}"
//                     , Toast.LENGTH_LONG).show()
//
//            }
//
//            }
//
//        }





//

        //FUNCIONA



