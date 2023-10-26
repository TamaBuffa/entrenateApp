package com.tbuffa.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.tbuffa.app.databinding.ActivityMainBinding
import com.tbuffa.app.databinding.IngresoActivityBinding
import com.tbuffa.app.databinding.RegistroActivityBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrarse.setOnClickListener{
            regist()
        }

        binding.btnIngresar.setOnClickListener{
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
