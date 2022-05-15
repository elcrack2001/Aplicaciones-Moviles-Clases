package com.upc.pe.myalbum

import com.google.gson.annotations.SerializedName

class Album (
    @SerializedName("userId")
    val userId: Int,

    @SerializedName("id")
    val id : Int,

    @SerializedName("title")
    val title: String

)