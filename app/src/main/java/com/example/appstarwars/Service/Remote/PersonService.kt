package com.example.appstarwars.Service.Remote

import com.example.appstarwars.Service.Model.PersonListModel
import retrofit2.Call
import retrofit2.http.GET

interface PersonService {

    @GET("people")
    fun personService() : Call<PersonListModel>

}