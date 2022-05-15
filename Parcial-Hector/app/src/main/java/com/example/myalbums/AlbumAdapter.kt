package com.example.myalbums

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlbumAdapter(val albums: List<Album>): RecyclerView.Adapter<AlbumPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_album, parent, false)
        return AlbumPrototype(view)
    }

    override fun getItemCount(): Int {
        return albums.size
    }

    override fun onBindViewHolder(prototype: AlbumPrototype, position: Int) {
        prototype.bind(albums[position])
    }

}

class AlbumPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvUserID = itemView.findViewById<TextView>(R.id.tvUserID)
    val tvId = itemView.findViewById<TextView>(R.id.tvID)
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)

    fun bind(album: Album){
        tvUserID.text = album.userId
        tvId.text = album.id
        tvTitle.text = album.title
    }

}