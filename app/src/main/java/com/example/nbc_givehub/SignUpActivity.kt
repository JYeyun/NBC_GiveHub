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
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.nbc_givehub.UserData.Companion.createUser
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    var nameCheck = false
    var idCheck = false
    var pwCheck = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)
        val sginUpName = findViewById<EditText>(R.id.singUpName)
        val sginUpId = findViewById<EditText>(R.id.singUpId)
        val sginUpPw = findViewById<EditText>(R.id.singUpPw)
        val sginUpNameCheck = findViewById<ImageView>(R.id.singUpNameCheck)
        val sginUpIdCheck = findViewById<ImageView>(R.id.singUpIdCheck)
        val sginUpPwCheck = findViewById<ImageView>(R.id.singUpPwCheck)

        val sginUpBt = findViewById<Button>(R.id.signUpBt)
        val sginUpBackBt = findViewById<Button>(R.id.singUpBack)


        //이름 확인
        sginUpName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (sginUpName.text.isNotBlank()) {
                    sginUpNameCheck.setImageResource(R.drawable.icon_check_mark)
                    nameCheck = true
                } else {
                    sginUpNameCheck.setImageResource(R.drawable.x_icon)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        //아이디 확인
        sginUpId.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (idPatternCheck(sginUpId.text.toString())) {
                    sginUpIdCheck.setImageResource(R.drawable.icon_check_mark) //유효성 검사 완료되면 체크표시
                    idCheck = true
                } else {
                    sginUpIdCheck.setImageResource(R.drawable.x_icon)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        //비밀번호 확인
        sginUpPw.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (pwPatternCheck(sginUpPw.text.toString())) {
                    sginUpPwCheck.setImageResource(R.drawable.icon_check_mark)
                    pwCheck = true
                } else {
                    sginUpPwCheck.setImageResource(R.drawable.x_icon)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })

        //회원가입 버튼
        sginUpBt.setOnClickListener {
            //정보 누락 시
            if (sginUpName.text.isBlank() || sginUpId.text.isBlank() || sginUpPw.text.isBlank()) {
                Toast.makeText(this, R.string.idHint, Toast.LENGTH_SHORT).show()
            }
            //모든 정보 입력 시
            else {
                //아이디 중복 없을 시
                if (idCheck(sginUpId.text.toString())) {
                    //모든 항목이 적절하게 입력되었으면
                    if (nameCheck && idCheck && pwCheck) {
                        //회원정보를 리스트에 저장
                        createUser(
                            sginUpId.text.toString(),
                            sginUpPw.text.toString(),
                            sginUpName.text.toString()
                        )

                        Toast.makeText(this, R.string.idHint, Toast.LENGTH_SHORT).show()

                        //로그인 화면으로 데이터 넘김
                        val intent = Intent(this, LoginActivity::class.java).apply {
                            putExtra("SingIn_ID", sginUpId.text.toString())
                            putExtra("SingIn_PW", sginUpPw.text.toString())
                        }
                        setResult(Activity.RESULT_OK, intent)
                        slideLeft()

                        //액티비티 강제 종료
                        if (!isFinishing) {
                            finish()
                        }
                    } else {
                        Toast.makeText(this, R.string.idHint, Toast.LENGTH_SHORT).show()
                    }
                }
                //아이디 중복 있을 시
                else {
                    Toast.makeText(this, R.string.idHint, Toast.LENGTH_SHORT).show()
                }
            }
        }
        //뒤로가기 버튼
        sginUpBackBt.setOnClickListener {
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
