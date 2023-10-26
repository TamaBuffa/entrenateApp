package com.tbuffa.app.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import com.tbuffa.app.databinding.ActivityEntrenaBrazosElevacioneslateralesBinding

class TemporizadorActivity : AppCompatActivity() {

    lateinit var binding: ActivityEntrenaBrazosElevacioneslateralesBinding
    private lateinit var countDownTimer: CountDownTimer
    private var isTimerRunning = false
    private var timeRemaining: Long = 30000 // 30 segundos
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEntrenaBrazosElevacioneslateralesBinding.inflate(layoutInflater)
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
                    // El temporizador ha finalizado, aquí puedes realizar acciones adicionales
                    Toast.makeText(this@TemporizadorActivity, "Temporizador finalizado",
                        Toast.LENGTH_SHORT).show()
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

