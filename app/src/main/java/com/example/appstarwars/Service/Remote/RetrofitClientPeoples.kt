package com.example.appstarwars.Service.Remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientPeoples private constructor(){

    companion object {

        private lateinit var retrofit : Retrofit
        private val baseUrl ="https://swapi.dev/api/"


        private fun getRetrofitInstance(): Retrofit{

            val httpClient = OkHttpClient.Builder()
            if (!Companion::retrofit.isInitialized){
                retrofit = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(httpClient.addInterceptor(HttpLoggingInterceptor().apply{
                        level = HttpLoggingInterceptor.Level.BODY
                    }).build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

        fun <s>createService(serviceClass:Class <s>):s{
            return getRetrofitInstance().create(serviceClass)
        }


    }
}