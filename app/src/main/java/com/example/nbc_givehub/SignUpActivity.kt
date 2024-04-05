package com.example.nbc_givehub

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_givehub.UserData.Companion.createUser
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    var nameCheck = false
    var idCheck = false
    var pwCheck = false
    var pwCheck2 = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        val signUpName = findViewById<EditText>(R.id.singUpName)
        val signUpId = findViewById<EditText>(R.id.singUpId)
        val signUpPw = findViewById<EditText>(R.id.singUpPw)
        val signUpPwDoubleCheck = findViewById<EditText>(R.id.singUpPwDobleCheck)

        val signUpNameCheck = findViewById<ImageView>(R.id.singUpNameCheck)
        val signUpIdCheck = findViewById<ImageView>(R.id.singUpIdCheck)
        val signUpPwCheck = findViewById<ImageView>(R.id.singUpPwCheck)
        val singUpPwDobleCheck2 = findViewById<ImageView>(R.id.singUpPwDobleCheck2)

        val signUpBt = findViewById<Button>(R.id.signUpBt)
        val signUpBackBt = findViewById<TextView>(R.id.singUpBack)

        signUpBt.isEnabled = false

        //버튼 활성화
        fun btOnOff(){
            if (nameCheck && idCheck && pwCheck&& pwCheck2){
                signUpBt.isEnabled = true
                signUpBt.setBackgroundResource(R.drawable.buttoncustom)
            }else {
                signUpBt.isEnabled = false
                signUpBt.setBackgroundResource(R.drawable.buttoncustom2)
            }
        }


        //이름 확인
        signUpName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (signUpName.text.isNotBlank()) {
                    signUpNameCheck.setImageResource(R.drawable.icon_check_mark)
                    nameCheck = true
                } else {
                    signUpNameCheck.setImageResource(R.drawable.x_icon)
                    nameCheck = false
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        //아이디 확인
        signUpId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (idPatternCheck(signUpId.text.toString())) {
                    signUpIdCheck.setImageResource(R.drawable.icon_check_mark) //유효성 검사 완료되면 체크표시
                } else {
                    signUpIdCheck.setImageResource(R.drawable.x_icon)
                    idCheck = false
                }
                btOnOff()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        //비밀번호 확인
        signUpPw.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (pwPatternCheck(signUpPw.text.toString())) {
                    signUpPwCheck.setImageResource(R.drawable.icon_check_mark)
                    pwCheck = true
                } else {
                    signUpPwCheck.setImageResource(R.drawable.x_icon)
                    pwCheck = false
                }
                btOnOff()
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        //회원가입 버튼
        //비밀번호 재확인
        signUpPwDoubleCheck.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (signUpPw.text.toString() == signUpPwDoubleCheck.text.toString()) {
                    singUpPwDobleCheck2.setImageResource(R.drawable.icon_check_mark)
                    pwCheck2 = true
                } else {
                    singUpPwDobleCheck2.setImageResource(R.drawable.x_icon)
                    pwCheck2 = false
                }
                btOnOff()
            }
            override fun afterTextChanged(p0: Editable?) {
            }})
                //아이디 중복 없을 시
                if (idCheck(signUpId.text.toString())) {
                        //회원정보를 리스트에 저장
                        createUser(
                            signUpId.text.toString(),
                            signUpPw.text.toString(),
                            signUpName.text.toString()
                        )

                    Toast.makeText(this, R.string.signupComplete, Toast.LENGTH_SHORT).show()
                        //로그인 화면으로 데이터 넘김
                        val intent = Intent(this, LoginActivity::class.java).apply {
                            putExtra("SingIn_ID", signUpId.text.toString())
                            putExtra("SingIn_PW", signUpPw.text.toString())}
                        setResult(Activity.RESULT_OK, intent)
                        slideLeft()
                        finish()
                }
                //아이디 중복 있을 시
                else {
                    Toast.makeText(this, R.string.idHint, Toast.LENGTH_SHORT).show()
                }
            }
        //뒤로가기 버튼
        signUpBackBt.setOnClickListener {
            finish()
            slideUp()
        }
    }


    //아이디 유효성 검사
    fun idPatternCheck(id: String): Boolean {
        val idPattern =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" // 이메일
        return (Pattern.matches(idPattern, id))
    }

    //비밀번호 유효성 검사
    fun pwPatternCheck(pw: String): Boolean {
        val pwPattern =
            "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{8,20}$" // 영문, 숫자, 특수문자, 8~20자 이내
        return (Pattern.matches(pwPattern, pw))
    }

    //중복 아이디 확인
    fun idCheck(id: String): Boolean {
        var boolean = true
        val dummy = UserData.showlist()
        for (i in UserData.showlist().indices) {
            if (id == dummy[i].id) {
                boolean = false
                break
            }
        }
        return boolean
    }

}
