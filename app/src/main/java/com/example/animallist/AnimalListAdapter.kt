package com.example.animallist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AnimalListAdapter(private val list: HashMap<String, Array<String>>) :
    RecyclerView.Adapter<AnimalListAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.animal_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val names = list.keys.toList()
        holder.textView.text = names[position]
        holder.itemView.setOnClickListener {
            val goDetail = Intent(it.context, AnimalInfoActivity::class.java)
            goDetail.putExtra(names[position], list[names[position]])
            it.context.startActivity(goDetail)
        }
    }
}