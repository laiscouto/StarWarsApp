package com.example.appstarwars.ViewModel

import com.example.appstarwars.Service.Model.PersonModel

sealed class InfoViewState() {

    object Loading : InfoViewState()
    data class Success(val list: List<ListPresentation>): InfoViewState()
    object Error : InfoViewState()

}
data class ListPresentation(
    val nome: String,
    val altura: Int,
    val massa: Int, val genero: String, val planet: String, val nascimento: String,
    val corCabelo: String, val corOlhos: String, val corRoupa: String, val especie: String
)