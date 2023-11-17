package com.tbuffa.app.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class TurnoDatabaseHelper (context: Context) : SQLiteOpenHelper(context, "turnos", null, 5)
{
     override fun onCreate(db: SQLiteDatabase?) {
            val ordenCreacion = "CREATE TABLE turnos " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "emailUsuario TEXT,tipoEntrenamiento TEXT, entrenador TEXT, dia_cita TEXT,hora_cita TEXT)"

            db!!.execSQL(ordenCreacion)
//            Log.d("TurnoDatabaseHelper", "Tabla creada exitosamente.")
        }

        override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
            val ordenborrado="DROP TABLE IF EXISTS turnos"
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


