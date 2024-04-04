package com.example.nbc_givehub

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_givehub.MainPageItem.Companion.dummyPostData

class DetailPageActivity : AppCompatActivity(), View.OnClickListener {

    //상호작용 버튼 선언
    private var backBtn : ImageButton? = null
    private var viewBtn : TextView? = null
    private var likeBtn : ImageView? = null

    //좋아요 여부 확인
    private var isLike : Boolean? = null
    private var index : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailpage)

        //포스트 데이터 띄우기
        setContents()

        //상호작용 버튼에 뷰 요소 넣기
        backBtn = findViewById(R.id.btn_detail_back)!!
        viewBtn = findViewById(R.id.tv_more_less)!!
        likeBtn = findViewById(R.id.btn_like)!!
    }

    //뷰에서 클릭 발생 시 시작 처리
    override fun onStart() {
        super.onStart()
        backBtn!!.setOnClickListener(this)
        viewBtn!!.setOnClickListener(this)
        likeBtn!!.setOnClickListener(this)
    }

    //뷰에서 클릭 발생 시 처리
    override fun onClick(v: View?) {
        //뒤로가기 버튼
        if (v?.id == R.id.btn_detail_back) {
            val intent = Intent(this, MainPageActivity::class.java)
            startActivity(intent)
            finish()
        }

        //더보기, 내용 접기 버튼
        if (v?.id == R.id.tv_more_less) {
            val contents = findViewById<TextView>(R.id.tv_detail_contents)

            if (contents.layout.getEllipsisCount(contents.layout.lineCount - 1) > 0 ) {
                contents.maxLines = Int.MAX_VALUE
                viewBtn?.setText(R.string.viewLess)
            }
            else {
                contents.maxLines = 7
                contents.ellipsize = TextUtils.TruncateAt.END
                viewBtn?.setText(R.string.viewMore)
            }
        }

        //좋아요 버튼
        if (v?.id == R.id.btn_like) {
            var dummyPost = dummyPostData()
            var thisPost = dummyPost[index ?: 0]

            //좋아요가 눌러져 있으면
            if (isLike!!) {
                Log.d("여기는 디테일 페이지", "좋아요가 눌러져 있었음")

                thisPost.like--

                val thisLike = findViewById<ImageView>(R.id.btn_like)
                thisLike.setImageResource(R.drawable.img_detail_like_empty)
                isLike = false
                thisPost.isLike = false
            } else {
                //좋아요가 눌러져 있지 않으면
                Log.d("여기는 디테일 페이지", "좋아요가 눌러져 있지 않았음")

                thisPost.like++

                val thisLike = findViewById<ImageView>(R.id.btn_like)
                thisLike.setImageResource(R.drawable.img_detail_like)
                isLike = true
                thisPost.isLike = true
            }
        }
    }

    private fun setContents() {
        //포스트 데이터 넘겨 받음
        val userName = intent.getStringExtra("userName")
        val userImage = intent.getIntExtra("userImage", 0)
        val postImage = intent.getIntExtra("postImage", 0)
        val postTitle = intent.getStringExtra("postTitle")
        val postSummary = intent.getStringExtra("postSummary")
        val postIsLike = intent.getBooleanExtra("postLike", false)
        val postIndex = intent.getIntExtra("index", 0)

        //화면에 데이터 출력
        val thisUsetName = findViewById<TextView>(R.id.tv_detail_user)
        val thisUserImage = findViewById<ImageView>(R.id.img_detail_profile)
        val thisPostImage = findViewById<ImageView>(R.id.img_detail_post_image)
        val thisTitle = findViewById<TextView>(R.id.tv_detail_title)
        val thisContents = findViewById<TextView>(R.id.tv_detail_contents)
        val thisLike = findViewById<ImageView>(R.id.btn_like)

        thisUsetName.setText(userName)

        val imageResource = resources.getIdentifier(postImage.toString(), "drawable", packageName)
        thisPostImage.setImageResource(imageResource)

        thisTitle.setText(postTitle)

        val userImageResource = resources.getIdentifier(userImage.toString(), "drawable", packageName)
        thisUserImage.setImageResource(userImageResource)

        thisContents.setText(postSummary)

        if (!postIsLike) { //좋아요가 눌러져 있지 않으면
            thisLike.setImageResource(R.drawable.img_detail_like_empty)
            isLike = false
        } else {
            thisLike.setImageResource(R.drawable.img_detail_like)
            isLike = true
        }

        index = postIndex
    }
}