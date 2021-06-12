package com.example.appstarwars.View.Adapter.ViewHolder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appstarwars.R
import com.example.appstarwars.Service.Model.PersonModel

class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind (person: PersonModel){
        val textname = itemView.findViewById<TextView>(R.id.name)
        textname.text = person.name
        val height = itemView.findViewById<TextView>(R.id.heigth)
        height.text = person.height.toString()
        val mass = itemView.findViewById<TextView>(R.id.mass)
        mass.text = person.mass.toString()
        val gender = itemView.findViewById<TextView>(R.id.gender)
        gender.text = person.gender
    }
}