package com.example.desafiowebservices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.desafiowebservices.databinding.ActivityComicBinding
import com.example.desafiowebservices.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivCloseButton.setOnClickListener {
            finish()
        }
        Glide.with(binding.root).asBitmap()
            .load(intent.getStringExtra("img_hq"))
            .into(binding.ivHqExpanded)
    }
}