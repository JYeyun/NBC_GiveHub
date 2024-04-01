package com.example.nbc_givehub

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DetailPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailpage)
        val btn: Button = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            finish()
        }
    }
}