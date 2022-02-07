package com.example.foryou

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.io.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name = "Лиззка"

        try {
            val file = assets.open("compliments.txt")
            val compliments = file.bufferedReader().readLines()

            compliment.text = "И так $name, это всё тебе, с днём рождения!"

            iWantMore.setOnClickListener {
                compliment.text = name + ", " + compliments.random().lowercase()
            }

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }


}