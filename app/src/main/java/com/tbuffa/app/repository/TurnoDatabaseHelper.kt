package com.tbuffa.app.repository

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class TurnoDatabaseHelper (context: Context) : SQLiteOpenHelper(context, "turnos", null, 1)
{
     override fun onCreate(db: SQLiteDatabase?) {
            val ordenCreacion = "CREATE TABLE turnos " +
                    "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "emailUsuario TEXT,tipoEntrenamiento TEXT, entrenador TEXT,hora_cita TEXT)"

            db!!.execSQL(ordenCreacion)
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


