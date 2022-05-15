package com.example.myalbums

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btDetail = findViewById<Button>(R.id.btDetail)
        val btList = findViewById<Button>(R.id.btList)

        btDetail.setOnClickListener() {
            val intent = Intent(this, Detail::class.java)
            startActivity(intent)
        }

        btList.setOnClickListener() {
            val intent = Intent(this, List::class.java)
            startActivity(intent)
        }
    }
}