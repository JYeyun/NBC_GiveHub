package com.example.nbc_givehub

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.Adapter
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

        //화면에 리스트뷰 그려주기
        val itemAdapter = MainPageAdapter(this, itemList)
        val itemListView = findViewById<ListView>(R.id.mainListView)
        itemListView.adapter = itemAdapter

        //특정 아이템 클릭 시
        itemListView.setOnItemClickListener{ adapterView, view, i, l ->
            val clickedItem = itemList[i]
            val intent = Intent(this, DetailPageActivity::class.java)
            intent.putExtra("data", clickedItem.toString())
            startActivity(intent)
        }

        //마이페이지 클릭 시
        val myPageBtn = findViewById<FrameLayout>(R.id.btn_mypage)
        myPageBtn.setOnClickListener {
            val intent = Intent(this, MyPageActivity::class.java)
            startActivity(intent)
        }

        //로그아웃 클릭 시
        val logoutBtn = findViewById<FrameLayout>(R.id.btn_logout)
        logoutBtn.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("로그아웃 하시겠습니까?")
            dialog.setMessage("다음에 또 멋진 기술 공유로 만나요!")
            dialog.setIcon(R.drawable.give_hub)

            fun toastLogout() {
                Toast.makeText(this, "로그아웃 되었습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }

            val dialogListener = object : DialogInterface.OnClickListener {
                override fun onClick(dialog: DialogInterface?, which: Int) {
                    when (which) {
                        DialogInterface.BUTTON_POSITIVE -> {
                            toastLogout()
                            finish()
                        }
                    }
                }
            }
            dialog.setPositiveButton("로그아웃", dialogListener)
            dialog.setNegativeButton("취소", null)
            dialog.show()
        }
    }
}

