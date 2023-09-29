package com.tbuffa.app

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class sqlLite (context: Context) : SQLiteOpenHelper(context, "registrados.db", null, 1)
{

    //Cuando la bbdd no exista, y haya que crearla por primera vez
    //Crear la tabla y ejecutarla

    override fun onCreate(db: SQLiteDatabase?) {
        var ordenCreacion= "CREATE TABLE registrados" +
                            "(_id INTEGER PRIMARY KEY AUTOINCREMENT," + "nombre TEXT, apellido TEXT, email TEXT, password TEXT, repetirPassword TEXT)"

        //Le indicamos que ejecute la orden sql->creacion
        //!!->Yo se que no va a ser null, te permito que ejecutes la creacion
        db!!.execSQL(ordenCreacion)

    }


    //Si detecta que el numero de version actual (oldversion), es > al que se encuentra (newversion), y hay que actualizar
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val ordenborrado="DROP TABLE IF EXISTS registrados"
        db!!.execSQL(ordenborrado)
        onCreate(db)

    }

    fun anadirdato(nombre:String, apellido:String, email:String, password:String, repetirPassword:String)
    {
        var datos=ContentValues()
        datos.put ("nombre", nombre)
        datos.put ("apellido", apellido)
        datos.put ("email", apellido)
        datos.put("password", password)
        datos.put("repetirPassword",repetirPassword)

        var db= this.writableDatabase
        db.insert("registrados",null,datos)
        db.close()
    }
}

