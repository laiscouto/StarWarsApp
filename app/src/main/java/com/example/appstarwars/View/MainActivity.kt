package com.example.appstarwars.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appstarwars.R
import com.example.appstarwars.Service.Constantes.Constantes.Companion.BIRTHEY_COLOR
import com.example.appstarwars.Service.Constantes.Constantes.Companion.EYE_COLOR
import com.example.appstarwars.Service.Constantes.Constantes.Companion.HAIR_COLOR
import com.example.appstarwars.Service.Constantes.Constantes.Companion.KEY_GENDER
import com.example.appstarwars.Service.Constantes.Constantes.Companion.KEY_HEIGHT
import com.example.appstarwars.Service.Constantes.Constantes.Companion.KEY_MASS
import com.example.appstarwars.Service.Constantes.Constantes.Companion.KEY_NAME
import com.example.appstarwars.Service.Constantes.Constantes.Companion.SKIN_COLOR
import com.example.appstarwars.Service.Model.PersonModel
import com.example.appstarwars.Service.Repository.PersonRepository
import com.example.appstarwars.View.Adapter.PersonAdapter
import com.example.appstarwars.ViewModel.PersonViewModel
import com.example.appstarwars.ViewModel.ViewState
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity() {

    private val personRepository = PersonRepository()
    private val viewModel = PersonViewModel(personRepository)
    private val personAdapter: PersonAdapter = PersonAdapter(::clickCard)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = personAdapter
        observer()

        viewModel.fetchPerson()
    }

    fun clickCard(onClickItem: CardView, list: PersonModel) {
        val intent = Intent(this, InfoActivity::class.java).apply {
            val bundle = Bundle()
            bundle.putString(KEY_NAME, list.name)
            bundle.putString(KEY_HEIGHT, list.height.toString())
            bundle.putString(KEY_MASS, list.mass.toString())
            bundle.putString(KEY_GENDER, list.gender)
            bundle.putString(HAIR_COLOR, list.hair_color)
            bundle.putString(SKIN_COLOR , list.skin_color)
            bundle.putString(EYE_COLOR, list.skin_color)
            bundle.putString(BIRTHEY_COLOR, list.birth_year)

            putExtras(bundle)}

        startActivity(intent)
    }

    fun handlerSucces(list: List<PersonModel>) {
        personAdapter.updateList(list)

    }

    fun observer() {
        viewModel.observerState().observe(this, Observer {
            when (it) {
                is ViewState.Loading -> {

                }
                is ViewState.Success -> {
                    handlerSucces(it.list)
                }
                is Error -> {

                }
            }
        })
    }

}