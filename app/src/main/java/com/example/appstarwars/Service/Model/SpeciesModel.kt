package com.example.appstarwars.Service.Model

import com.google.gson.annotations.SerializedName

data class SpeciesModel (
        @SerializedName("name")
        val name: String,
)