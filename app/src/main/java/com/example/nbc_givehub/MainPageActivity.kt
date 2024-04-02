package com.example.nbc_givehub

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainPageActivity : AppCompatActivity() {

    //더미포스트 변수
    val itemList = ArrayList<MainPageItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainpage)

        //로그인 페이지에서 데이터 받아오기
        val id = intent.getStringExtra("id") ?: "Unknown"

        //더미포스트 추가
        val dummyPost = listOf(
            MainPageItem("give_hub", id, "mainpage_img_thumnail", "포스트1 제목", "포스트1 내용"),
            MainPageItem("give_hub", "작성자2", "mainpage_img_thumnail", "포스트2 제목", "포스트2 내용"),
            MainPageItem("give_hub", id, "mainpage_img_thumnail", "포스트3 제목", "포스트3 내용"),
            MainPageItem("give_hub", "작성자4", "mainpage_img_thumnail", "포스트4 제목", "포스트4 내용"),
            MainPageItem("give_hub", "작성자5", "mainpage_img_thumnail", "포스트5 제목", "포스트5 내용")
        )
        itemList.addAll(dummyPost)

        //상호작용 버튼 선언
        val myPageBtn = findViewById<FrameLayout>(R.id.btn_mypage)
        val logoutBtn = findViewById<FrameLayout>(R.id.btn_logout)

        //리스트뷰
        makeListView()

        //마이페이지 이동
        myPageBtn.setOnClickListener {
            goMyPage()
        }

        //로그아웃
        logoutBtn.setOnClickListener {
            doLogout()
        }
    }

    private fun makeListView() {
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
    }

    private fun goMyPage() {
        //마이페이지로 이동
        val intent = Intent(this, MyPageActivity::class.java)
        startActivity(intent)
    }

    private fun doLogout() {
        //로그아웃 모달 띄움
        val dialog = AlertDialog.Builder(this)
        var temp =
        dialog.setTitle(R.string.logoutMessageTitle)
        dialog.setMessage(R.string.logoutMessageContents)
        dialog.setIcon(R.drawable.give_hub)

        fun toastLogout() {
            Toast.makeText(this, R.string.logoutComplete, Toast.LENGTH_SHORT).show()
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
        dialog.setPositiveButton(R.string.logoutDo, dialogListener)
        dialog.setNegativeButton(R.string.cancel, null)
        dialog.show()
    }
}

