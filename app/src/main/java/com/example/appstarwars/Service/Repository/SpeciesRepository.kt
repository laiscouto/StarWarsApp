package com.example.appstarwars.Service.Repository

import com.example.appstarwars.Service.Model.PersonListModel
import com.example.appstarwars.Service.Model.SpeciesListModel
import com.example.appstarwars.Service.Remote.PersonService
import com.example.appstarwars.Service.Remote.RetrofitClientFavorites
import com.example.appstarwars.Service.Remote.RetrofitClientPeoples
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpeciesRepository {

    private val instanceRetrofit = RetrofitClientFavorites.createService(PersonService::class.java)

    fun getSpecies(){

        val call : Call<SpeciesListModel> = instanceRetrofit.speciesService()
        call.enqueue(object : Callback<SpeciesListModel> {

            override fun onResponse(
                    call: Call<SpeciesListModel>,
                    response: Response<SpeciesListModel>
            ) {
                val name = response.body()
                name?.results?.forEach {

                }
            }
            override fun onFailure(call: Call<SpeciesListModel>, t: Throwable) {
                println ("------------->$t")
            }

        })
    }
}