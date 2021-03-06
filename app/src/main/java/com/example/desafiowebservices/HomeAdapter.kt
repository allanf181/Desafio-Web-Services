package com.example.desafiowebservices

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.example.desafiowebservices.entities.Comic

class HomeAdapter(var comics : List<Comic>, private val context: Context) : Adapter<HomeAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(comic: Comic) {
            val number = itemView.findViewById<TextView>(R.id.tv_hd_n)
            val image = itemView.findViewById<ImageView>(R.id.iv_hq)
            number.text = comic.getFormattedIssueNumber()
            Glide.with(itemView).asBitmap()
                    .load(comic.thumbnail.getFullUrl())
                    .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_hq, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comic = comics[position]
        holder.bindView(comic)
        holder.itemView.setOnClickListener {
            val i = Intent(context, ComicActivity::class.java)
            i.putExtra("title", comic.title)
            i.putExtra("img_back", comic.images[0].getFullUrl())
            i.putExtra("img_hq", comic.thumbnail.getFullUrl())
            i.putExtra("desc", comic.description)
            i.putExtra("price", comic.prices[0].price)
            i.putExtra("pages", comic.pageCount)
            i.putExtra("date", comic.dates[0].getFormattedDate())
            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return comics.size
    }
}