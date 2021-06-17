package com.example.appstarwars.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appstarwars.Service.Model.PersonModel
import com.example.appstarwars.Service.Remote.PersonService
import com.example.appstarwars.Service.Repository.PersonRepository

class PersonViewModel(private val personService: PersonRepository): ViewModel() {

    private val state = MutableLiveData<ViewState>()


    fun fetchPerson(){
        state.postValue(ViewState.Loading)
        personService.getPerson(::handleSuccess, ::handleFailure)
    }

    fun observerState():LiveData<ViewState> = state

    private fun handleSuccess(list: List<PersonModel>){
        state.postValue(ViewState.Success(list))

    }

    private fun handleFailure(){
        state.postValue(ViewState.Error)

    }

}