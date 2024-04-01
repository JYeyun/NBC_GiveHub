package com.example.nbc_givehub

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainPageActivity : AppCompatActivity() {

    val itemList = arrayListOf(
        MainPageItem("give_hub", "작성자1", "mainpage_img_thumnail", "포스트1 제목", "포스트1 내용"),
        MainPageItem("give_hub", "작성자2", "mainpage_img_thumnail", "포스트2 제목", "포스트2 내용"),
        MainPageItem("give_hub", "작성자3", "mainpage_img_thumnail", "포스트3 제목", "포스트3 내용"),
        MainPageItem("give_hub", "작성자4", "mainpage_img_thumnail", "포스트4 제목", "포스트4 내용"),
        MainPageItem("give_hub", "작성자5", "mainpage_img_thumnail", "포스트5 제목", "포스트5 내용")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainpage)

        val itemAdapter = MainPageAdapter(this, itemList)
        val lv = findViewById<ListView>(R.id.mainListView)
        lv.adapter = itemAdapter

    }

}