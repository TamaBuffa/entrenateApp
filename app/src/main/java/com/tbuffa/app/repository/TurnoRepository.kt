package com.tbuffa.app.repository

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.tbuffa.app.model.Usuario
import com.tbuffa.app.model.turno

class TurnoRepository {

    fun guardarTurno(turno: turno, context: Context): turno {
        val datos = ContentValues()
        datos.put("idusuario",turno.emailUsuario)
        datos.put("tipoEntrenamiento", turno.tipoEntrenamiento)
        datos.put("entrenador", turno.entrenador)
        datos.put("hora_cita", turno.hora_cita)

        val db = TurnoDatabaseHelper(context).getWrittingDataBase()
        val id = db.insert("turnos", null, datos)
        turno.id=id
        db.close()
        return turno


    }

    private fun getUser(cursor: Cursor): turno? {
        var user = turno(
            cursor.getLong(cursor.getColumnIndexOrThrow("id")),
            cursor.getLong(cursor.getColumnIndexOrThrow("emailUsuario")),
            cursor.getString(cursor.getColumnIndexOrThrow("tipoEntrenamiento")),
            cursor.getString(cursor.getColumnIndexOrThrow("entrenador")),
            cursor.getString(cursor.getColumnIndexOrThrow("dia_cita")),)

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
        val query = "SELECT * FROM turnos WHERE email = ?"
        var args = arrayOf(email.toString())
        val cursor = db.rawQuery(query, args)
        val users = getUsers(cursor)
        cursor.close()
        db.close()
        return users
    }


}







