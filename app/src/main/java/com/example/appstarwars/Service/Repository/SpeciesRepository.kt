package com.example.appstarwars.Service.Repository

import com.example.appstarwars.Service.Model.PersonListModel
import com.example.appstarwars.Service.Model.SpeciesListModel
import com.example.appstarwars.Service.Remote.PersonService
import com.example.appstarwars.Service.Remote.RetrofitClientFavorites
import com.example.appstarwars.Service.Remote.RetrofitClientPeoples
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SpeciesRepository {

    private val speciesService = RetrofitClientPeoples.createService(PersonService::class.java)

    suspend fun getSpecies(){

            return withContext(Dispatchers.IO){
                speciesService.speciesService()
            }
    }
}