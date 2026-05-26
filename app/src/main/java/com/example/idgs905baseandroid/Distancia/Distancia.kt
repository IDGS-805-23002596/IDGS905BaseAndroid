package com.example.idgs905baseandroid.Distancia

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.R

class Distancia : AppCompatActivity() {
    lateinit var txtX1 : EditText
    lateinit var txtY1 : EditText
    lateinit var txtX2 : EditText
    lateinit var txtY2 : EditText
    lateinit var btnCalcular : Button
    lateinit var txtResultadoD : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_distancia)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        txtX1 = findViewById(R.id.txtX1)
        txtY1 = findViewById(R.id.txtY1)
        txtX2 = findViewById(R.id.txtX2)
        txtY2 = findViewById(R.id.txtY2)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultadoD = findViewById(R.id.txtResultadoD)

        btnCalcular.setOnClickListener{
            val x1 = Integer.parseInt(txtX1.text.toString())
            val x2 = Integer.parseInt(txtX2.text.toString())
            val y1 = Integer.parseInt(txtY1.text.toString())
            val y2 = Integer.parseInt(txtY2.text.toString())
            val res = distancia(x1, x2, y1, y2)
            txtResultadoD.setText("Resultado " + res)
        }
    }

    fun distancia(x1: Int, x2: Int, y1: Int, y2: Int): Double{
        val restaX = (x2 - x1).toDouble()
        val restaY = (y2 - y1).toDouble()

        // Elevamos al cuadrado, sumamos y aplicamos raíz cuadrada
        return Math.sqrt(Math.pow(restaX, 2.0) + Math.pow(restaY, 2.0))
    }
}