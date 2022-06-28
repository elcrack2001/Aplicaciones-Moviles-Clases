package com.upc.pe.myalbum

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {
    @GET("album/")
    fun BuscarAlbumById(@Query("id") id: Int): Call<List<Album>>

    @GET("album/")
    fun AllAbulm(@Query("format") format: String): Call<List<Album>>
}