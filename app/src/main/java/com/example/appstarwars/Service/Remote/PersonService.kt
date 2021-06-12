package com.example.appstarwars.Service.Remote

import com.example.appstarwars.Service.Model.*
import retrofit2.Call
import retrofit2.http.GET

interface PersonService {

    @GET("people")
    fun personService() : Call<PersonListModel>

    @GET("planets")
    fun planetsService() : Call<PlanetListModel>

    @GET("species")
    fun speciesService() : Call<SpeciesListModel>



}