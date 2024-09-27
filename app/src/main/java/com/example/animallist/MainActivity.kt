package com.example.animallist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val animals: HashMap<String, Array<String>> = HashMap()
        animals["Lion"] = arrayOf("Savannah", "16", "")
        animals["Tiger"] = arrayOf("Rain forest", "15", "")
        animals["Horse"] = arrayOf("Prairie", "16", "")
        animals["Shark"] = arrayOf("Sea", "30", "")
        animals["Human"] = arrayOf("City", "70", "")

        val animalAdapter = AnimalListAdapter(animals)
        val recycler: RecyclerView = findViewById(R.id.item_list)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = animalAdapter
    }
}