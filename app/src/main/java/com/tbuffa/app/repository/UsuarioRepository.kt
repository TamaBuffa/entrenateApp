package com.tbuffa.app.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.media.MediaRouter.UserRouteInfo
import com.tbuffa.app.model.Usuario

class UsuarioRepository {

    fun guardar (usuario: Usuario, context:Context): Usuario{
        val datos= ContentValues()
        datos.put ("nombre",usuario.nombre )
        datos.put ("apellido",usuario.apellido)
        datos.put ("email",usuario.email)
        datos.put ("password",usuario.password)
        datos.put("rutaFoto", usuario.rutaFoto) // Guarda la ruta de la foto
        val db = DbHelper(context).getWrittingDataBase()
        val id = db.insert("registrados", null, datos)
        usuario.id = id
        db.close()
        return usuario
    }

    fun getById(id: Long, context:Context): Usuario? {
        val db = DbHelper(context).getReadableDataBase()
        val query = "SELECT * FROM registrados WHERE id = ?"
        var args = arrayOf(id.toString())
        val cursor = db.rawQuery(query, args)
        var user : Usuario? = null
        if(cursor.moveToFirst()){
             user = getUser(cursor)
        }
        cursor.close()
        db.close()
        return user
    }

    private fun getUser(cursor: Cursor): Usuario? {
        var user = Usuario(
            cursor.getLong(cursor.getColumnIndexOrThrow("id")),
            cursor.getString(cursor.getColumnIndexOrThrow("nombre")),
            cursor.getString(cursor.getColumnIndexOrThrow("apellido")),
            cursor.getString(cursor.getColumnIndexOrThrow("email")),
            cursor.getString(cursor.getColumnIndexOrThrow("password")),
            cursor.getString(cursor.getColumnIndexOrThrow("rutaFoto")) // Obtiene la ruta de la foto desde la base de datos
//            cursor.getString(cursor.getColumnIndexOrThrow("reppass"))
        )

        return user
    }

//            cursor.getString(cursor.getColumnIndexOrThrow("reppass"))
//        cursor.getString(cursor.getColumnIndexOrThrow("photoPath"))



    fun getPorEmail(email: String, context: Context): List<Usuario> {
        val db = DbHelper(context).getReadableDataBase()
        val query = "SELECT * FROM registrados WHERE email = ?"
        var args = arrayOf(email.toString())
        val cursor = db.rawQuery(query, args)
        val users = getUsers(cursor)
        cursor.close()
        db.close()
        return users
    }

    private fun getUsers(cursor: Cursor): List<Usuario> {
        var users = mutableListOf<Usuario>()
        if (cursor.moveToFirst()) {
            do {
                users.add(this.getUser(cursor)!!)
            } while (cursor.moveToNext())
        }
        return users
    }

}


