package com.example.idgs905baseandroid.ExamenResistencia

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.idgs905baseandroid.R

class ExamenActivity : AppCompatActivity() {

    private lateinit var txtColor1: TextView
    private lateinit var txtColor2: TextView
    private lateinit var txtColor3: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_examen)

        txtColor1 = findViewById(R.id.txtColor1)
        txtColor2 = findViewById(R.id.txtColor2)
        txtColor3 = findViewById(R.id.txtColor3)
        var valor: Long = 0
        var valor2: Long = 0
        var valor3: Long = 0
        val spn1 = findViewById<Spinner>(R.id.spnColor1)
        val spn2 = findViewById<Spinner>(R.id.spnColor2)
        val spn3 = findViewById<Spinner>(R.id.spnColor3)
        val txtValor1 = findViewById<TextView>(R.id.txtValor1)
        val txtValor2 = findViewById<TextView>(R.id.txtValor2)
        val txtValor3 = findViewById<TextView>(R.id.txtValor3)
        val rgTolerancia = findViewById<RadioGroup>(R.id.rgTolerancia)
        val btnCalcular = findViewById<Button>(R.id.btnCalcularR)
        val btnColor = findViewById<Button>(R.id.btnColor)
        val txtOhm = findViewById<TextView>(R.id.txtOhm)
        val txtMinimo = findViewById<TextView>(R.id.txtMinimo)
        val txtMaximo = findViewById<TextView>(R.id.txtMaximo)
        val listColores = listOf(
            Colores("negro", 0),
            Colores("café", 1),
            Colores("rojo", 2),
            Colores("naranja", 3),
            Colores("amarillo", 4),
            Colores("verde", 5),
            Colores("azul", 6),
            Colores("morado", 7),
            Colores("gris", 8),
            Colores("blanco", 9)
        )
        val listMultiplicador = listOf(
            Colores("negro", 1),
            Colores("café", 10),
            Colores("rojo", 100),
            Colores("naranja", 1000),
            Colores("amarillo", 10000),
            Colores("verde", 100000),
            Colores("azul", 1000000),
            Colores("morado", 10000000),
            Colores("gris", 100000000),
            Colores("blanco", 1000000000)
        )

        val adaptador = ArrayAdapter(this, R.layout.spinner_texto_cerrado, listColores)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        val multiplicador = ArrayAdapter(this, R.layout.spinner_texto_cerrado, listMultiplicador)
        multiplicador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        spn1.adapter = adaptador
        spn2.adapter = adaptador
        spn3.adapter = multiplicador

        spn1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val colorSeleccionado = listColores[position]
                valor = colorSeleccionado.codigo
                colorear(txtColor1, colorSeleccionado.nombre)
                txtValor1.text = valor.toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spn2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val colorSeleccionado = listColores[position]
                valor2 = colorSeleccionado.codigo
                colorear(txtColor2, colorSeleccionado.nombre)
                txtValor2.text = valor2.toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        spn3.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val colorSeleccionado = listMultiplicador[position]
                valor3 = colorSeleccionado.codigo
                colorear(txtColor3, colorSeleccionado.nombre)
                txtValor3.text = valor3.toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        val idSeleccionado = rgTolerancia.checkedRadioButtonId
        var tolerancia = 0.0

        rgTolerancia.setOnCheckedChangeListener { group, checkedId ->
            // checkedId es el ID del RadioButton que el usuario acaba de tocar
            when (checkedId) {
                R.id.rbtnOro -> {
                    tolerancia = 5.0
                    btnColor.backgroundTintList = ContextCompat.getColorStateList(this, R.color.oro)
                }
                R.id.rbtnPlata -> {
                    tolerancia = 10.0
                    btnColor.backgroundTintList = ContextCompat.getColorStateList(this, R.color.plata)
                }
            }
        }

        btnCalcular.setOnClickListener {
            if(tolerancia == 0.0){
                Toast.makeText(this, "Selecciona un valor de tolerancia", Toast.LENGTH_SHORT).show()
            } else {

                val digitosConcatenados = "$valor$valor2".toLong()

                val valorOhm = digitosConcatenados * valor3
                val variacion = valorOhm * (tolerancia / 100.0)
                val valorMaximo = valorOhm + variacion
                val valorMinimo = valorOhm - variacion

                txtOhm.text = "Valor ohm: ${valorOhm}"
                txtMaximo.text = "Valor máximo: ${valorMaximo.toLong()}"
                txtMinimo.text = "Valor mínimo: ${valorMinimo.toLong()}"
            }
        }

    }
    fun colorear(textView: TextView, nombreColor: String) {
        val colorRes = when (nombreColor) {
            "negro" -> R.color.negro
            "café" -> R.color.cafe
            "rojo" -> R.color.rojo
            "naranja" -> R.color.naranja
            "amarillo" -> R.color.amarillo
            "verde" -> R.color.verde
            "azul" -> R.color.azul
            "morado" -> R.color.morado
            "gris" -> R.color.gris
            "blanco" -> R.color.blanco
            else -> R.color.black
        }
        textView.setBackgroundColor(ContextCompat.getColor(this, colorRes))
    }
}

