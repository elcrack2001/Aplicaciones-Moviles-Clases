package com.upc.pe.myalbum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDetail = findViewById<Button>(R.id.btnDetail)
        val btnListado = findViewById<Button>(R.id.btnListadoAlbum)

        btnDetail.setOnClickListener() {
            val intent = Intent(this, DetailActivity::class.java)
            startActivity(intent)
        }

        btnListado.setOnClickListener() {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
    }
}