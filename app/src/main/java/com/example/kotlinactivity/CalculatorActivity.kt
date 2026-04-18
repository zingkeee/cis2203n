package com.example.kotlinactivity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CalculatorActivity : AppCompatActivity() {

    var currentInput = ""
    var firstOperand = 0.0
    var currentOperator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
    }

    fun addNumbers(a: Double, b: Double): Double {
        return a + b
    }

    fun parseCurrentInput(): Double {
        val number = currentInput.toDoubleOrNull() ?: 0.0
        return number
    }

    fun calculateResult(): Double {
        val secondOperand = parseCurrentInput()
        var result = 0.0

        when (currentOperator) {
            "+" -> result = addNumbers(firstOperand, secondOperand)
            "-" -> result = firstOperand - secondOperand
            "*" -> result = firstOperand * secondOperand
            "/" -> if (secondOperand != 0.0) result = firstOperand / secondOperand
        }

        return result
    }

}