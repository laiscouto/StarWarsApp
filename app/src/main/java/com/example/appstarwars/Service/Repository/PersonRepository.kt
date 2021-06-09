package com.example.appstarwars.Service.Repository


import com.example.appstarwars.Service.Model.PersonListModel
import com.example.appstarwars.Service.Remote.PersonService
import com.example.appstarwars.Service.Remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository {

    private val instanceRetrofit = RetrofitClient.createService(PersonService::class.java)

    fun getPerson(){

        val call : Call<PersonListModel> = instanceRetrofit.personService()
        call.enqueue(object : Callback<PersonListModel>{

            override fun onResponse(
                call: Call<PersonListModel>,
                response: Response<PersonListModel>
            ) {
                 val name = response.body()
                name?.results?.forEach {
                    println ("-------->"+it.name)
                    println ("--------->"+it.mass)

                }
            }

            override fun onFailure(call: Call<PersonListModel>, t: Throwable) {
                println ("------------->$t")
            }

        })
    }
}