package uz.abbosbek.multithread

import android.graphics.Color
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.Toast
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.kotlin.toObservable
import uz.abbosbek.multithread.adapters.NewsAdapter
import uz.abbosbek.multithread.database.AppDatabase
import uz.abbosbek.multithread.database.entity.NewsEntity
import uz.abbosbek.multithread.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var appDatabase:AppDatabase
    private lateinit var newsAdapter: NewsAdapter

//    private var handler: Handler? = null
//    var gameOn = false
//    var startTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        appDatabase = AppDatabase.getInstance(this)
        newsAdapter = NewsAdapter()

        appDatabase.newsDao()
            .getAllNews()
                //todo: Database ni ichidan malomot olib chiqish uchun
            .subscribe{
                newsAdapter.submitList(it)
            }

        binding.apply {
            rv.adapter = newsAdapter
            btnSave.setOnClickListener {
                val title = titleEt.text.toString()
                val desc = descEt.text.toString()

                appDatabase.newsDao().addNews(NewsEntity(title = title, description = desc))
                titleEt.text.clear()
                descEt.text.clear()
            }
        }

//        val list = listOf("Alpha", "Gamma", "Beta", "Delta", "Hammasi")
//
//        list.toObservable()
//            .filter { it.length >= 5 }
//            .subscribeBy(
//                onNext = { println(it) },
//                onError = { it.printStackTrace() },
//                onComplete = { println("Done!") }
//            )

//        startTime = System.currentTimeMillis()
//        handler = object : Handler(Looper.getMainLooper()) {
//            override fun handleMessage(msg: Message) {
//                super.handleMessage(msg)
//                if (gameOn) {
//                    val secpnds = (System.currentTimeMillis() - startTime) / 1000
//                    Log.i("info", "second = $secpnds")
//                }
//                handler?.sendEmptyMessageDelayed(0, 1000)
//            }
//        }
//        gameOn = true
//        handler?.sendEmptyMessage(0)
    }


//    var count = 0
//
//    inner class MyTask : AsyncTask<Void, Void, Void>() {
//
//        override fun onPreExecute() {
//            super.onPreExecute()
//            Toast.makeText(this@MainActivity, "Start", Toast.LENGTH_SHORT).show()
//            binding.root.setBackgroundColor(Color.MAGENTA)
//            binding.tvCount.text = count.toString()
//        }
//
//        override fun doInBackground(vararg params: Void?): Void? {
//
//            while (count <= 10) {
//                count++
//                Thread.sleep(1000)
//            }
//            return null
//        }
//
//        override fun onPostExecute(result: Void?) {
//            super.onPostExecute(result)
//            Toast.makeText(this@MainActivity, "End", Toast.LENGTH_SHORT).show()
//            binding.root.setBackgroundColor(Color.YELLOW)
//            binding.tvCount.text = count.toString()
//        }
//    }
//
//
//    override fun onBackPressed() {
//        super.onBackPressed()
//    }
////    private val runnable = object : Runnable {
////        override fun run() {
////            binding.tvCount.text = count.toString()
////            count++
//////            handler.postDelayed(this, 1000)
////
////            if (count == 5) {
////                binding.root.setBackgroundColor(Color.BLUE)
////            } else if (count == 8) {
////                binding.root.setBackgroundColor(Color.CYAN)
////                binding.tvCount.text = "Yoqdimi"
////            } else if (count == 10) {
////                binding.root.setBackgroundColor(Color.GREEN)
////            }
////        }
////
////    }
}