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
                    //Todo 이메일 데이터 가져오기
                }
            }

        signInBtn.setOnClickListener {
            checkIdAndPassword()
        }
        goSignUp()
    }


    private fun checkIdAndPassword() {
        if (userId.text.isBlank()) {
            Toast.makeText(this, "이메일을 입력하세요", Toast.LENGTH_SHORT).show()
        } else if (userPw.text.isBlank()) {
            Toast.makeText(this, "비밀번호를 입력하세요", Toast.LENGTH_SHORT).show()
        } else checkAll()
    }

    private fun checkAll() {
        val inputId = userId.text.toString()
        val inputPw = userPw.text.toString()
        //Todo 아이디 비교 로직 if (inputId == )

        //sendIdToMain()//로그인 성공 시 메인 화면으로 데이터 전달
    }

    private fun goSignUp() {
        signUpBtn.setOnClickListener {
            val signUpIntent = Intent(this, SignUpActivity::class.java)
            signUpActivityResultLauncher.launch(signUpIntent)
        }
    }

    private fun sendIdToMain() { //메인 화면으로 Id 전달
        val intent = Intent(this, MainPageActivity::class.java)
        intent.putExtra("id", userId.text)
    }
}