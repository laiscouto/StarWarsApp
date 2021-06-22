package com.example.appstarwars.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.appstarwars.R
import com.example.appstarwars.Service.Constantes.Constantes.Companion.KEY_PERSON
import com.example.appstarwars.Service.Constantes.Constantes.Companion.SKIN_COLOR
import com.example.appstarwars.Service.Model.PersonModel
import com.example.appstarwars.Service.Model.PlanetsModel
import com.example.appstarwars.Service.Repository.PlanetsRepository
import com.example.appstarwars.Service.Repository.SpeciesRepository
import com.example.appstarwars.ViewModel.InfoViewModel
import com.example.appstarwars.ViewModel.InfoViewState
import com.example.appstarwars.ViewModel.ListPresentation
import com.example.appstarwars.ViewModel.PersonViewState
import kotlinx.android.synthetic.main.person_deitals.*

class InfoActivity : AppCompatActivity(){
    private val person by lazy { intent.extras?.getSerializable(KEY_PERSON) as PersonModel }
    private val planets = PlanetsRepository()
    private val specie = SpeciesRepository()
    private val infoViewModel = InfoViewModel(planets, specie)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.person_deitals)

        infoViewModel.fetchPlanets(person)
        observer()
        personInfo()

    }

    private fun personInfo(){
        name.text = person.name
        heigth.text = person.height.toString()
        mass.text = person.mass.toString()
        gender.text = person.gender
        hair_color.text = person.hair_color
        eye_color.text = person.eye_color
        skin_color.text = person.skin_color
        birth_year.text = person.birth_year
    }

    fun observer() {
        infoViewModel.observeState().observe(this, Observer {
            when (it) {
                is InfoViewState.Loading -> {
                    Toast.makeText(this, "AGUARDE", Toast.LENGTH_SHORT).show()
                }
                is InfoViewState.Success -> {
                    handlerSucces(it.list)
                }
                is Error -> {
                    Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun handlerSucces(list: List<ListPresentation>) {


    }
}