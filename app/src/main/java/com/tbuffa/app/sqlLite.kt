package com.tbuffa.app

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class sqlLite (context: Context) : SQLiteOpenHelper(context, "registrados.db", null, 1)
{

    //Cuando la bbdd no exista, y haya que crearla por primera vez
    //Crear la tabla y ejecutarla

    override fun onCreate(db: SQLiteDatabase?) {
            val ordenCreacion = "CREATE TABLE registrados " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "nombre TEXT, apellido TEXT, email TEXT,password TEXT, repetirPassword TEXT  )"
            //Le indicamos que ejecute la orden sql->creacion
            //!!-no va a ser null, ejecuta la creacion
            db!!.execSQL(ordenCreacion)
        }

    //Si detecta que el numero de version actual (oldversion), es > al que se encuentra (newversion), y hay que actualizar
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenborrado="DROP TABLE IF EXISTS registrados"
        db!!.execSQL(ordenborrado)
        onCreate(db)
    }

    fun anadirdato(detalleUsuarios: detalleUsuarios){

        val datos=ContentValues()
        datos.put ("nombre",detalleUsuarios.nombre )
        datos.put ("apellido", detalleUsuarios.apellido)
        datos.put ("email", detalleUsuarios.email)
        datos.put("password", detalleUsuarios.password)
        datos.put("repetirPassword",detalleUsuarios.reppass)

        val db= this.writableDatabase
        db.insert("registrados", null, datos)
        db.close()
    }

    fun consultarPorEmail(email: String): String? {
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT nombre FROM registrados WHERE email = ?", arrayOf(email))

        var nombre: String? = null

        if (cursor.moveToFirst()) {
            nombre = cursor.getString(1) // El índice 1 corresponde a la columna "nombre"
        }

        cursor.close()
        db.close()

        return nombre
    }

}














//
//    fun consultarEmail(email: String?): Cursor? {
//
//        // Abre la base de datos en modo lectura
//        val db = this.readableDatabase
//
//        val selection = "email = ?"
//        val selectionArgs = arrayOf(email)
//
//        // Realiza la consulta
//        return db.query(
//            "registrados",
//            null, // Consulta todas las columnas
//            selection, // WHERE "email" = ?
//            selectionArgs, // Valores para el WHERE
//            null,
//            null,
//            null
//        )
//    }
//}




















//
//    fun obtenerDatosUsuarioPorEmail(email: String): Cursor? {
//        val db = this.readableDatabase
//        val cursor = db.query(
//            "registrados",
//            arrayOf("nombre", "apellido", "email", "password"),
//            "email = ?",
//            arrayOf(email),
//            null,
//            null,
//            null
//        )
//
//        return cursor
//    }
//







