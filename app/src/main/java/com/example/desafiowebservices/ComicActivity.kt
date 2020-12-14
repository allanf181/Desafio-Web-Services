package com.example.desafiowebservices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.desafiowebservices.databinding.ActivityComicBinding

class ComicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivBackButton.setOnClickListener{
            finish()
        }
        binding.tvTitle.text = intent.getStringExtra("title")
        binding.tvDesc.text = intent.getStringExtra("desc")
        binding.tvPages.text = intent.getIntExtra("pages",0).toString()
        binding.tvPrice.text = intent.getDoubleExtra("price",0.0).toString()
        binding.tvPub.text = intent.getStringExtra("date")
        Glide.with(binding.root).asBitmap()
            .load(intent.getStringExtra("img_back"))
            .into(binding.ivHqBack)
        Glide.with(binding.root).asBitmap()
            .load(intent.getStringExtra("img_hq"))
            .into(binding.ivHqThumb)
        binding.ivHqThumb.setOnClickListener {
            val i = Intent(this, ImageActivity::class.java)
            i.putExtra("img_hq", intent.getStringExtra("img_hq"))
            this.startActivity(i)
        }
    }
}