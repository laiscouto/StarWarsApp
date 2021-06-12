package com.example.appstarwars.ViewModel

import com.example.appstarwars.Service.Model.PersonModel

sealed class ViewState() {

    object Loading : ViewState()
    data class Success(val list: List<PersonModel>): ViewState()
    object Error : ViewState()

}