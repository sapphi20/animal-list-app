package com.example.animallist

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class AnimalInfoActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animal_info)
        findViewById<Button>(R.id.back_btn).setOnClickListener {
            finish()
            Toast.makeText(this, "Going back!", Toast.LENGTH_SHORT).show()
        }
    }
}