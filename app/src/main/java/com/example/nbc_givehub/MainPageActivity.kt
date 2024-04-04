package com.example.nbc_givehub

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_givehub.MainPageItem.Companion.dummyPostData
import com.example.nbc_givehub.UserData.Companion.showlist

class MainPageActivity : AppCompatActivity() {

    //더미포스트 생성
    var dummyPost = dummyPostData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mainpage)

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
        val itemAdapter = MainPageAdapter(this, dummyPost)
        val itemListView = findViewById<ListView>(R.id.mainListView)
        itemListView.adapter = itemAdapter

        //특정 아이템 클릭 시
        itemListView.setOnItemClickListener{ adapterView, view, i, l ->
            val clickedItem = dummyPost[i]

            //좋아요 1 추가
            dummyPost[i].like++

            //디테일페이지로 데이터 넘기기
            val intent = Intent(this, DetailPageActivity::class.java)
            intent.putExtra("userName", clickedItem.userName)
            intent.putExtra("userImage", clickedItem.userImage)
            intent.putExtra("postImage", clickedItem.postImage)
            intent.putExtra("postTitle", clickedItem.postTitle)
            intent.putExtra("postSummary", clickedItem.postSummary)
            startActivity(intent)
            slideLeft()
        }
    }

    private fun goMyPage() {
        //로그인 페이지에서 현재 로그인한 ID 데이터 받아오기
        val id = intent.getStringExtra("id") ?: "Unknown"
        //마이페이지로 이동
        val intent = Intent(this, MyPageActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
        slideLeft()
    }

    private fun doLogout() {
        //로그아웃 모달 띄움
        val dialog = AlertDialog.Builder(this)
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
                        slideUp()
                    }
                }
            }
        }
        dialog.setPositiveButton(R.string.logoutDo, dialogListener)
        dialog.setNegativeButton(R.string.cancel, null)
        dialog.show()
    }
}

