package com.example.myalbums

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface AlbumService {
    @GET("albums/")
    fun searchAlbum(@Query("id") id: Int): Call<List<Album>>
}