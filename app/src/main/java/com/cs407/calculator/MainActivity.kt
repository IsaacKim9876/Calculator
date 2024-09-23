package com.cs407.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val num1Field = findViewById<EditText>(R.id.etNum1)
        val num2Field = findViewById<EditText>(R.id.etNum2)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        btnAdd.setOnClickListener {
            performOperation(num1Field, num2Field, "add")
        }

        btnSubtract.setOnClickListener {
            performOperation(num1Field, num2Field, "subtract")
        }

        btnMultiply.setOnClickListener {
            performOperation(num1Field, num2Field, "multiply")
        }

        btnDivide.setOnClickListener {
            performOperation(num1Field, num2Field, "divide")
        }
    }

    private fun performOperation(num1Field: EditText, num2Field: EditText, operation: String) {
        val num1 = num1Field.text.toString().toIntOrNull()
        val num2 = num2Field.text.toString().toIntOrNull()

        if (num1 == null || num2 == null) {
            showToast("Please enter valid numbers")
            return
        }

        val result = when (operation) {
            "add" -> num1 + num2
            "subtract" -> num1 - num2
            "multiply" -> num1 * num2
            "divide" -> {
                if (num2 == 0) {
                    showToast("Cannot divide by zero")
                    return
                } else {
                    num1 / num2
                }
            }
            else -> 0
        }

        // Start ResultActivity to display the result
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
