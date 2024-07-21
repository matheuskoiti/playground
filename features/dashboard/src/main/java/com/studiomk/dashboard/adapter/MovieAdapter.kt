package com.studiomk.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.studiomk.dashboard.R
import com.studiomk.network.model.MovieData

class MovieAdapter(private val items: List<MovieData>) :
    RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movie = items[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val titleView: TextView = itemView.findViewById(R.id.listItemText)
        private val overviewView: TextView = itemView.findViewById(R.id.listItemOverview)
        private val releaseDateView: TextView = itemView.findViewById(R.id.listItemReleaseDate)

        fun bind(movie: MovieData) {
            titleView.text = movie.title
            overviewView.text = movie.overview
            releaseDateView.text = "Release date: ${movie.releaseDate}"
        }
    }
}