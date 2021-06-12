package com.example.appstarwars.Service.Repository


import com.example.appstarwars.Service.Model.PlanetListModel
import com.example.appstarwars.Service.Model.SpeciesListModel
import com.example.appstarwars.Service.Remote.PersonService
import com.example.appstarwars.Service.Remote.RetrofitClientFavorites

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlanetsRepository {

    private val instanceRetrofit = RetrofitClientFavorites.createService(PersonService::class.java)

    fun getSpecies(){

        val call : Call<PlanetListModel> = instanceRetrofit.planetsService()
        call.enqueue(object : Callback<PlanetListModel> {

            override fun onResponse(
                    call: Call<PlanetListModel>,
                    response: Response<PlanetListModel>
            ) {
                val name = response.body()
                name?.results?.forEach {

                }
            }
            override fun onFailure(call: Call<PlanetListModel>, t: Throwable) {
                println ("------------->$t")
            }

        })
    }
}