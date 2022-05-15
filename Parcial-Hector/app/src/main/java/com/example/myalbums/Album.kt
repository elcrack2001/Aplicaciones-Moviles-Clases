package com.example.myalbums

import com.google.gson.annotations.SerializedName

class Album (
    @SerializedName("userId")
    val userId: String,
    @SerializedName("id")
    val id : String,
    @SerializedName("title")
    val title: String

)