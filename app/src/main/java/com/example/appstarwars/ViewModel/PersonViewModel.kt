package com.example.appstarwars.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appstarwars.Service.Model.PersonModel
import com.example.appstarwars.Service.Repository.PersonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PersonViewModel(
    private val personService: PersonRepository): ViewModel() {

    private val state = MutableLiveData<PersonViewState>()


    fun fetchPerson() {
        viewModelScope.launch (Dispatchers.Main){
            state.postValue(PersonViewState.Loading)
            try {
                val result = personService.getPerson()
                handleSuccess(result.results)
            } catch (e: Exception) {
                handleFailure()
            }
        }
    }
    fun observerState():LiveData<PersonViewState> = state

    private fun handleSuccess(list: List<PersonModel>){
        state.postValue(PersonViewState.Success(list))

    }

    private fun handleFailure(){
        state.postValue(PersonViewState.Error)

    }

}