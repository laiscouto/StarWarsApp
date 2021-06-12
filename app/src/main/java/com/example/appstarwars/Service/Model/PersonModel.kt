package com.example.appstarwars.Service.Model

import com.google.gson.annotations.SerializedName

data class PersonModel (
    @SerializedName("name")
    val name: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("mass")
    val mass : Int,
    @SerializedName("gender")
    val gender: String,
)