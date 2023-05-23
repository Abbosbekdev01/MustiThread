package uz.abbosbek.multithread

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import uz.abbosbek.multithread.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHomeBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val countDownTimer = object :CountDownTimer(2000,500){
            override fun onTick(millisUntilFinished: Long) {
                // todo: bu funksiya keyingi ounaga o'tguncha 4 martta ishlaydi(2000 bu 2 sekuntdan keyin bu funksiyadan chiqadi, 500 har sekuntda shu funksiyani ishiga kiradi degani) bu yerda ham amal bajarsa bo'ladi
                binding.root.setBackgroundColor(Color.YELLOW)
            }

            override fun onFinish() {
                //todo: bu yerda keyingi oynaga o'tish uchun kod yoziladi
                val intent = Intent(this@HomeActivity, MainActivity::class.java)
                startActivity(intent)
            }

        }
        countDownTimer.start()
    }
}