package com.tbuffa.app.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tbuffa.app.databinding.ActivityEntrenaPiernasBinding

class EntrenaPiernasActivity : AppCompatActivity() {

    lateinit var binding: ActivityEntrenaPiernasBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityEntrenaPiernasBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}