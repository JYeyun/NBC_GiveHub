package com.example.nbc_givehub

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_givehub.MainPageItem.Companion.dummyPostData
import com.example.nbc_givehub.UserData.Companion.showlist

class UserPageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_mypage)
        enableEdgeToEdge()

        val name = intent.getStringExtra("name")?: "Unknown"
        val userImg = intent.getIntExtra("img", 0)?: "Unknown"

        var img = findViewById<ImageView>(R.id.mypage_profile_img)
        var user_name = findViewById<TextView>(R.id.mypage_name)
        var user_language = findViewById<TextView>(R.id.mypage_language)
        var user_mbti = findViewById<TextView>(R.id.mypage_mbti)
        var user_git = findViewById<TextView>(R.id.mypage_git)
        var user_blog = findViewById<TextView>(R.id.mypage_blog)
        var user_btn = findViewById<ImageButton>(R.id.mypage_arrow)
        var edit_btn = findViewById<Button>(R.id.mypage_edit)

        edit_btn.visibility = Button.INVISIBLE

        val imageResource = resources.getIdentifier(userImg.toString(), "drawable", packageName)
        img.setImageResource(imageResource)

        //더미 데이터 적용 코드
        val userlist = showlist()
        val select_user = userlist.indices.find{userlist[it].name == name}
        user_name.setText(userlist[select_user!!].name)
        user_language.setText(userlist[select_user!!].launguage)
        user_mbti.setText(userlist[select_user!!].mbti)
        user_git.setText(userlist[select_user!!].git)
        user_blog.setText(userlist[select_user!!].blog)

        val itemList = ArrayList<MainPageItem>()
        val dummyList = dummyPostData()
        for(i in dummyList.indices){
            if(dummyList[i].userName == userlist[select_user!!].name) itemList.add(dummyList[i])
        }

        //화면에 리스트뷰 그려주기
        val itemAdapter = MainPageAdapter(this, itemList)
        val itemListView = findViewById<ListView>(R.id.mypage_listview)
        itemListView.adapter = itemAdapter

        //특정 아이템 클릭 시
        itemListView.setOnItemClickListener{ adapterView, view, i, l ->
            val clickedItem = itemList[i]
            val intent = Intent(this, DetailPageActivity::class.java)
            intent.putExtra("userName", clickedItem.userName)
            intent.putExtra("userImage", clickedItem.userImage)
            intent.putExtra("postImage", clickedItem.postImage)
            intent.putExtra("postTitle", clickedItem.postTitle)
            intent.putExtra("postSummary", clickedItem.postSummary)

            startActivity(intent)
            slideLeft()
        }
        user_btn.setOnClickListener { finish() }
    }
}