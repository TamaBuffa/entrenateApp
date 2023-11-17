package com.tbuffa.app.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tbuffa.app.brazos_ejerc.BrazosEjerc1Activity
import com.tbuffa.app.brazos_ejerc.BrazosEjerc3Activity
import com.tbuffa.app.brazos_ejerc.BrazosEjerc4Activity
import com.tbuffa.app.brazos_ejerc.BrazosEjerc5Activity
import com.tbuffa.app.brazos_ejerc.brazosEjerc2Activity
import com.tbuffa.app.databinding.ActivityEntrenaBrazosBinding

class EntrenaBrazosActivity : AppCompatActivity() {

    lateinit var binding: ActivityEntrenaBrazosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntrenaBrazosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnElevacionesLaterales.setOnClickListener() {
            val intent = Intent(this, BrazosEjerc1Activity::class.java)
            startActivity(intent)
        }

        binding.btnFlexionesDiamante.setOnClickListener() {
            val intent = Intent(this, brazosEjerc2Activity::class.java)
            startActivity(intent)
        }

        binding.btnPlanchaDiagonal.setOnClickListener() {
            val intent = Intent(this, BrazosEjerc3Activity::class.java)
            startActivity(intent)
        }

        binding.btnPunetazos.setOnClickListener() {
            val intent = Intent(this, BrazosEjerc4Activity::class.java)
            startActivity(intent)
        }

        binding.btnPlancaStep.setOnClickListener() {
            val intent = Intent(this, BrazosEjerc5Activity::class.java)
            startActivity(intent)
        }

    }
}