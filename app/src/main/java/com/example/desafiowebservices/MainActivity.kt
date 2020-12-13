package com.example.desafiowebservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.load.HttpException
import com.example.desafiowebservices.databinding.ActivityLoginBinding
import com.example.desafiowebservices.databinding.ActivityMainBinding
import com.example.desafiowebservices.entities.Comic
import com.example.desafiowebservices.network.MarvelApi
import com.example.desafiowebservices.network.retrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rv.adapter = HomeAdapter(listOf(),this)
        CoroutineScope(IO).launch {
            val response = MarvelApi.retrofitService.getComics(17285, 28,0, true).data.results
            withContext(Dispatchers.Main) {
                try {
                    (binding.rv.adapter as HomeAdapter).apply {
                        comics = response
                        notifyDataSetChanged()
                    }
                } catch (e: HttpException) {
                    Toast.makeText(this@MainActivity, "Exception ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}