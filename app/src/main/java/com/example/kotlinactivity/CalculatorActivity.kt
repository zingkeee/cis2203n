package com.example.kotlinactivity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    var currentInput = ""
    var firstOperand = 0.0
    var currentOperator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val tvDisplay = findViewById<TextView>(R.id.tvDisplay)

        val digitButtons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnDot
        )

        for (id in digitButtons) {
            findViewById<Button>(id).setOnClickListener { view ->
                val button = view as Button
                currentInput += button.text.toString()
                tvDisplay.text = currentInput
            }
        }

        val operatorButtons = listOf(
            R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide
        )

        for (id in operatorButtons) {
            findViewById<Button>(id).setOnClickListener { view ->
                val button = view as Button
                firstOperand = currentInput.toDoubleOrNull() ?: 0.0
                currentOperator = button.text.toString()
                currentInput = ""
            }
        }

        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            val result = calculateResult()
            tvDisplay.text = result.toString()
            currentInput = result.toString()
        }

        findViewById<Button>(R.id.btnAC).setOnClickListener {
            currentInput = ""
            firstOperand = 0.0
            currentOperator = ""
            tvDisplay.text = "0"
        }
    }

    fun parseCurrentInput(): Double {
        return currentInput.toDoubleOrNull() ?: 0.0
    }

    fun addNumbers(a: Double, b: Double): Double {
        return a + b
    }

    fun calculateResult(): Double {
        val secondOperand = parseCurrentInput()
        var result = 0.0

        when (currentOperator) {
            "+" -> result = addNumbers(firstOperand, secondOperand)
            "−" -> result = firstOperand - secondOperand // matching your xml symbol
            "×" -> result = firstOperand * secondOperand // matching your xml symbol
            "÷" -> if (secondOperand != 0.0) result = firstOperand / secondOperand // matching your xml symbol
        }

        return result
    }
}