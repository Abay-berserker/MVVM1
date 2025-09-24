package com.example.mvvmexample.view

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmexample.R
import com.example.mvvmexample.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView: TextView = findViewById(R.id.textView)
        val button: Button = findViewById(R.id.button)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.text.observe(this) { newText ->
            textView.text = newText
        }

        button.setOnClickListener {
            viewModel.updateText("Updated Text")
        }
    }
}
