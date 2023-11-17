//import android.os.CountDownTimer
//
//class Temporizador(
//    private val onTick: (Long) -> Unit,
//    private val onFinish: () -> Unit
//) {
//    private var countDownTimer: CountDownTimer? = null
//    private var isTimerRunning = false
//
//    fun startTimer(duration: Long) {
//        countDownTimer?.cancel() // Cancel existing timer if running
//
//        countDownTimer = object : CountDownTimer(duration, 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//                onTick(millisUntilFinished)
//            }
//
//            override fun onFinish() {
//                onFinish()
//                isTimerRunning = false
//            }
//        }
//        countDownTimer?.start()
//        isTimerRunning = true
//    }
//
//    fun stopTimer() {
//        countDownTimer?.cancel()
//        isTimerRunning = false
//    }
//
//    fun isTimerRunning(): Boolean {
//        return isTimerRunning
//    }
//}
//
//

















//
//class Temporizador(private val onTick: (Long) -> Unit) {
//    private lateinit var temporizador: CountDownTimer
//    var isTimerRunning = false
//
//    fun startTimer(duration: Long) {
//        Log.d("Temporizador", "Iniciando temporizador con duración: $duration")
//        temporizador = object : CountDownTimer(duration, 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//                Log.d("Temporizador", "Tiempo restante: $millisUntilFinished")
//                onTick(millisUntilFinished)
//            }
//
//            override fun onFinish() {
//                Log.d("Temporizador", "Temporizador finalizado")
//                isTimerRunning = false
//            }
//        }
//        temporizador.start()
//        isTimerRunning = true
//    }
//
//    fun stopTimer() {
//        if (isTimerRunning) {
//            temporizador.cancel()
//            isTimerRunning = false
//        }
//    }
//}




















//
//class Temporizador(private val onTick: (Long) -> Unit) {
//    private lateinit var temporizador: CountDownTimer
//    var isTimerRunning = false
//
//    fun startTimer(duration: Long) {
//        Log.d("Temporizador", "Iniciando temporizador con duración: $duration")
//        temporizador = object : CountDownTimer(duration, 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//                onTick(millisUntilFinished)
//            }
//
//            override fun onFinish() {
//                isTimerRunning = false
//            }
//        }
//        temporizador.start()
//        isTimerRunning = true
//    }
//
//    fun stopTimer() {
//        if (isTimerRunning) {
//            temporizador.cancel()
//            isTimerRunning = false
//        }
//    }
//}

