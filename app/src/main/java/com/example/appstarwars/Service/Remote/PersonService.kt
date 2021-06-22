package com.example.appstarwars.Service.Remote

import com.example.appstarwars.Service.Model.*
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PersonService {

    @GET("people")
    suspend fun personService() : PersonListModel

    @GET("planets")
    suspend fun planetsService() : PlanetListModel

    @GET("species")
    suspend fun speciesService() : SpeciesListModel

}