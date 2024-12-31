package com.example.notatki

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var notatki = mutableListOf("Zakupy: chleb, masło, ser", "Do zrobienia: obiad, umyć podłogi", "weekend: kino, spacer z psem")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val listView: ListView = findViewById(R.id.listView)
        val arrayAdapter: ListAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notatki)
        listView.adapter = arrayAdapter

        val dodajButton: Button = findViewById(R.id.dodaj)
        dodajButton.setOnClickListener {
            val nowyElementEditText: EditText = findViewById(R.id.nowyElement)
            notatki.add(nowyElementEditText.text.toString())
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notatki)
            listView.adapter = arrayAdapter
        }

    }
}