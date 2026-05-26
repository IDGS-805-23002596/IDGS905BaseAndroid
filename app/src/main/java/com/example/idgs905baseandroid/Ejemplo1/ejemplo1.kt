package com.example.idgs905baseandroid.Ejemplo1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.R
import org.w3c.dom.Text

class ejemplo1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var editNumero1 : EditText
        lateinit var editNumero2 : EditText
        lateinit var btnSumar : Button
        lateinit var txtResultado : TextView

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejemplo1)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editNumero1 = findViewById(R.id.editNumero1)
        editNumero2 = findViewById(R.id.editNumero2)
        btnSumar = findViewById(R.id.btnSumar)
        txtResultado = findViewById(R.id.txtResultado)

        btnSumar.setOnClickListener{
            val num1 = Integer.parseInt(editNumero1.text.toString())
            val num2 = Integer.parseInt(editNumero2.text.toString())
            txtResultado.setText("Resultado: " + sumar(num1, num2))
        }
    }

    fun sumar(numero1 : Int, numero2 : Int ): Int{
        return numero1 + numero2
    }
}