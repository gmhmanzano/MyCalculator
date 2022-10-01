package com.example.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val operador1:EditText = findViewById(R.id.editOperador1)
        val operador2:EditText = findViewById(R.id.editOperador2)
        val operadores:Spinner = findViewById(R.id.spOperador)
        val calcular:Button = findViewById(R.id.btnAceptar)
        val resultado:TextView = findViewById(R.id.txtResultado)
        val limpiar:Button = findViewById(R.id.btnClear)

        //Llenado del spinner//
        val adapter = ArrayAdapter.createFromResource(this,R.array.listaOPeradores,
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item)
        operadores.adapter = adapter

        calcular.setOnClickListener {
            when(operadores.selectedItem){
                "Sumar" -> resultado.text = operador1.text.toString().toDouble().plus(operador2.text.toString().toDouble()).toString()
                "Restar" -> resultado.text = operador1.text.toString().toDouble().minus(operador2.text.toString().toDouble()).toString()
                "Multiplicar" -> resultado.text = operador1.text.toString().toDouble().times(operador2.text.toString().toDouble()).toString()
                "Dividir" -> resultado.text = operador1.text.toString().toDouble().div(operador2.text.toString().toDouble()).toString()
            }
                }
        limpiar.setOnClickListener {
            operador1.text.clear()
            operador2.text.clear()
            resultado.text = ""
        }
    }
}