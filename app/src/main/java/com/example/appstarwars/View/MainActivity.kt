package com.example.appstarwars.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appstarwars.R
import com.example.appstarwars.Service.Model.PersonModel
import com.example.appstarwars.Service.Repository.PersonRepository
import com.example.appstarwars.View.Adapter.PersonAdapter
import com.example.appstarwars.ViewModel.PersonViewModel
import com.example.appstarwars.ViewModel.ViewState
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.person_list.*

class MainActivity : AppCompatActivity() {

    private val personRepository = PersonRepository()
    private val viewModel = PersonViewModel(personRepository)
    private val personAdapter: PersonAdapter = PersonAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = personAdapter

        viewModel.observerState().observe(this, Observer{
            when (it){
                is ViewState.Loading -> {

                }
                 is ViewState.Success -> {
                     handlerSucces(it.list)
                 }
                is Error -> {

                }
            }
        })
        viewModel.fetchPerson()
    }

    private fun handlerSucces(list: List<PersonModel>) {
        personAdapter.updateList(list)

    }


}