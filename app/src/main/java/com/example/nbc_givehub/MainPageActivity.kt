package com.example.nbc_givehub

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_givehub.MainPageItem.Companion.dummyPostData

class MainPageActivity : AppCompatActivity() {
    //더미포스트 생성
    var dummyPost = dummyPostData()

    //피드 변경 관련 변수 선언
    private var isHome = false
    private var isPopular = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mainpage)
        isHome = true

        //상호작용 버튼 선언
        val mainBtn = findViewById<FrameLayout>(R.id.btn_main)
        val popularBtn = findViewById<LinearLayout>(R.id.btn_popular)
        val myPageBtn = findViewById<FrameLayout>(R.id.btn_mypage)
        val logoutBtn = findViewById<FrameLayout>(R.id.btn_logout)

        //피드 상태 UI 변경
        var mainText = findViewById<TextView>(R.id.tv_main)
        var popularText = findViewById<TextView>(R.id.tv_popular)
        mainText.paintFlags = Paint.UNDERLINE_TEXT_FLAG

        //리스트뷰
        makeListView(dummyPost)

        //홈피드 눌렀을 때 데이터 로딩
        mainBtn.setOnClickListener {
            changeMain(mainText, popularText)
        }

        //인기글 눌렀을 때 데이터 로딩
        popularBtn.setOnClickListener {
            changePopular(mainText, popularText)
        }


        //마이페이지 이동
        myPageBtn.setOnClickListener {
            goMyPage()
        }

        //로그아웃
        logoutBtn.setOnClickListener {
            doLogout()
        }
    }

    private fun changeMain(mainText: TextView, popularText: TextView) {
        if (!isHome) {
            //홈피드 데이터로 교체
            makeListView(dummyPost)

            mainText.paintFlags = Paint.UNDERLINE_TEXT_FLAG
            popularText.paintFlags = mainText.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

            isHome = true
            isPopular = false
        }
    }

    private fun changePopular(mainText: TextView, popularText: TextView) {
        if (!isPopular) {
            //좋아요 30 이상 데이터만 표시
            val popularPost =
                ArrayList(dummyPost.filter { it.like >= 30 }.sortedByDescending { it.like })

            //인기 피드 데이터로 교체
            makeListView(popularPost)

            popularText.paintFlags = Paint.UNDERLINE_TEXT_FLAG
            mainText.paintFlags = mainText.paintFlags and Paint.UNDERLINE_TEXT_FLAG.inv()

            isPopular = true
            isHome = false
        }
    }

    private fun makeListView(dummyPost: ArrayList<MainPageItem>) {
        //화면에 리스트뷰 그려주기
        val itemAdapter = MainPageAdapter(this, dummyPost)
        val itemListView = findViewById<ListView>(R.id.mainListView)
        itemListView.adapter = itemAdapter

        //특정 아이템 클릭 시
        itemListView.setOnItemClickListener { adapterView, view, i, l ->
            val clickedItem = dummyPost[i]

            //디테일페이지로 데이터 넘기기
            val intent = Intent(this, DetailPageActivity::class.java)
            intent.putExtra("index", i)
            intent.putExtra("userName", clickedItem.userName)
            intent.putExtra("userImage", clickedItem.userImage)
            intent.putExtra("postImage", clickedItem.postImage)
            intent.putExtra("postTitle", clickedItem.postTitle)
            intent.putExtra("postSummary", clickedItem.postSummary)
            intent.putExtra("postLike", clickedItem.isLike)
            intent.putExtra("postLikeCount", clickedItem.like)
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

