package com.example.appstarwars.View.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.appstarwars.R
import com.example.appstarwars.Service.Model.PersonModel
import com.example.appstarwars.View.Adapter.ViewHolder.PersonViewHolder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.reflect.KFunction2

class PersonAdapter(private val onClickItem: (PersonModel)-> Unit) : RecyclerView.Adapter<PersonViewHolder>(), Filterable {

    private var personlist: List<PersonModel> = ArrayList()
    private var personlistfilter: List<PersonModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val item = LayoutInflater.from(parent.context).inflate(R.layout.person_list, parent, false)
        return PersonViewHolder(item, onClickItem)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bind(personlist[position])
    }

    override fun getItemCount(): Int {
        return personlist.size
    }

    fun updateList(list: List<PersonModel>) {
        personlist = list
        personlistfilter = list
        notifyDataSetChanged()
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val filter = FilterResults()
                if (constraint == null || constraint.isEmpty()) {
                    filter.count = personlistfilter.size
                    filter.values = personlistfilter

                } else {
                    val search: String = constraint.toString().toLowerCase(Locale.ROOT)
                    val person = ArrayList<PersonModel>()
                    for (itens in personlistfilter) {
                        if (itens.name.toLowerCase(Locale.ROOT).contains(search)) {
                            person.add(itens)
                        }
                    }
                    filter.count = person.size
                    filter.values = person
                }

                return filter

            }
            override fun publishResults(constraint: CharSequence, results: FilterResults?) {
                personlist = results!!.values as ArrayList<PersonModel>
                notifyDataSetChanged()
            }

        }

    }
}
