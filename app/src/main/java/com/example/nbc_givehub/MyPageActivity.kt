package com.example.nbc_givehub

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)
        val img = findViewById<ImageView>(R.id.mypage_profile_img)
        val mp_name = findViewById<TextView>(R.id.mypage_name)
        val mp_language = findViewById<TextView>(R.id.mypage_language)
        val mp_mbti = findViewById<TextView>(R.id.mypage_mbti)
        val mp_git = findViewById<TextView>(R.id.mypage_git)
        val mp_blog = findViewById<TextView>(R.id.mypage_blog)
        val mp_btn = findViewById<ImageButton>(R.id.mypage_arrow)

        mp_btn.setOnClickListener { finish() }
    }
}