package com.example.nbc_givehub

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class LoginActivity : AppCompatActivity() {
    private lateinit var signInBtn: Button
    private lateinit var signUpBtn: Button
    private lateinit var signUpActivityResultLauncher: ActivityResultLauncher<Intent>
    private lateinit var userId: EditText
    private lateinit var userPw: EditText
    private var id = ""
    private var pw = ""

    val userInfo = listOf(
        UserInfo("정예윤", "Boss", "1"),
        UserInfo("정지연", "Captain", "2"),
        UserInfo("윤영진", "1", "3"),
        UserInfo("안진혁", "2", "4"),
        UserInfo("장규식", "3", "5")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        signInBtn = findViewById(R.id.btn_signIn)
        signUpBtn = findViewById(R.id.btn_creatAccount)
        userId = findViewById(R.id.et_id)
        userPw = findViewById(R.id.et_pw)

        signUpActivityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val data: Intent? = result.data
                    id = data?.getStringExtra("SingIn_ID")?:""
                    pw = data?.getStringExtra("SingIn_PW")?:""
                    userId.setText(id)

                    //Todo 이메일 데이터 가져오기
                }
            }


        signInBtn.setOnClickListener {
            checkIdAndPassword()
        }
        goSignUp()
    }

    private fun checkIdAndPassword() {//email과 password란에 값을 입력했는 지 확인하는 함수
        if (userId.text.isBlank()) {
            Toast.makeText(this, R.string.idHint, Toast.LENGTH_SHORT).show()
        } else if (userPw.text.isBlank()) {
            Toast.makeText(this, R.string.pwHint, Toast.LENGTH_SHORT).show()
        } else checkAll()
    }

    private fun checkAll() { // 아이디를 비교하는 함수
        val inputId = userId.text.toString()
        val inputPw = userPw.text.toString()
        val user = userInfo.find { it.Id == inputId && it.Pw == inputPw }
        if (user != null) {
            sendToMain(user.Id)
        }else if(inputId == id && inputPw == pw){
            intent.putExtra("id",id)
            intent.putExtra("pw",pw)
            sendToMain(id)
        }
        else
            Toast.makeText(this,R.string.idPwCheck, Toast.LENGTH_SHORT).show()
    }

    //회원가입 페이지에서 이메일만 가져옴
    private fun goSignUp() { //회원가입 버튼 누르기
        signUpBtn.setOnClickListener {
            val signUpIntent = Intent(this, SignUpActivity::class.java)
            signUpActivityResultLauncher.launch(signUpIntent)
            slideUp()
        }
    }

    private fun sendToMain(logInName: String) { //메인 화면으로 Id 전달
        val intent = Intent(this, MainPageActivity::class.java)
        intent.putExtra("id", logInName)
        startActivity(intent)
        slideLeft()
    }

    override fun onStop() {
        super.onStop()
        userId.text.clear()
    }

    data class UserInfo(
        val name: String,
        val Id: String,
        val Pw: String
    )
}