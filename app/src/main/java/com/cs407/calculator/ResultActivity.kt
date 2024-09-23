package com.cs407.calculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntExtra("result", 0)
        val resultTextView = findViewById<TextView>(R.id.tvResult)
        resultTextView.text = "Result: $result"
    }
}
