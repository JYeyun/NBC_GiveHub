package com.example.nbc_givehub

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailPageActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailpage)

        //포스트 데이터 넘겨 받음
        val postData = intent.getStringExtra("data")
        Log.d("여기는 디테일 페이지 입니다.", postData.toString())

        //포스트 데이터 띄우기
        setContents(postData ?: "데이터가 없습니다.")

        //뒤로가기 버튼
        val btn = findViewById<ImageButton>(R.id.btn_detail_back)
        btn.setOnClickListener {
            finish()
        }
    }

    private fun setContents(data: String) {
        val title = findViewById<TextView>(R.id.tv_detail_title)
        val usetName = findViewById<TextView>(R.id.tv_detail_user)
        val contents = findViewById<TextView>(R.id.tv_detail_contents)
        val postImage = findViewById<ImageView>(R.id.img_detail_post_image)

        val titlePattern = "postTitle=(.*?),".toRegex()
        val titleMatch = titlePattern.find(data)?.groupValues?.get(1)
        title.setText(titleMatch.toString())

        val userPattern = "userName=(.*?),".toRegex()
        val userMatch = userPattern.find(data)?.groupValues?.get(1)
        usetName.setText(userMatch.toString())

        val imagePattern = "postImage=(.*?),".toRegex()
        val imageMatch = imagePattern.find(data)?.groupValues?.get(1)
        val imageResource = resources.getIdentifier(imageMatch, "drawable", packageName)
        postImage.setImageResource(imageResource)

        var contentText = ""
        val startIndex = data.indexOf("postSummary=") + "postSummary".length
        if (startIndex >= "postSummary=".length) {
            contentText = data.substring(startIndex + 1)
        }
        contents.setText(contentText)
    }
}