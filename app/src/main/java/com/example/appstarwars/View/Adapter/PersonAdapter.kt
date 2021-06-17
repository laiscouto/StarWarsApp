package com.example.appstarwars.View.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.appstarwars.R
import com.example.appstarwars.Service.Model.PersonModel
import com.example.appstarwars.View.Adapter.ViewHolder.PersonViewHolder
import kotlin.reflect.KFunction2

class PersonAdapter(private val onClickItem: KFunction2<CardView, PersonModel, Unit>) : RecyclerView.Adapter<PersonViewHolder>(){

    private var personlist: List<PersonModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.person_list, parent,false)
        return PersonViewHolder(item, onClickItem)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(personlist[position])
    }

    override fun getItemCount(): Int {
        return personlist.size
    }

    fun updateList(list: List<PersonModel>){
         personlist = list
        notifyDataSetChanged()
    }

}