package com.tbuffa.app.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.util.Log
import com.tbuffa.app.model.Usuario
import com.tbuffa.app.model.turno

class TurnoRepository {

fun guardar(turno: turno,context: Context):turno{
    val datos = ContentValues()
    datos.put("emailUsuario", turno.emailUsuario)
    datos.put("tipoEntrenamiento", turno.tipoEntrenamiento)
    datos.put("entrenador", turno.entrenador)
    datos.put("dia_cita", turno.dia_cita)
    datos.put("hora_cita", turno.hora_cita)
    val db = TurnoDatabaseHelper(context).getWrittingDataBase()
    val id = db.insert("turnos", null, datos)
    turno.id = id
    db.close()
//    Log.d("TurnoRepository", "Turno guardado: $turno")
    return turno

}


private fun getUser(cursor: Cursor): turno? {
        var user = turno(
        cursor.getLong(cursor.getColumnIndexOrThrow("id")),
        cursor.getString(cursor.getColumnIndexOrThrow("emailUsuario")),
        cursor.getString(cursor.getColumnIndexOrThrow("tipoEntrenamiento")),
        cursor.getString(cursor.getColumnIndexOrThrow("entrenador")),
        cursor.getString(cursor.getColumnIndexOrThrow("dia_cita")),
        cursor.getString(cursor.getColumnIndexOrThrow("hora_cita"))
            ,)

        return user
    }


    private fun getUsers(cursor: Cursor): List<turno> {
        var users = mutableListOf<turno>()
        if (cursor.moveToFirst()) {
            do {
                users.add(this.getUser(cursor)!!)
            } while (cursor.moveToNext())
        }
        return users
    }

    fun getById(id: Long, context:Context): turno? {
        val db = TurnoDatabaseHelper(context).getReadableDataBase()
        val query = "SELECT * FROM turnos WHERE id = ?"
        var args = arrayOf(id.toString())
        val cursor = db.rawQuery(query, args)
        var user : turno? = null
        if(cursor.moveToFirst()){
            user = getUser(cursor)
        }
        cursor.close()
        db.close()
        return user
    }


    fun getPorEmail(email: String, context: Context): List<turno> {
        val db = TurnoDatabaseHelper(context).getReadableDataBase()
        val query = "SELECT * FROM turnos WHERE emailUsuario = ?"
        var args = arrayOf(email.toString())
        val cursor = db.rawQuery(query, args)
        val users = getUsers(cursor)
        cursor.close()
        db.close()

        for (turno in users) {
            Log.d("TurnoData", "ID: ${turno.id}, Email: ${turno.emailUsuario}, Entrenador: ${turno.entrenador}")
            // Agrega más campos según los datos que quieras imprimir
        }

        return users
    }


//    fun getPorEmail(email: String, context: Context): List<turno> {
//        val db = TurnoDatabaseHelper(context).getReadableDataBase()
//        val query = "SELECT * FROM turnos WHERE emailUsuario = ?"
//        val cursor = db.rawQuery(query, arrayOf(email))
//        val users = getUsers(cursor)
//        cursor.close()
//        db.close()
//        return users
//    }


}







