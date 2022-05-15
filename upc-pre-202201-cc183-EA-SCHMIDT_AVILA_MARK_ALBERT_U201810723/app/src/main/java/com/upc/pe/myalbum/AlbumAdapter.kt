package com.upc.pe.myalbum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AlbumAdapter (val albums: List<Album>): RecyclerView.Adapter<AlbumPrototype>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.prototype_album, parent, false)
        return AlbumPrototype(view)
    }

    override fun onBindViewHolder(holder: AlbumPrototype, position: Int) {
        holder.bind(albums[position])
    }

    override fun getItemCount(): Int {
        return albums.size
    }
}

class AlbumPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tvUserID = itemView.findViewById<TextView>(R.id.tvUserId)
    val tvId = itemView.findViewById<TextView>(R.id.tvId)
    val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)

    fun bind(album: Album){
        tvUserID.text = album.userId.toString() //transformamos a texto
        tvId.text = album.id.toString() //transformamos a texto
        tvTitle.text = album.title
    }
}
