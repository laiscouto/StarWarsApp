package com.example.appstarwars.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appstarwars.Service.Model.PersonListModel
import com.example.appstarwars.Service.Model.PersonModel
import com.example.appstarwars.Service.Repository.PlanetsRepository
import com.example.appstarwars.Service.Repository.SpeciesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InfoViewModel(
    private val planetsService: PlanetsRepository,
    private val species: SpeciesRepository
    ) : ViewModel() {

    private val state = MutableLiveData<InfoViewState>()

    fun fetchPlanets(person:PersonModel){
        /*viewModelScope.launch (Dispatchers.Main){
            state.postValue(InfoViewState.Loading)
            try {
                val result = planetsService.getPlanets()
                handleSuccess(result.planeta)
            } catch (e: Exception) {
                handleFailure()
            }
        }*/
    }

    private fun handleSuccess(list:List<ListPresentation>) {
        state.postValue(InfoViewState.Success(list))
    }

    fun observeState(): LiveData<InfoViewState> = state

}