package com.example.appsem04_01_geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadquestions()
        setupViews()
    }

    private fun loadquestions() {
        questions = ArrayList()
        var question = Question("¿Es Lima capital de Perú?", true)
        questions.add(question)

        questions.add(Question("¿Es Lima capital de Chile?", false))
        questions.add(Question("¿Es Ica capital de Chile?", false))
        questions.add(Question("¿Es La Paz capital de Bolivia?", true))
        questions.add(Question("¿Es Santiago capital de Venezuela?", false))
        questions.add(Question("¿Es Santiago capital de Chile?", true))
        questions.add(Question("¿Es BS AS capital de Bolivia?", false))
        questions.add(Question("¿Es Medellin capital de Venezuela?", false))
        questions.add(Question("¿Es Montevideo capital de Uruguay?", true))
        questions.add(Question("¿Es BS AS capital de Argentina?", true))
    }

    private fun setupViews() {
        val btYes = findViewById<Button>(R.id.btnYes)
        val btNo = findViewById<Button>(R.id.btnNo)
        val btNext = findViewById<Button>(R.id.btnNext)
        val tvQuestiom = findViewById<TextView>(R.id.tvQuestion)

        tvQuestiom.text = questions[position].sentence

        btYes.setOnClickListener {
            if (questions[position].answer == true){
                //Para crear un view de texto por un periodo de tiempo
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                position++
                tvQuestiom.text = questions[position].sentence
            }
            else
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
        }

        btNo.setOnClickListener {
            if (questions[position].answer == false){
                //Para crear un view de texto por un periodo de tiempo
                Toast.makeText(this, "Correcto", Toast.LENGTH_SHORT).show()
                position++
                tvQuestiom.text = questions[position].sentence
            }
            else
                Toast.makeText(this, "Incorrecto", Toast.LENGTH_SHORT).show()
        }

        btNext.setOnClickListener {
            if (position < tvQuestiom.length() )
                position++

            tvQuestiom.text = questions[position].sentence
        }
    }
}