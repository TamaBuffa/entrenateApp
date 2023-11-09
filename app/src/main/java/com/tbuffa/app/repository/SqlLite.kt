package com.tbuffa.app.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DbHelper (context: Context) : SQLiteOpenHelper(context, "registrados", null, 1)
{

    //Cuando la bbdd no exista, y haya que crearla por primera vez+
    //Crear la tabla y ejecutarla

    override fun onCreate(db:SQLiteDatabase?) {
        val ordenCreacion = "CREATE TABLE registrados " +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT, apellido TEXT,email TEXT, password TEXT,imagen BLOB)"

        db!!.execSQL(ordenCreacion)
    }
//
//            val ordenCreacion = "CREATE TABLE registrados " +
//                    "(id LONG PRIMARY KEY AUTOINCREMENT," +
//                    "nombre TEXT,apellido TEXT,email TEXT,password TEXT)"
            //Le indicamos que ejecute la orden sql->creacion
            //!!-no va a ser null, ejecuta la creacion ,reppass TEXT,photoPath TEXT


    //Si detecta que el numero de version actual (oldversion), es > al que se encuentra (newversion), y hay que actualizar
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenborrado="DROP TABLE IF EXISTS registrados"
        db!!.execSQL(ordenborrado)
        onCreate(db)
    }

    fun getWrittingDataBase(): SQLiteDatabase {
        return this.writableDatabase;
    }

    fun getReadableDataBase(): SQLiteDatabase {
        return this.readableDatabase;
    }

}

