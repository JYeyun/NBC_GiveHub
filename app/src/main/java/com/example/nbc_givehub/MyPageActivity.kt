package com.example.nbc_givehub

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_givehub.UserData.Companion.dummydata

class MyPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage)
        var img = findViewById<ImageView>(R.id.mypage_profile_img)
        var mp_name = findViewById<TextView>(R.id.mypage_name)
        var mp_language = findViewById<TextView>(R.id.mypage_language)
        var mp_mbti = findViewById<TextView>(R.id.mypage_mbti)
        var mp_git = findViewById<TextView>(R.id.mypage_git)
        var mp_blog = findViewById<TextView>(R.id.mypage_blog)
        var mp_btn = findViewById<ImageButton>(R.id.mypage_arrow)

        val dummy = dummydata()
        mp_name.setText(dummy[0].name)
        mp_language.setText(dummy[0].launguage)
        mp_mbti.setText(dummy[0].mbti)
        mp_git.setText(dummy[0].git)
        mp_blog.setText(dummy[0].blog)

        mp_btn.setOnClickListener { finish() }
    }
}