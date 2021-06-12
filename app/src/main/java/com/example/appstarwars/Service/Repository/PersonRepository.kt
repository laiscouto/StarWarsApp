package com.example.appstarwars.Service.Repository


import com.example.appstarwars.Service.Model.PersonListModel
import com.example.appstarwars.Service.Model.PersonModel
import com.example.appstarwars.Service.Remote.PersonService
import com.example.appstarwars.Service.Remote.RetrofitClientPeoples
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository {

    private val instanceRetrofit = RetrofitClientPeoples.createService(PersonService::class.java)

    fun getPerson(onSuccess:(List<PersonModel>)->Unit, onFailure:()-> Unit){

        val call : Call<PersonListModel> = instanceRetrofit.personService()
        call.enqueue(object : Callback<PersonListModel>{

            override fun onResponse(
                call: Call<PersonListModel>,
                response: Response<PersonListModel>
            ) {
                 val list= response.body()
                list?.results?.let{ onSuccess.invoke(it)

                }
            }
            override fun onFailure(call: Call<PersonListModel>, t: Throwable) {
                onFailure.invoke()
            }

        })
    }
}