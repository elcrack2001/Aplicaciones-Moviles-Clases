package com.upc.pe.myalbum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailActivity : AppCompatActivity() {

    lateinit var  albums: List<Album>
    lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val btnConsultar = findViewById<Button>(R.id.btnConsultar)

        btnConsultar.setOnClickListener {
            val etDetailID = findViewById<EditText>(R.id.etDetailID)
            //Convierte el string a entero
            val etDetailIDText = Integer.parseInt(etDetailID.text.toString())

            if(etDetailIDText >= 1 && etDetailIDText <= 100 ){
                searchAlbumById()

            }
            else {
                Toast.makeText(this,"Solo hay id's entre 1 y 100", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun searchAlbumById() {
        val rvAlbum = findViewById<RecyclerView>(R.id.rvDetailAlbum)
        val etDetailID = findViewById<EditText>(R.id.etDetailID)
        //Convierte el string a entero
        val etDetailIDText = Integer.parseInt(etDetailID.text.toString())

        //URL del API
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //"https://jsonplaceholder.typicode.com/albums/"
        val service = retrofit.create(AlbumService::class.java)

        val request = service.BuscarAlbumById(etDetailIDText)

        request.enqueue(object : Callback<List<Album>>{
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                albums = response.body()!!
                albumAdapter = AlbumAdapter(albums)
                rvAlbum.adapter = albumAdapter
                rvAlbum.layoutManager = LinearLayoutManager(this@DetailActivity)
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

    }
}