package com.example.nbc_givehub

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_givehub.MainPageItem.Companion.dummyPostData
import de.hdodenhof.circleimageview.CircleImageView

class DetailPageActivity : AppCompatActivity(), View.OnClickListener {

    //상호작용 버튼 선언
    lateinit var backBtn : ImageButton
    lateinit var viewBtn : TextView
    lateinit var likeBtn : ImageView

    //프로필 선택 시 유저 페이지
    lateinit var userImg : CircleImageView
    lateinit var userName : TextView

    //좋아요 관련 변수
    var isLike : Boolean = false
    var index : Int = 0
    lateinit var likeCount : TextView

    //더미 포스트 변수
    var dummyPost = dummyPostData()
    lateinit var thisPost : MainPageItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailpage)

        userImg = findViewById(R.id.img_detail_profile)
        userName = findViewById(R.id.tv_detail_user)

        //상호작용 버튼에 뷰 요소 넣기
        backBtn = findViewById(R.id.btn_detail_back)
        viewBtn = findViewById(R.id.tv_more_less)
        likeBtn = findViewById(R.id.btn_like)

        likeCount = findViewById(R.id.tv_like)

        //포스트 데이터 띄우기
        setContents()
    }

    //뷰에서 클릭 발생 시 시작 처리
    override fun onStart() {
        super.onStart()
        backBtn.setOnClickListener(this)
        viewBtn.setOnClickListener(this)
        likeBtn.setOnClickListener(this)
        userImg.setOnClickListener(this)
    }

    //뷰에서 클릭 발생 시 처리
    override fun onClick(v: View?) {
        val uName = intent.getStringExtra("userName")
        val uImage = intent.getIntExtra("userImage", 0)

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
                viewBtn.setText(R.string.viewLess)
            }
            else {
                contents.maxLines = 7
                contents.ellipsize = TextUtils.TruncateAt.END
                viewBtn.setText(R.string.viewMore)
            }
        }

        //좋아요 버튼
        if (v?.id == R.id.btn_like) {
            var thisPost = dummyPost[index - 1]

            //좋아요가 눌러져 있으면
            if (isLike) {
                Log.d("여기는 디테일 페이지", "좋아요가 눌러져 있었음")

                thisPost.like--
                likeCount.setText(thisPost.like.toString())

                val thisLike = findViewById<ImageView>(R.id.btn_like)
                thisLike.setImageResource(R.drawable.img_detail_like_empty)
                isLike = false
                thisPost.isLike = false

            } else {
                //좋아요가 눌러져 있지 않으면
                Log.d("여기는 디테일 페이지", "좋아요가 눌러져 있지 않았음")

                thisPost.like++
                likeCount.setText(thisPost.like.toString())

                val thisLike = findViewById<ImageView>(R.id.btn_like)
                thisLike.setImageResource(R.drawable.img_detail_like)
                isLike = true
                thisPost.isLike = true
            }
        }

        //프로필 버튼
        if(v?.id == R.id.img_detail_profile){
            var intent = Intent(this, UserPageActivity::class.java)
            intent.putExtra("name", uName)
            intent.putExtra("img", uImage)
            startActivity(intent)
        }
    }

    private fun setContents() {
        //포스트 데이터 넘겨 받음
        val postId = intent.getIntExtra("id", 0)
        //val postItem = intent.getSerializableExtra("item") as MainPageItem?
        thisPost = (intent.getSerializableExtra("item") as MainPageItem?)!!

        //화면에 데이터 출력
        val thisUserName = findViewById<TextView>(R.id.tv_detail_user)
        val thisUserImage = findViewById<ImageView>(R.id.img_detail_profile)
        val thisPostImage = findViewById<ImageView>(R.id.img_detail_post_image)
        val thisTitle = findViewById<TextView>(R.id.tv_detail_title)
        val thisContents = findViewById<TextView>(R.id.tv_detail_contents)
        val thisLike = findViewById<ImageView>(R.id.btn_like)

        thisUserName.setText(thisPost.userName)

        val imageResource = resources.getIdentifier(thisPost.postImage.toString(), "drawable", packageName)
        thisPostImage.setImageResource(imageResource)

        thisTitle.setText(thisPost.postTitle)

        val userImageResource = resources.getIdentifier(thisPost.userImage.toString(), "drawable", packageName)
        thisUserImage.setImageResource(userImageResource)

        thisContents.setText(Html.fromHtml(thisPost.postSummary))

        //좋아요가 눌러져 있으면
        if (thisPost.isLike ?: false) {
            thisLike.setImageResource(R.drawable.img_detail_like)
            isLike = true
        } else {
            thisLike.setImageResource(R.drawable.img_detail_like_empty)
            isLike = false
        }

        likeCount.setText(thisPost.like.toString())

        index = postId
    }
}