package com.example.appstarwars.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appstarwars.R
import com.example.appstarwars.Service.Repository.PersonRepository

class MainActivity : AppCompatActivity() {
    private val personRepository = PersonRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personRepository.getPerson()
    }
}