package com.example.idgs905baseandroid.MultiplicaAxB

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.R

class AxBActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ax_bactivity)

        val txtA = findViewById<EditText>(R.id.txtA)
        val txtB = findViewById<EditText>(R.id.txtB)
        val btnCalcularAxB = findViewById<Button>(R.id.btnCalcularAxB)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnCalcularAxB.setOnClickListener {
            val numA = txtA.text.toString().toIntOrNull() ?: 0
            val numB = txtB.text.toString().toIntOrNull() ?: 0
            val textoResultado = calcularSumasRepetidas(numA, numB)
            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("VALOR_RESULTADO", textoResultado)
            startActivity(intent)
        }
    }

    fun calcularSumasRepetidas(a: Int, b: Int): String {
        if (b <= 0 || a == 0) return "0 = 0"

        var sumaAcumulada = 0
        var operacionVisual = ""
        for (i in 1..b) {
            sumaAcumulada += a
            if (i == 1) {
                operacionVisual += a
            } else {
                operacionVisual += "+$a"
            }
        }
        return "$operacionVisual = $sumaAcumulada"
    }
}