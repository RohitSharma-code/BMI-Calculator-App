package com.example.bmicalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.llmain)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCalculation: Button = findViewById(R.id.btnCalculate)
        val edtWeight: EditText = findViewById(R.id.edtWeight)
        val edtHeightft: EditText = findViewById(R.id.edtHeightft)
        val edtHeightin: EditText = findViewById(R.id.edtHeightin)
        val txtResult: TextView = findViewById(R.id.txtResult)
        val llmain: LinearLayout = findViewById(R.id.llmain)

        btnCalculation.setOnClickListener{
            val weightString = edtWeight.getText().toString()
            val weightInt = weightString.toInt()

            val HeightftString = edtHeightft.getText().toString()
            val HeightftInt = HeightftString.toInt()

            val HeightinString = edtHeightin.getText().toString()
            val HeightinInt = HeightinString.toInt()

            val totalIn = HeightftInt * 12 + HeightinInt
            val totalcm: Double = totalIn * 2.54
            val totalm: Double = totalcm/100
            val bmi: Double = weightInt/(totalm * totalm)

            val my_green = ContextCompat.getColor(this, R.color.green)
            val my_yellow = ContextCompat.getColor(this, R.color.yellow)
            val my_red = ContextCompat.getColor(this, R.color.red)

            if (bmi > 25){
                txtResult.setText("You're overweight")
                llmain.setBackgroundColor(my_red)
            }
            else if (bmi < 18){
                txtResult.setText("You're underweight")
                llmain.setBackgroundColor(my_yellow)
            }
            else{
                txtResult.setText("You're healthy")
                llmain.setBackgroundColor(my_green)
            }


        }

    }
}