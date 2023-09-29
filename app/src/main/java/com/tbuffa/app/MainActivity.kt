package com.tbuffa.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnRegist: Button =findViewById(R.id.btnRegistrarse)
        btnRegist.setOnClickListener{
            regist()
        }

        val tvInici: Button =findViewById(R.id.btnIngresar)
        tvInici.setOnClickListener{
            inici()
        }
    }

    private fun regist(){
        val i= Intent(this,RegistroActivity::class.java)
        startActivity(i)
    }

    private fun inici(){
        val i= Intent(this,IngresoActivity::class.java)
        startActivity(i)
    }




}
