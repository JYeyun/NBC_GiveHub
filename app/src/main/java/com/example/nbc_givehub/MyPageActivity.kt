package com.example.nbc_givehub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.nbc_givehub.UserData.Companion.dummydata
import java.util.Random

class MyPageActivity : AppCompatActivity() {
    var random = Random()
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

        var cpt_btn = findViewById<Button>(R.id.mypage_complete)
        var edit_btn = findViewById<Button>(R.id.mypage_edit)
        var edit_launguage = findViewById<EditText>(R.id.mypage_edit_language)
        var edit_mbti = findViewById<EditText>(R.id.mypage_edit_mbti)
        var edit_git = findViewById<EditText>(R.id.mypage_edit_git)
        var edit_blog = findViewById<EditText>(R.id.mypage_edit_blog)

        //더미 데이터 적용 코드
        val dummy = dummydata()
        val randummy = random.nextInt(4)
        mp_name.setText(dummy[randummy].name)
        mp_language.setText(dummy[randummy].launguage)
        mp_mbti.setText(dummy[randummy].mbti)
        mp_git.setText(dummy[randummy].git)
        mp_blog.setText(dummy[randummy].blog)

        // 랜덤 이미지 적용
        var ranimg = random.nextInt(3)
        var imgnum = ""
        when(ranimg){
            0 -> {
                img.setImageResource(R.drawable.img1)
                imgnum = "img1"
            }
            1 -> {
                img.setImageResource(R.drawable.img2)
                imgnum = "img2"
            }
            2 -> {
                img.setImageResource(R.drawable.img3)
                imgnum = "img3"
            }
            3 -> {
                img.setImageResource(R.drawable.img4)
                imgnum = "img4"
            }
        }

        // 리스트뷰 더미 리스트
        val itemList = arrayListOf(
            MainPageItem(imgnum, dummy[randummy].name,"mainpage_img_thumnail", "포스트1 제목", "포스트1 내용"),
            MainPageItem(imgnum, dummy[randummy].name, "mainpage_img_thumnail", "포스트2 제목", "포스트2 내용"),
            MainPageItem(imgnum, dummy[randummy].name, "mainpage_img_thumnail", "포스트3 제목", "포스트3 내용")
        )

        //화면에 리스트뷰 그려주기
        val itemAdapter = MainPageAdapter(this, itemList)
        val itemListView = findViewById<ListView>(R.id.mypage_listview)
        itemListView.adapter = itemAdapter

        //특정 아이템 클릭 시
        itemListView.setOnItemClickListener{ adapterView, view, i, l ->
            val clickedItem = itemList[i]
            val intent = Intent(this, DetailPageActivity::class.java)
            intent.putExtra("data", clickedItem.toString())
            startActivity(intent)
        }

        edit_btn.setOnClickListener {
            edit_btn.visibility = Button.INVISIBLE
            mp_language.visibility = TextView.INVISIBLE
            mp_mbti.visibility = TextView.INVISIBLE
            mp_git.visibility = TextView.INVISIBLE
            mp_blog.visibility = TextView.INVISIBLE

            cpt_btn.visibility = EditText.VISIBLE
            edit_launguage.visibility = EditText.VISIBLE
            edit_mbti.visibility = EditText.VISIBLE
            edit_git.visibility = EditText.VISIBLE
            edit_blog.visibility = EditText.VISIBLE
        }
        cpt_btn.setOnClickListener {
            mp_language.text = edit_launguage.text
            mp_mbti.text = edit_mbti.text
            mp_git.text = edit_git.text
            mp_blog.text = edit_blog.text

            edit_btn.visibility = Button.VISIBLE
            mp_language.visibility = TextView.VISIBLE
            mp_mbti.visibility = TextView.VISIBLE
            mp_git.visibility = TextView.VISIBLE
            mp_blog.visibility = TextView.VISIBLE

            cpt_btn.visibility = EditText.INVISIBLE
            edit_launguage.visibility = EditText.GONE
            edit_mbti.visibility = EditText.INVISIBLE
            edit_git.visibility = EditText.INVISIBLE
            edit_blog.visibility = EditText.INVISIBLE
        }
        mp_btn.setOnClickListener { finish() }
    }
}