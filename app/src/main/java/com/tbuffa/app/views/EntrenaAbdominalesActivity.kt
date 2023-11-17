package com.tbuffa.app.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tbuffa.app.abdominales_ejerc.AbdominalesEjerc1Activity
import com.tbuffa.app.abdominales_ejerc.AbdominalesEjerc2Activity
import com.tbuffa.app.abdominales_ejerc.AbdominalesEjerc3Activity
import com.tbuffa.app.abdominales_ejerc.AbdominalesEjerc4Activity
import com.tbuffa.app.abdominales_ejerc.AbdominalesEjerc5Activity
import com.tbuffa.app.databinding.ActivityEntrenaAbdominalesBinding


class EntrenaAbdominalesActivity : AppCompatActivity() {

    lateinit var binding: ActivityEntrenaAbdominalesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityEntrenaAbdominalesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSaltoTijera.setOnClickListener(){
            val intent = Intent(this, AbdominalesEjerc1Activity::class.java)
            startActivity(intent)
        }

        binding.btnEscaladaMontana.setOnClickListener(){
            val intent = Intent(this, AbdominalesEjerc2Activity::class.java)
            startActivity(intent)
        }

        binding.btnCrunchAbdominales.setOnClickListener(){
            val intent = Intent(this, AbdominalesEjerc3Activity::class.java)
            startActivity(intent)
        }

        binding.btnElevacionPiernas.setOnClickListener(){
            val intent = Intent(this, AbdominalesEjerc4Activity::class.java)
            startActivity(intent)
        }
        binding.btnBicicletaAbdominales.setOnClickListener(){
            val intent = Intent(this, AbdominalesEjerc5Activity::class.java)
            startActivity(intent)
        }

    }
}