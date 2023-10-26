package com.tbuffa.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tbuffa.app.databinding.ActivityEntrenaBinding

class EntrenaActivity : AppCompatActivity() {

   lateinit var binding: ActivityEntrenaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntrenaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivAbdominales.setOnClickListener(){
            val intent = Intent(this, EntrenaAbdominalesActivity::class.java)
            startActivity(intent)
        }

        binding.ivBrazos.setOnClickListener(){
            val intent = Intent(this, EntrenaBrazosActivity::class.java)
            startActivity(intent)
        }

        binding.ivPiernas.setOnClickListener(){
            val intent = Intent(this, EntrenaPiernasActivity::class.java)
            startActivity(intent)
        }





//        binding.btnEjercicioFuerza1.setOnClickListener() {
//            val intent = Intent(this, EntrenaFuerzaEje1Activity::class.java)
//            startActivity(intent)
//        }
//        binding.btnEjercicioFuerza2.setOnClickListener() {
//            val intent = Intent(this, EntrenaFuerzaEje2Activity::class.java)
//            startActivity(intent)
//        }
//        binding.btnEjercicioFuerza3.setOnClickListener() {
//            val intent = Intent(this, EntrenaFuerzaEje3Activity::class.java)
//            startActivity(intent)
//        }
//        binding.btnEjercicioFuerza4.setOnClickListener() {
//            val intent = Intent(this, EntrenaFuerzaEje4Activity::class.java)
//            startActivity(intent)
//        }
//        binding.btnEjercicioFuerza5.setOnClickListener() {
//            val intent = Intent(this, EntrenaFuerzaEje5Activity::class.java)
//            startActivity(intent)
//        }

    }


}