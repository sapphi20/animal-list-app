package com.example.animallist

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class AnimalInfoActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animal_info)
        val animal = intent.extras?.keySet()?.toList()?.get(0)
        val data = intent.extras?.getStringArray(animal)?.toList()
        if (data != null) {
            for (d in data){
                Log.d("asdf", d)
            }
        }

        val title = findViewById<TextView>(R.id.detail_title)
        val habitat = findViewById<TextView>(R.id.habitat)
        val lifespan = findViewById<TextView>(R.id.lifespan)
        val asdf = findViewById<TextView>(R.id.asdf)
        title.text = animal
        data.let {
            habitat.text = "Habitat: " + it?.get(0)
            lifespan.text = "Lifespan: " + it?.get(1)
            asdf.text = it?.get(2) ?: "asdf"
        }

        findViewById<Button>(R.id.back_btn).setOnClickListener {
            finish()
            Toast.makeText(this, "Going back!", Toast.LENGTH_SHORT).show()
        }
    }
}