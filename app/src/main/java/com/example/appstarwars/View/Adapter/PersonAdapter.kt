package com.example.appstarwars.View.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appstarwars.R
import com.example.appstarwars.Service.Model.PersonModel
import com.example.appstarwars.View.Adapter.ViewHolder.PersonViewHolder

class PersonAdapter : RecyclerView.Adapter<PersonViewHolder>() {

    private var personlist: List<PersonModel> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.person_list, parent,false)
        return PersonViewHolder(item)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(personlist[position])
    }

    override fun getItemCount(): Int {
        return personlist.count()
    }

    fun updateList(list: List<PersonModel>){
         personlist = list
        notifyDataSetChanged()
    }

}