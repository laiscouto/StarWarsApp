package com.example.appstarwars.Service.Repository


import com.example.appstarwars.Service.Model.PersonListModel
import com.example.appstarwars.Service.Model.PersonModel
import com.example.appstarwars.Service.Remote.PersonService
import com.example.appstarwars.Service.Remote.RetrofitClientPeoples
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository {

    private val personService = RetrofitClientPeoples.createService(PersonService::class.java)

    suspend fun getPerson(): PersonListModel {
        return withContext(Dispatchers.IO){
            personService.personService()
        }
    }
}