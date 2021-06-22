package com.example.appstarwars.View.Adapter.ViewHolder

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.appstarwars.R
import com.example.appstarwars.Service.Model.PersonModel
import kotlin.reflect.KFunction
import kotlin.reflect.KFunction2

class PersonViewHolder(itemView: View, private val onClickItem: (PersonModel)-> Unit) : RecyclerView.ViewHolder(itemView) {

    fun bind (person: PersonModel){
        val cardView = itemView.findViewById<CardView>(R.id.cardPerson)
         itemView.setOnClickListener{
             onClickItem(person)
         }
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