package com.tbuffa.app.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tbuffa.app.databinding.ActivityEntrenaAbdominalesBinding
import com.tbuffa.app.databinding.ActivityEntrenaPiernasBinding

class EntrenaAbdominalesActivity : AppCompatActivity() {

    lateinit var binding: ActivityEntrenaAbdominalesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityEntrenaAbdominalesBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}