package com.example.appstarwars.ViewModel

import com.example.appstarwars.Service.Model.PersonModel

sealed class PersonViewState() {

    object Loading : PersonViewState()
    data class Success(val list: List<PersonModel>): PersonViewState()
    object Error : PersonViewState()

}