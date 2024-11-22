package com.example.alevtinawebkotlin

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.alevtinawebkotlin.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.util.stream.Collectors
import javax.net.ssl.HttpsURLConnection

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        //binding.ok.setOnClickListener(clickListener)
        /*if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitAllowingStateLoss()
        }*/

    }
   /* var clickListener: View.OnClickListener = object : View.OnClickListener {

    *//*    @RequiresApi(Build.VERSION_CODES.N)
        override fun onClick(v: View?) {
            var urlConnection: HttpsURLConnection? = null
            try {
                val uri = URL(binding.url.text.toString())
                urlConnection = uri.openConnection() as HttpsURLConnection
                urlConnection.requestMethod = "GET" // установка метода получения данных -- GET
                urlConnection.readTimeout = 10000 // установка таймаута -- 10 000 миллисекунд
                val reader =
                    BufferedReader(InputStreamReader(urlConnection.getInputStream())) // читаем  данные в поток
                val result = getLines(reader)
                binding.webview.loadData(result, "text/html; charset=utf-8", "utf-8")
            } catch (e: Exception) {
                Log.e("", "Fail connection", e)
                e.printStackTrace()
            } finally {
                urlConnection?.disconnect()
            }
        }

        @RequiresApi(Build.VERSION_CODES.N)
        private fun getLines(reader: BufferedReader): String {
            return reader.lines().collect(Collectors.joining("\n"))
        }*//*
    }
*/
    fun onClick(view: View) {
        var urlConnection: HttpsURLConnection? = null
        try {
            val uri = URL(binding.url.text.toString())
            urlConnection = uri.openConnection() as HttpsURLConnection
            urlConnection.requestMethod = "GET" // установка метода получения данных -- GET
            urlConnection.readTimeout = 10000 // установка таймаута -- 10 000 миллисекунд
            val reader =
                BufferedReader(InputStreamReader(urlConnection.getInputStream())) // читаем  данные в поток
            val result = getLines(reader)
            binding.webview.loadData(result, "text/html; charset=utf-8", "utf-8")
        } catch (e: Exception) {
            Log.e("", "Fail connection", e)
            e.printStackTrace()
        } finally {
            urlConnection?.disconnect()
        }
    }
    @RequiresApi(Build.VERSION_CODES.N)
    private fun getLines(reader: BufferedReader): String {
        return reader.lines().collect(Collectors.joining("\n"))
    }
}
