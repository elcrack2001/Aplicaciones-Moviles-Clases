package com.upc.pe.myalbum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListActivity : AppCompatActivity() {

    lateinit var  albums: List<Album>
    lateinit var albumAdapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        ListAlbum()
    }

    private fun ListAlbum() {
        val rvAlbum = findViewById<RecyclerView>(R.id.rvListAlbum)

        //URL del API
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //"https://jsonplaceholder.typicode.com/albums/"
        val service: AlbumService
        service = retrofit.create(AlbumService::class.java)

        val request = service.AllAbulm("json")

        request.enqueue(object : Callback<List<Album>> {
            override fun onResponse(call: Call<List<Album>>, response: Response<List<Album>>) {
                albums = response.body()!!
                albumAdapter = AlbumAdapter(albums)
                rvAlbum.adapter = albumAdapter
                rvAlbum.layoutManager = LinearLayoutManager(this@ListActivity)
            }

            override fun onFailure(call: Call<List<Album>>, t: Throwable) {
                Toast.makeText(this@ListActivity, "No se pudo conectar, Intente de nuevo porfavor", Toast.LENGTH_LONG).show()
            }
        })
    }
}