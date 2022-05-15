package com.example.myalbums

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Detail: AppCompatActivity() {
    lateinit var  albums: List<Album>
    lateinit var albumAdapter: AlbumAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val btConsult = findViewById<Button>(R.id.btConsult)

        btConsult.setOnClickListener(){
            val hintID = findViewById<EditText>(R.id.hintID)
            val hintIDText = Integer.parseInt(hintID.text.toString())

            if(hintIDText >= 1 && hintIDText <= 100 ){
                searchAlbum()

            }
            else {
                Toast.makeText(this,"Solo hay id's entre 1 y 100", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun searchAlbum() {

        val rvAlbum = findViewById<RecyclerView>(R.id.rvAlbum)
        val hintID = findViewById<EditText>(R.id.hintID)
        val hintIDText = Integer.parseInt(hintID.text.toString())
        
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(AlbumService::class.java)

        val request = service.searchAlbum(hintIDText)
        request.enqueue(object  : Callback<List<Album>>{
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                albums = response.body()!!
                albumAdapter = AlbumAdapter(albums)
                rvAlbum.adapter = albumAdapter
                rvAlbum.layoutManager = LinearLayoutManager(this@Detail)
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {

            }

        })

    }
}