package com.tbuffa.app.views

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




    }


}