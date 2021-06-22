package com.example.appstarwars.View

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
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
import com.example.appstarwars.Service.Constantes.Constantes.Companion.KEY_PERSON
import com.example.appstarwars.Service.Constantes.Constantes.Companion.SKIN_COLOR
import com.example.appstarwars.Service.Model.PersonModel
import com.example.appstarwars.Service.Repository.PersonRepository
import com.example.appstarwars.View.Adapter.PersonAdapter
import com.example.appstarwars.ViewModel.PersonViewModel
import com.example.appstarwars.ViewModel.PersonViewState
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity() : AppCompatActivity(), View.OnClickListener  {

    private val personRepository = PersonRepository()
    private val viewModel = PersonViewModel(personRepository)
    private val personAdapter = PersonAdapter(::clickCard)

    var page = 1
    var limit = 9

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = personAdapter
        observer()

        viewModel.fetchPerson()
        search()
        handlerColorFav()



    }

    /*fun getPage(){
        val next : Int = (page-1) * limit
        val previous: Int = (page) * limit

        for ( i in next..previous) {

        }

    }*/

    fun handlerSucces(list: List<PersonModel>) {
        personAdapter.updateList(list)

    }

    fun observer() {
        viewModel.observerState().observe(this, Observer {
            when (it) {
                is PersonViewState.Loading -> {
                    Toast.makeText(this, "AGUARDE", Toast.LENGTH_SHORT).show()
                }
                is PersonViewState.Success -> {
                    handlerSucces(it.list)
                }
                is Error -> {
                    Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun search(){
        country_search.setOnQueryTextListener(object: SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                personAdapter.filter.filter(newText)
                return false
            }

        })
    }

    private fun handlerColorFav(){
       /* val favorite = findViewById<ImageView>(R.id.ic_favorit)
        favorite.setColorFilter(Color.WHITE)
        val nFavorit = findViewById<ImageView>(R.id.ic_nao_fav)
        nFavorit.setColorFilter(Color.WHITE)

        favorite.setOnClickListener {
            favorite.setColorFilter(Color.RED)
        }

        nFavorit.setOnClickListener {
            nFavorit.setColorFilter(Color.RED)
        }
       Color search*/
        val search = findViewById<ImageView>(R.id.search_mag_icon)
        search.setColorFilter(Color.WHITE)
        val cancelIcon = findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.WHITE)
        val textView = findViewById<TextView>(R.id.search_src_text)
        textView.setTextColor(Color.WHITE)

    }

    private fun clickCard(list: PersonModel) {
        val intent = Intent(this, InfoActivity::class.java).apply {
            val bundle = Bundle()
            bundle.putSerializable(KEY_PERSON, list)
            putExtras(bundle)
        }

        startActivity(intent)
    }

    override fun onClick(v: View) {
       
    }

}