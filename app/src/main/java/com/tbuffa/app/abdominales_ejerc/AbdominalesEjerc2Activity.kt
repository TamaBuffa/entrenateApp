package com.tbuffa.app.abdominales_ejerc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.tbuffa.app.R
import com.tbuffa.app.databinding.ActivityAbdominalesEjerc1Binding
import com.tbuffa.app.databinding.ActivityAbdominalesEjerc2Binding
import com.tbuffa.app.databinding.ActivityBrazosEjerc1Binding

class AbdominalesEjerc2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityAbdominalesEjerc2Binding
    private lateinit var countDownTimer: CountDownTimer
    private var isTimerRunning = false
    private var timeRemaining: Long = 20000 // 20 segundos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAbdominalesEjerc2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        updateTimer()

        binding.btnComienzo.setOnClickListener {
            if (isTimerRunning) {
                stopTimer()
            } else {
                startTimer()
            }
        }
    }

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(timeRemaining, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeRemaining = millisUntilFinished
                updateTimer()
            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }

        }
        countDownTimer.start()
        isTimerRunning = true
    }

    private fun stopTimer() {
        countDownTimer.cancel()
        isTimerRunning = false
    }

    private fun updateTimer() {
        val minutes = (timeRemaining / 1000) / 60
        val seconds = (timeRemaining / 1000) % 60
        val timeText = String.format("%02d:%02d", minutes, seconds)
        binding.btntiempo.text = timeText
    }
}
