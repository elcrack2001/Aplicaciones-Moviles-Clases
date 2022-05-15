package com.upc.pe.myalbum

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {
    @GET("albums/")
    fun BuscarAlbumById(@Query("id") id: Int): Call<List<Album>>

    @GET("albums/")
    fun AllAbulm(@Query("format") format: String): Call<List<Album>>
}