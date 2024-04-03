package com.example.nbc_givehub

import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailPageActivity : AppCompatActivity(), View.OnClickListener {

    //상호작용 버튼 선언
    private var backBtn : ImageButton? = null
    private var viewBtn : TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailpage)

        //포스트 데이터 넘겨 받음
        val postData = intent.getStringExtra("data")

        //포스트 데이터 띄우기
        setContents(postData ?: "데이터가 없습니다.")

        //상호작용 버튼에 뷰 요소 넣기
        backBtn = findViewById(R.id.btn_detail_back)!!
        viewBtn = findViewById(R.id.tv_more_less)!!
    }

    //뷰에서 클릭 발생 시 시작 처리
    override fun onStart() {
        super.onStart()
        backBtn!!.setOnClickListener(this)
        viewBtn!!.setOnClickListener(this)
    }

    //뷰에서 클릭 발생 시 처리
    override fun onClick(v: View?) {
        //뒤로가기 버튼
        if (v?.id == R.id.btn_detail_back) {
            Log.d("여기는 디테일 페이지", "뒤로가기 누르는건 감지가 된다")
            finish()
        }

        //더보기, 내용 접기 버튼
        if (v?.id == R.id.tv_more_less) {

            Log.d("여기는 디테일 페이지", "누르는건 감지가 된다")

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
    }

    private fun setContents(data: String) {
        val title = findViewById<TextView>(R.id.tv_detail_title)
        val userImage = findViewById<ImageView>(R.id.img_detail_profile)
        val usetName = findViewById<TextView>(R.id.tv_detail_user)
        val contents = findViewById<TextView>(R.id.tv_detail_contents)
        val postImage = findViewById<ImageView>(R.id.img_detail_post_image)

        val titlePattern = "postTitle=(.*?),".toRegex()
        val titleMatch = titlePattern.find(data)?.groupValues?.get(1)
        title.setText(titleMatch.toString())

        val userImagePattern = "userImage=(.*?),".toRegex()
        val userImageMatch = userImagePattern.find(data)?.groupValues?.get(1)
        val userImageResource = resources.getIdentifier(userImageMatch, "drawable", packageName)
        userImage.setImageResource(userImageResource)

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