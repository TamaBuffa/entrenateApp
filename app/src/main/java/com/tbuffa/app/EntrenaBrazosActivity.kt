package com.tbuffa.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tbuffa.app.databinding.ActivityEntrenaAbdominalesBinding
import com.tbuffa.app.databinding.ActivityEntrenaBrazosBinding

class EntrenaBrazosActivity : AppCompatActivity() {

    lateinit var binding: ActivityEntrenaBrazosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntrenaBrazosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnElevacionesLaterales.setOnClickListener() {
            val intent = Intent(this, entrena_brazos_elevacioneslaterales::class.java)
            startActivity(intent)



    }



    }
}
