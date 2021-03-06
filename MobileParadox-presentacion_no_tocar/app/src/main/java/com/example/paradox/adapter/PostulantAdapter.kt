package com.example.paradox.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.paradox.R
import com.example.paradox.controller.activities.WatchAnnouncementActivity
import com.example.paradox.models.Postul
import com.example.paradox.models.PublishedWork
import java.util.*

class PostulantAdapter(var postulants: List<Postul>, val itemClickListener: WatchAnnouncementActivity): RecyclerView.Adapter<PostulantPrototype>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostulantPrototype {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.list_element_postulant, parent, false)
        return PostulantPrototype(view)
    }

    override fun onBindViewHolder(holder: PostulantPrototype, position: Int) {
        holder.bind(postulants.get(position), itemClickListener)
    }

    override fun getItemCount(): Int {
        return postulants.size
    }
}

class PostulantPrototype(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val cvPostulant = itemView.findViewById<CardView>(R.id.cvPostulant)
    val tvNombrePostulante = itemView.findViewById<TextView>(R.id.tvNombrePostulante)
    val tvApelldioPostulante = itemView.findViewById<TextView>(R.id.tvApellidoPostulante)

    fun bind(postulant: Postul, itemClickListener: OnItemClickListener<Postul>) {
        tvNombrePostulante.text = postulant.firstname
        tvApelldioPostulante.text = postulant.lastname

        cvPostulant.setOnClickListener {
            itemClickListener.OnItemClicked(postulant)
        }
    }
}

