package com.example.idgs905baseandroid

import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.Distancia.Distancia
import com.example.idgs905baseandroid.Ejemplo1.ejemplo1
import com.example.idgs905baseandroid.Ejemplo2.Ejemplo2
import com.example.idgs905baseandroid.ExamenResistencia.ExamenActivity
import com.example.idgs905baseandroid.MultiplicaAxB.AxBActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnEjemplo1=findViewById<Button>(R.id.btn1)
        val btnDistancia = findViewById<Button>(R.id.btnDistancia)
        val btnEjemplo2 = findViewById<Button>(R.id.btn2)
        val btnAxB = findViewById<Button>(R.id.btnAxB)
        val btnExamen = findViewById<Button>(R.id.btnExamen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnDistancia.setOnClickListener{
            navigateUpToDistancia()
        }
        btnEjemplo1.setOnClickListener{ navigateUpToejemplo1() }
        btnEjemplo2.setOnClickListener{ navigateUpToEjemplo2() }
        btnAxB.setOnClickListener{ navigateUpToAxB() }
        btnExamen.setOnClickListener{ navigateUpToExamen() }
    }

    fun navigateUpToejemplo1(){
        val intent = Intent(this,ejemplo1::class.java)
        startActivity(
            intent
        )
    }

    fun navigateUpToDistancia(){
        val intent = Intent(this, Distancia::class.java)
        startActivity(
            intent
        )
    }

    fun navigateUpToEjemplo2(){
        val intent = Intent(this, Ejemplo2::class.java)
        startActivity(
            intent
        )
    }

    fun navigateUpToAxB(){
        val intent = Intent(this, AxBActivity::class.java)
        startActivity(
            intent
        )
    }

    fun navigateUpToExamen(){
        val intent = Intent(this, ExamenActivity::class.java)
        startActivity(
            intent
        )
    }
}