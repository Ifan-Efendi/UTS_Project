package com.id.newsapp

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class NewsAdapter(private var newsList: List<NewsData>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {


    private lateinit var context: Context

    init {
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        context = parent.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val newsData = newsList[holder.adapterPosition]

        holder.headLine.text = newsData.title
        if (newsData.urlToImage.isEmpty()) {
            Picasso.get()
                .load( R.drawable.samplenews)
                .fit()
                .centerCrop()
                .into(holder.image)
        } else {
            Picasso.get()
                .load(newsData.urlToImage)
                .fit()
                .centerCrop()
                .error(R.drawable.samplenews)
                .into(holder.image)
        }

    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    class ViewHolder(
        ItemView: View
    ) : RecyclerView.ViewHolder(ItemView) {
        val image: ImageView = itemView.findViewById(R.id.img)
        val headLine: TextView = itemView.findViewById(R.id.news_title)
    }

}
